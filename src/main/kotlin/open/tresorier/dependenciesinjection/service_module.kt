package open.tresorier.dependenciesinjection

import open.tresorier.dao.*
import open.tresorier.dao.jooq.main.*
import open.tresorier.services.*
import org.koin.dsl.module

val service_module = module {
    single { AuthorizationService(get(), get(), get(), get(), get()) }
    single { PersonService(get(), get()) }
    single { BudgetService(get(), get()) }
    single { AccountService(get(), get(), get()) }
    single { CategoryService(get(), get()) }
    single { MasterCategoryService(get(), get()) }
    single { OperationService(get(), get()) }
    single { AllocationService(get(), get()) }

}
