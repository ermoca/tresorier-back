package open.tresorier.dao.jooq.h2

import open.tresorier.dao.IAccountDao
import open.tresorier.exception.TresorierException
import open.tresorier.generated.jooq.test.public_.Tables.*
import open.tresorier.generated.jooq.test.public_.tables.daos.AccountDao
import open.tresorier.generated.jooq.test.public_.tables.records.PersonRecord
import open.tresorier.model.*
import org.jooq.Configuration
import org.jooq.Field
import org.jooq.Record6
import org.jooq.impl.DSL
import java.math.BigDecimal
import open.tresorier.generated.jooq.test.public_.tables.pojos.Account as JooqAccount


class H2AccountDao(val configuration: Configuration) : IAccountDao {

    private val generatedDao: AccountDao = AccountDao(configuration)
    private val query = DSL.using(configuration)

    override fun insert(account: Account): Account {
        val jooqAccount = this.toJooqAccount(account)
        try {
            this.generatedDao.insert(jooqAccount)
        } catch (e: Exception) {
            throw TresorierException("could not insert account : $account", e)
        }
        return account
    }

    override fun update(account: Account): Account {
        val jooqAccount = this.toJooqAccount(account)
        try {
            this.generatedDao.update(jooqAccount)
        } catch (e: Exception) {
            throw TresorierException("could not update account : $account", e)
        }
        return account
    }

    override fun getById(id: String): Account {
        val jooqAccount = this.generatedDao.fetchOneById(id)
        return this.toAccount(jooqAccount) ?: throw TresorierException("no account found for the following id : $id")
    }

    private val amountSum: Field<BigDecimal> = DSL.sum(OPERATION.AMOUNT).`as`("sum")

    override fun findByBudget(budget: Budget): List<AccountWithAmount> {
        val query = this.query
            .select(ACCOUNT.ID, ACCOUNT.NAME, ACCOUNT.BUDGET_ID, amountSum, ACCOUNT.ARCHIVED, ACCOUNT.DELETED)
            .from(ACCOUNT)
            .join(OPERATION).on(OPERATION.ACCOUNT_ID.eq(ACCOUNT.ID))
            .where(ACCOUNT.BUDGET_ID.eq(budget.id))
            .groupBy(ACCOUNT.ID)
            .orderBy(ACCOUNT.NAME)
        val jooqAccountList = query.fetch()
        val accountList: MutableList<AccountWithAmount> = mutableListOf()
        for (accountRecord in jooqAccountList) {
            val account = this.toAccountWithAmount(accountRecord)
            accountList.add(account)
        }
        return accountList
    }

    override fun getOwner(account: Account): Person {
        try {
            val owner: PersonRecord = this.query.select().from(PERSON)
                .join(BUDGET).on(BUDGET.ID.eq(account.budgetId))
                .where(PERSON.ID.eq(BUDGET.PERSON_ID))
                .fetchAny().into(PERSON)
            return H2PersonDao.toPerson(owner)
        } catch (e : Exception) {
            throw TresorierException("the given object appears to have no owner")
        }
    }

    private fun toJooqAccount(account: Account): JooqAccount {
        return JooqAccount(
            account.id,
            account.budgetId,
            account.name,
            account.archived,
            account.deleted
        )
    }

    private fun toAccount(jooqAccount: JooqAccount?): Account? {
        return if (jooqAccount == null)
            null
        else Account(
            jooqAccount.name,
            jooqAccount.budgetId,
            jooqAccount.archived,
            jooqAccount.id,
            jooqAccount.deleted
        )
    }

    private fun toAccountWithAmount(jooqAccountWithAmount: Record6<String, String, String, BigDecimal, Boolean, Boolean>): AccountWithAmount {
        return AccountWithAmount(
            jooqAccountWithAmount.get(ACCOUNT.NAME),
            jooqAccountWithAmount.get(ACCOUNT.BUDGET_ID),
            jooqAccountWithAmount.get(amountSum).toDouble(),
            jooqAccountWithAmount.get(ACCOUNT.ARCHIVED),
            jooqAccountWithAmount.get(ACCOUNT.ID),
            jooqAccountWithAmount.get(ACCOUNT.DELETED)
        )
    }
}
