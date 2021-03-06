package open.tresorier.api

import io.javalin.Javalin
import io.javalin.http.Context
import io.supertokens.javalin.SuperTokens
import io.supertokens.javalin.core.exception.SuperTokensException
import open.tresorier.dependenciesinjection.ServiceManager
import open.tresorier.exception.TresorierException
import open.tresorier.exception.TresorierIllegalException
import open.tresorier.model.*
import open.tresorier.utils.Properties
import java.util.Properties as JavaProperties


fun main() {

    val properties = Properties.getProperties()
    val app = setUpApp(properties)

    // Session Manager
    SuperTokens.config().withHosts(
        properties.getProperty("supertoken_url"),
        properties.getProperty("supertoken_api_key")
    )
    // Dependencies injection
    ServiceManager.start()

    app.before("/session/refresh", SuperTokens.middleware())
    app.post("/session/refresh") { ctx -> ctx.result("refreshed") }

    app.get("/") { ctx ->
        ctx.result("Hello Sunshine !")
    }

    app.get("/error") { ctx ->
        val exception = TresorierException("this is your doing", Exception("why ?"))
        ctx.result(exception.id)
    }

    app.get("/ping") { ctx ->
        ctx.json(properties.getProperty("environment"))
    }

    app.post("/person") { ctx ->
        val name = ctx.queryParam<String>("name").get()
        val password = ctx.queryParam<String>("password").get()
        val email = ctx.queryParam<String>("email").get()
        val person: Person = ServiceManager.personService.createPerson(name, password, email)
        ctx.json(person.name + " was successfully created")
    }

    app.post("/login") { ctx ->
        val email = getQueryParam<String>(ctx, "email")
        val password = getQueryParam<String>(ctx, "password")
        val person: Person? = ServiceManager.personService.login(email, password)
        if (person == null) {
            val unlockingDate = ServiceManager.personService.getUnlockingDateForEmail(email)
            ctx.status(400)
            ctx.json("{\"unlockingDate\" : $unlockingDate}")
        }
        person?.let {
            SuperTokens.newSession(ctx, it.id).create()
            ctx.json("{\"name\" : " + it.name + "}")
        }
    }

    app.before("/logout", SuperTokens.middleware())
    app.delete("/logout") { ctx ->
        val session = SuperTokens.getFromContext(ctx)
        session.revokeSession()
        ctx.json("you've been logged out")
    }

    app.before("/budget", SuperTokens.middleware())
    app.post("/budget") { ctx ->
        val user = getUserFromAuth(ctx)
        val name = getQueryParam<String>(ctx, "name")
        val budget: Budget = ServiceManager.budgetService.create(user, name)
        ctx.json(budget.id)
    }

    app.put("/budget") { ctx ->
        val user = getUserFromAuth(ctx)
        val budget: Budget = ServiceManager.budgetService.getById(user, getQueryParam<String>(ctx, "budget_id"))
        val formerName = budget.name
        val newName = getQueryParam<String>(ctx, "new_name")
        ServiceManager.budgetService.update(user, budget, newName)
        ctx.json("updated from $formerName to $newName")
    }

    app.delete("/budget") { ctx ->
        val user = getUserFromAuth(ctx)
        val budget: Budget = ServiceManager.budgetService.getById(user, getQueryParam<String>(ctx, "budget_id"))
        ServiceManager.budgetService.delete(user, budget)
        ctx.json("budget ${budget.name} has been deleted")
    }

    app.before("/budget/user", SuperTokens.middleware())
    app.get("/budget/user") { ctx ->
        val user = getUserFromAuth(ctx)
        val budgetList = ServiceManager.budgetService.findByUser(user)
        ctx.json(budgetList)
    }

    app.before("/budget/data", SuperTokens.middleware())
    app.get("/budget/data") { ctx ->
        // required
        val user = getUserFromAuth(ctx)
        val budget: Budget = ServiceManager.budgetService.getById(user, getQueryParam<String>(ctx, "budget_id"))
        // optional
        val startMonth: Month? = getOptionalQueryParam<Int>(ctx, "start_month")?.let { Month.createFromComparable(it)}
        val endMonth: Month? = getOptionalQueryParam<Int>(ctx, "end_month")?.let { Month.createFromComparable(it)}
        val budgetData = ServiceManager.budgetDataService.getBudgetData(user, budget, startMonth, endMonth)
        ctx.json(budgetData)
    }

    app.before("/budget/amount", SuperTokens.middleware())
    app.get("/budget/amount") { ctx ->
        // required
        val user = getUserFromAuth(ctx)
        val budget: Budget = ServiceManager.budgetService.getById(user, getQueryParam<String>(ctx, "budget_id"))
        // optional
        val month: Month? = getOptionalQueryParam<Int>(ctx, "month")?.let { Month.createFromComparable(it)}
        val budgetData = ServiceManager.budgetDataService.getBudgetAmount(user, budget, month)
        ctx.json(budgetData)
    }

    app.before("/account", SuperTokens.middleware())
    app.post("/account") { ctx ->
        val user = getUserFromAuth(ctx)
        val budget: Budget = ServiceManager.budgetService.getById(user, getQueryParam<String>(ctx, "budget_id"))
        val name = getQueryParam<String>(ctx, "name")
        val amount = getQueryParam<Int>(ctx, "amount")
        val day = Day.createFromComparable(getQueryParam<Int>(ctx, "day"))
        val account = ServiceManager.accountService.create(user, budget, name, day, amount)
        ctx.json(account)
    }

    app.put("/account") { ctx ->
        val user = getUserFromAuth(ctx)
        val account: Account = ServiceManager.accountService.getById(user, getQueryParam<String>(ctx, "account_id"))
        val formerName = account.name
        val newName = getQueryParam<String>(ctx, "new_name")
        ServiceManager.accountService.update(user, account, newName)
        ctx.json("updated from $formerName to $newName")
    }

    app.delete("/account") { ctx ->
        val user = getUserFromAuth(ctx)
        val account: Account = ServiceManager.accountService.getById(user, getQueryParam<String>(ctx, "account_id"))
        ServiceManager.accountService.delete(user, account)
        ctx.json("account ${account.name} has been deleted")
    }

    app.before("/account/budget", SuperTokens.middleware())
    app.get("/account/budget") { ctx ->
        val user = getUserFromAuth(ctx)
        val budget: Budget = ServiceManager.budgetService.getById(user, getQueryParam<String>(ctx, "budget_id"))
        val accounts = ServiceManager.accountService.findByBudget(user, budget)
        ctx.json(accounts)
    }

    app.before("/mcategory", SuperTokens.middleware())
    app.post("/mcategory") { ctx ->
        val user = getUserFromAuth(ctx)
        val budget: Budget = ServiceManager.budgetService.getById(user, getQueryParam<String>(ctx, "budget_id"))
        val name = getQueryParam<String>(ctx, "name")

        val mcategory = ServiceManager.masterCategoryService.create(user, budget, name)
        ctx.json(mcategory)
    }

    app.put("/mcategory") { ctx ->
        val user = getUserFromAuth(ctx)
        val masterCategory: MasterCategory = ServiceManager.masterCategoryService.getById(user, getQueryParam<String>(ctx, "id"))

        //optional
        val newName = getOptionalQueryParam<String>(ctx, "new_name")
        val newArchived = getOptionalQueryParam<Boolean>(ctx, "new_archived")
        val newDeleted = getOptionalQueryParam<Boolean>(ctx, "new_deleted")

        val updatedMasterCategory = ServiceManager.masterCategoryService.update(user, masterCategory, newName, newArchived, newDeleted)
        ctx.json(updatedMasterCategory)
    }

    app.before("/mcategory/budget", SuperTokens.middleware())
    app.get("/mcategory/budget") { ctx ->
        val user = getUserFromAuth(ctx)
        val budget: Budget = ServiceManager.budgetService.getById(user, getQueryParam<String>(ctx, "budget_id"))

        val masterCategories = ServiceManager.masterCategoryService.findByBudget(user, budget)
        ctx.json(masterCategories)
    }

    app.before("/category", SuperTokens.middleware())
    app.post("/category") { ctx ->
        val user = getUserFromAuth(ctx)
        val masterCategory: MasterCategory = ServiceManager.masterCategoryService.getById(user, getQueryParam<String>(ctx, "master_category_id"))
        val name = getQueryParam<String>(ctx, "name")

        val category = ServiceManager.categoryService.create(user, masterCategory, name)
        ctx.json(category)
    }

    app.put("/category") { ctx ->
        // required
        val user = getUserFromAuth(ctx)
        val category: Category = ServiceManager.categoryService.getById(user, getQueryParam<String>(ctx, "id"))

        //optional
        val newName = getOptionalQueryParam<String>(ctx, "new_name")
        val newMasterCategory: MasterCategory? = getOptionalQueryParam<String>(ctx, "new_master_category_id")?.let{
            ServiceManager.masterCategoryService.getById(user, it)
        }
        val newArchived = getOptionalQueryParam<Boolean>(ctx, "new_archived")
        val newDeleted = getOptionalQueryParam<Boolean>(ctx, "new_deleted")
        val updatedCategory = ServiceManager.categoryService.update(user, category, newName, newMasterCategory, newArchived, newDeleted)
        ctx.json(updatedCategory)
    }

    app.before("/category/budget", SuperTokens.middleware())
    app.get("/category/budget") { ctx ->
        val user = getUserFromAuth(ctx)
        val budget: Budget = ServiceManager.budgetService.getById(user, getQueryParam<String>(ctx, "budget_id"))

        val categories = ServiceManager.categoryService.findByBudget(user, budget)
        ctx.json(categories)
    }

    app.before("/operation", SuperTokens.middleware())
    app.post("/operation") { ctx ->
        //required
        val user = getUserFromAuth(ctx)
        val account: Account = ServiceManager.accountService.getById(user, getQueryParam<String>(ctx, "account_id"))

        //optional
        val day : Day? = getOptionalQueryParam<Int>(ctx, "day")?.let {Day.createFromComparable(it)}
        val category: Category? = getOptionalQueryParam<String>(ctx, "category_id")?.let{
            ServiceManager.categoryService.getById(user, it)
        }
        val amount : Int? = getOptionalQueryParam<Int>(ctx, "amount")
        val memo : String? = getOptionalQueryParam<String>(ctx, "memo")

        val operation: Operation = ServiceManager.operationService.create(user, account, day, category, amount, memo)
        ctx.json(operation)
    }

    app.put("/operation") { ctx ->
        //required
        val user = getUserFromAuth(ctx)
        val operation: Operation = ServiceManager.operationService.getById(user, getQueryParam<String>(ctx, "operation_id"))

        //optional
        val account: Account? = getOptionalQueryParam<String>(ctx, "new_account_id")?.let{
            ServiceManager.accountService.getById(user, it)
        }
        val day : Day? = getOptionalQueryParam<Int>(ctx, "new_day")?.let {Day.createFromComparable(it)}
        val category: Category? = getOptionalQueryParam<String>(ctx, "new_category_id")?.let{
            ServiceManager.categoryService.getById(user, it)
        }
        val amount : Int? = getOptionalQueryParam<Int>(ctx, "new_amount")
        val memo : String? = getOptionalQueryParam<String>(ctx, "new_memo")

        val updatedOperation = ServiceManager.operationService.update(user, operation, account, day, category, amount, memo)
        ctx.json(updatedOperation)
    }

    app.delete("/operation") { ctx ->
        val user = getUserFromAuth(ctx)
        val operation: Operation = ServiceManager.operationService.getById(user, getQueryParam<String>(ctx, "operation_id"))
        ServiceManager.operationService.delete(user, operation)
        ctx.json("account ${operation.id} has been deleted")
    }

    app.before("/operation/account", SuperTokens.middleware())
    app.get("/operation/account") { ctx ->
        val user = getUserFromAuth(ctx)
        val account: Account = ServiceManager.accountService.getById(user, getQueryParam<String>(ctx, "account_id"))
        val operations = ServiceManager.operationService.findByAccount(user, account)
        ctx.json(operations)
    }

    app.before("/operation/budget", SuperTokens.middleware())
    app.get("/operation/budget") { ctx ->
        val user = getUserFromAuth(ctx)
        val budget: Budget = ServiceManager.budgetService.getById(user, getQueryParam<String>(ctx, "budget_id"))
        val operations = ServiceManager.operationService.findByBudget(user, budget)
        ctx.json(operations)
    }

    app.before("/allocation", SuperTokens.middleware())
    app.post("/allocation") { ctx ->
        val user = getUserFromAuth(ctx)
        val month : Month = Month.createFromComparable(getQueryParam<Int>(ctx, "month"))
        val category: Category = ServiceManager.categoryService.getById(user, getQueryParam<String>(ctx, "category_id"))
        val amount : Int = getQueryParam<Int>(ctx, "amount")
        val allocation = ServiceManager.allocationService.insertOrUpdate(user, month, category, amount)
        ctx.json(allocation)
    }
}

private fun setUpApp(properties: JavaProperties): Javalin {
    val app = Javalin.create { config ->
            if (properties.getProperty("environment") == "dev") {
                config.enableCorsForAllOrigins()
            } else {
                config.enableCorsForOrigin(properties.getProperty("allowed_origin"))
            }
    }.start(getHerokuAssignedOrDefaultPort())

    app.exception(SuperTokensException::class.java, SuperTokens.exceptionHandler())

    app.exception(TresorierException::class.java) { e, ctx ->
        ctx.status(400)
        ctx.json("an exception occured" + sendToAdminMessage(e.id))
    }

    app.exception(TresorierIllegalException::class.java) { e, ctx ->
        ctx.status(403)
        ctx.json("this transaction is not authorised for the authentified user" + sendToAdminMessage(e.id))
    }

    app.exception(Exception::class.java) { e, ctx ->
        ctx.status(500)
        // is not thrown so that only an id code will be send to the client side, the handling is done inside TresorierException class
        val exception = TresorierException("catched by API", e)
        ctx.json("an unexpected error occured on our side." + sendToAdminMessage(exception.id))
    }

    return app
}

private fun sendToAdminMessage(errorId : String) : String {
    return " Send this code to your administrator for details : $errorId"
}

private fun getHerokuAssignedOrDefaultPort(): Int {
    val herokuPort = System.getenv("PORT");
    if (herokuPort != null) {
        return Integer.parseInt(herokuPort);
    }
    return 7000;
}

private fun getUserFromAuth(ctx: Context): Person {
    val validSession = SuperTokens.getFromContext(ctx)
    val userId = validSession.userId
    return ServiceManager.personService.getById(userId)
}

private inline fun <reified T: Any> getQueryParam(ctx: Context, paramName: String) : T {
    return ctx.queryParam<T>(paramName).get()
}

private inline fun <reified T: Any> getOptionalQueryParam(ctx: Context, paramName: String) : T? {
    return ctx.queryParam<T>(paramName).getOrNull()
}