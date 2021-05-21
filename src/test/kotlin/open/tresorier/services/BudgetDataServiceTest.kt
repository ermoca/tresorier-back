package open.tresorier.services

import open.tresorier.dao.*
import open.tresorier.dependenciesinjection.ITest
import open.tresorier.exception.TresorierException
import open.tresorier.model.*
import open.tresorier.utils.TestData
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.koin.core.component.inject

class BudgetDataServiceTest : ITest {

    val budgetDataService by inject<BudgetDataService>()
    val budgetDao by inject<IBudgetDao>()
    val masterCategoryDao by inject<IMasterCategoryDao>()
    val categoryDao by inject<ICategoryDao>()
    val allocationDao by inject<IAllocationDao>()
    val accountDao by inject<IAccountDao>()
    val operationDao by inject<IOperationDao>()
    val personDao by inject<IPersonDao>()

    @Test
    fun testAddAllocation() {
        val categoryId = "categoryId"
        val allocationList = listOf(
                Allocation(TestData.jan_2020,categoryId,40.00),
                Allocation(TestData.dec_2020,categoryId,20.00),
                Allocation(TestData.jan_2021,categoryId,20.00),
                Allocation(TestData.feb_2022,categoryId,20.00),
                Allocation(TestData.mar_2022,categoryId,20.00)
        )
        var budgetData = BudgetData()
        for (allocation in allocationList) {
            budgetData = BudgetDataService.addAllocation(allocation, budgetData)
        }

        val expected = BudgetData()
        expected[TestData.jan_2020.comparable] = MonthData().set(categoryId, CategoryData(40.00, 0.00, 0.00 ))
        expected[TestData.dec_2020.comparable] = MonthData().set(categoryId, CategoryData(20.00, 0.00, 0.00 ))
        expected[TestData.jan_2021.comparable] = MonthData().set(categoryId, CategoryData(20.00, 0.00, 0.00 ))
        expected[TestData.feb_2022.comparable] = MonthData().set(categoryId, CategoryData(20.00, 0.00, 0.00 ))
        expected[TestData.mar_2022.comparable] = MonthData().set(categoryId, CategoryData(20.00, 0.00, 0.00 ))

        Assertions.assertEquals(expected, budgetData)
    }

    @Test
    fun testAddSpending() {
        val categoryId = "categoryId"
        val spendingList = listOf(
                Spending(TestData.jan_2020,categoryId, -40.00),
                Spending(TestData.dec_2020,categoryId, -10.00),
                Spending(TestData.jan_2021,categoryId, -20.00),
        )
        var budgetData = BudgetData()
        for (spending in spendingList) {
            budgetData = BudgetDataService.addSpending(spending, budgetData)
        }

        val expected = BudgetData()
        expected[TestData.jan_2020.comparable] = MonthData().set(categoryId, CategoryData(0.00, -40.00, 0.00 ))
        expected[TestData.dec_2020.comparable] = MonthData().set(categoryId, CategoryData(0.00, -10.00, 0.00 ))
        expected[TestData.jan_2021.comparable] = MonthData().set(categoryId, CategoryData(0.00, -20.00, 0.00 ))

        Assertions.assertEquals(expected, budgetData)
    }

    @Test
    fun testComputeAvailableWithNoSpending() {
        val categoryId = "categoryId"
        val allocationList = listOf(
                Allocation(TestData.jan_2020,categoryId,40.00),
                Allocation(TestData.dec_2020,categoryId,20.00),
                Allocation(TestData.jan_2021,categoryId,20.00),
                Allocation(TestData.feb_2022,categoryId,20.00),
                Allocation(TestData.mar_2022,categoryId,20.00)
        )
        var budgetData = BudgetData()
        for (allocation in allocationList) {
            budgetData = BudgetDataService.addAllocation(allocation, budgetData)
        }
        budgetData = BudgetDataService.computeAvailable(budgetData)

        val expected = BudgetData()
        expected[TestData.jan_2020.comparable] = MonthData().set(categoryId, CategoryData(40.00, 0.00, 40.00 ))
        expected[TestData.dec_2020.comparable] = MonthData().set(categoryId, CategoryData(20.00, 0.00, 60.00 ))
        expected[TestData.jan_2021.comparable] = MonthData().set(categoryId, CategoryData(20.00, 0.00, 80.00 ))
        expected[TestData.feb_2022.comparable] = MonthData().set(categoryId, CategoryData(20.00, 0.00, 100.00 ))
        expected[TestData.mar_2022.comparable] = MonthData().set(categoryId, CategoryData(20.00, 0.00, 120.00 ))

        Assertions.assertEquals(expected, budgetData)
    }


    @Test
    fun testComputeAvailableWithNoAllocation() {
        val categoryId = "categoryId"
        val spendingList = listOf(
                Spending(TestData.jan_2020,categoryId, -40.00),
                Spending(TestData.dec_2020,categoryId, -10.00),
                Spending(TestData.jan_2021,categoryId, -20.00),
        )
        var budgetData = BudgetData()
        for (spending in spendingList) {
            budgetData = BudgetDataService.addSpending(spending, budgetData)
        }
        budgetData = BudgetDataService.computeAvailable(budgetData)

        val expected = BudgetData()
        expected[TestData.jan_2020.comparable] = MonthData().set(categoryId, CategoryData(0.00, -40.00, -40.00 ))
        expected[TestData.dec_2020.comparable] = MonthData().set(categoryId, CategoryData(0.00, -10.00, -50.00 ))
        expected[TestData.jan_2021.comparable] = MonthData().set(categoryId, CategoryData(0.00, -20.00, -70.00 ))

        Assertions.assertEquals(expected, budgetData)
    }


    @Test
    fun testComputeAvailableWithAllocationAndSpending() {
        val categoryId = "categoryId"
        val allocationList = listOf(
                Allocation(TestData.jan_2020,categoryId,40.00),
                Allocation(TestData.dec_2020,categoryId,20.00),
                Allocation(TestData.jan_2021,categoryId,20.00),
                Allocation(TestData.feb_2022,categoryId,20.00),
                Allocation(TestData.mar_2022,categoryId,20.00)
        )
        val spendingList = listOf(
                Spending(TestData.jan_2020,categoryId, -40.00),
                Spending(TestData.dec_2020,categoryId, -10.00),
                Spending(TestData.jan_2021,categoryId, -70.00),
        )
        var budgetData = BudgetData()
        for (spending in spendingList) {
            budgetData = BudgetDataService.addSpending(spending, budgetData)
        }
        for (allocation in allocationList) {
            budgetData = BudgetDataService.addAllocation(allocation, budgetData)
        }
        budgetData = BudgetDataService.computeAvailable(budgetData)

        val expected = BudgetData()
        expected[TestData.jan_2020.comparable] = MonthData().set(categoryId, CategoryData(40.00, -40.00, 0.00 ))
        expected[TestData.dec_2020.comparable] = MonthData().set(categoryId, CategoryData(20.00, -10.00, 10.00 ))
        expected[TestData.jan_2021.comparable] = MonthData().set(categoryId, CategoryData(20.00, -70.00, -40.00 ))
        expected[TestData.feb_2022.comparable] = MonthData().set(categoryId, CategoryData(20.00, 0.00, -20.00 ))
        expected[TestData.mar_2022.comparable] = MonthData().set(categoryId, CategoryData(20.00, 0.00, 0.00 ))

        Assertions.assertEquals(expected, budgetData)
    }

    @Test
    fun testFindAllKnownCategories() {
        val categoryId = "categoryId"
        val category2Id = "category2Id"
        val category3Id = "category3Id"

        val data = BudgetData()
        data[TestData.jan_2020.comparable] = MonthData().set(categoryId, CategoryData(40.00, 40.00, 0.00 ))
        data[TestData.dec_2020.comparable] = MonthData().set(category2Id, CategoryData(20.00, 10.00, 10.00 ))
        data[TestData.jan_2021.comparable] = MonthData().set(categoryId, CategoryData(20.00, 70.00, -40.00 ))
        data[TestData.feb_2022.comparable] = MonthData().set(category3Id, CategoryData(20.00, 0.00, -20.00 ))
        data[TestData.mar_2022.comparable] = MonthData().set(categoryId, CategoryData(20.00, 0.00, 0.00 ))

        val listOfKnownCategory = BudgetDataService.getAllKnownCategoriesUntilMonth(data, TestData.jan_2021)

        Assertions.assertEquals(2, listOfKnownCategory.size)
        Assertions.assertTrue(categoryId in listOfKnownCategory)
        Assertions.assertTrue(category2Id in listOfKnownCategory)

    }


    @Test
    fun testExtractPeriod() {
        val categoryId = "categoryId"

        val data = BudgetData()
        data[TestData.jan_2020.comparable] = MonthData().set(categoryId, CategoryData(40.00, 40.00, 0.00 ))
        data[TestData.dec_2020.comparable] = MonthData().set(categoryId, CategoryData(20.00, 10.00, 10.00 ))
        data[TestData.jan_2021.comparable] = MonthData().set(categoryId, CategoryData(20.00, 70.00, -40.00 ))
        data[TestData.feb_2022.comparable] = MonthData().set(categoryId, CategoryData(20.00, 0.00, -20.00 ))
        data[TestData.mar_2022.comparable] = MonthData().set(categoryId, CategoryData(20.00, 0.00, 0.00 ))

        val extractedData = BudgetDataService.extractDataForPeriod(data, TestData.jan_2021, TestData.feb_2022)

        val expected = BudgetData()
        expected[TestData.jan_2021.comparable] = MonthData().set(categoryId, CategoryData(20.00, 70.00, -40.00 ))
        expected[TestData.feb_2022.comparable] = MonthData().set(categoryId, CategoryData(20.00, 0.00, -20.00 ))

        Assertions.assertEquals(expected, extractedData)
    }

    @Test
    fun testExtractPeriodWithNoEndMonth() {
        val categoryId = "categoryId"

        val data = BudgetData()
        data[TestData.jan_2020.comparable] = MonthData().set(categoryId, CategoryData(40.00, 40.00, 0.00 ))
        data[TestData.dec_2020.comparable] = MonthData().set(categoryId, CategoryData(20.00, 10.00, 10.00 ))
        data[TestData.jan_2021.comparable] = MonthData().set(categoryId, CategoryData(20.00, 70.00, -40.00 ))
        data[TestData.feb_2022.comparable] = MonthData().set(categoryId, CategoryData(20.00, 0.00, -20.00 ))
        data[TestData.mar_2022.comparable] = MonthData().set(categoryId, CategoryData(20.00, 0.00, 0.00 ))

        val extractedData = BudgetDataService.extractDataForPeriod(data, TestData.jan_2021)

        val expected = BudgetData()
        expected[TestData.jan_2021.comparable] = MonthData().set(categoryId, CategoryData(20.00, 70.00, -40.00 ))
        expected[TestData.feb_2022.comparable] = MonthData().set(categoryId, CategoryData(20.00, 0.00, -20.00 ))
        expected[TestData.mar_2022.comparable] = MonthData().set(categoryId, CategoryData(20.00, 0.00, 0.00 ))

        Assertions.assertEquals(expected, extractedData)
    }

    @Test
    fun testExtractPeriodWithEmptyData() {
        val data = BudgetData()
        val extractedData = BudgetDataService.extractDataForPeriod(data, TestData.jan_2021, TestData.apr_2021)
        Assertions.assertEquals(data, extractedData)
    }

    @Test
    fun testExtractPeriodWithEmptyDataAndNoEnd() {
        val data = BudgetData()
        val extractedData = BudgetDataService.extractDataForPeriod(data, TestData.jan_2021)
        Assertions.assertEquals(data, extractedData)
    }

    @Test
    fun testFindBudgetData() {
        val budget = Budget("wellAllocatedBudget", TestData.person1Id)
        budgetDao.insert(budget)
        val masterCategory = MasterCategory("Fixed expense", budget.id)
        masterCategoryDao.insert(masterCategory)
        val category = Category("oftenAllocatedCategory", masterCategory.id)
        categoryDao.insert(category)
        val allocationList = listOf(
                Allocation(TestData.nov_2020,category.id, 40.00),
                Allocation(TestData.dec_2020,category.id, 20.00),
                Allocation(TestData.jan_2021,category.id, 20.00),
                Allocation(TestData.may_2021,category.id, 20.00),
                Allocation(TestData.jun_2021,category.id, 20.00)

        )
        for (allocation in allocationList) {
            allocationDao.insertOrUpdate(allocation)
        }
        val category2 = Category("lessoftenAllocatedCategory", masterCategory.id)
        categoryDao.insert(category2)
        val account = Account("my own account", budget.id)
        accountDao.insert(account)
        val operationList = listOf(
                Operation(account.id, TestData.nov_02_2020 , category.id, -40.00),
                Operation(account.id, TestData.nov_03_2020 , category.id, -20.00),
                Operation(account.id, TestData.feb_02_2021 , category2.id, 10.00),
                Operation(account.id, TestData.march_02_2021 , category.id, -30.00),

                )
        for (operation in operationList) {
            operationDao.insert(operation)
        }
        val person: Person = personDao.getById(TestData.person1Id)
        val budgetData = budgetDataService.getBudgetData(person, budget)

        val expected = BudgetData()
        expected[TestData.nov_2020.comparable] = MonthData().set(category.id, CategoryData(40.00, -60.00, -20.00 ))
        expected[TestData.dec_2020.comparable] = MonthData().set(category.id, CategoryData(20.00, 0.00, 0.00 ))
        expected[TestData.jan_2021.comparable] = MonthData().set(category.id, CategoryData(20.00, 0.00, 20.00 ))
        expected[TestData.feb_2021.comparable] = MonthData().set(category2.id, CategoryData(0.00, 10.00, 10.00 ))
        expected[TestData.mar_2021.comparable] = MonthData().set(category.id, CategoryData(0.00, -30.00, -10.00 ))
        expected[TestData.may_2021.comparable] = MonthData().set(category.id, CategoryData(20.00, 0.00, 10.00 ))
        expected[TestData.jun_2021.comparable] = MonthData().set(category.id, CategoryData(20.00, 0.00, 30.00 ))

        Assertions.assertEquals(expected, budgetData)
    }

    @Test
    fun testFindBudgetDataForGivenMonthsOnly() {
        val budget = Budget("wellAllocatedBudget", TestData.person1Id)
        budgetDao.insert(budget)
        val masterCategory = MasterCategory("Fixed expense", budget.id)
        masterCategoryDao.insert(masterCategory)
        val category = Category("oftenAllocatedCategory", masterCategory.id)
        categoryDao.insert(category)
        val allocationList = listOf(
                Allocation(TestData.nov_2020,category.id, 40.00),
                Allocation(TestData.dec_2020,category.id, 20.00),
                Allocation(TestData.jan_2021,category.id, 20.00),
                Allocation(TestData.may_2021,category.id, 20.00),
                Allocation(TestData.jun_2021,category.id, 20.00)

        )
        for (allocation in allocationList) {
            allocationDao.insertOrUpdate(allocation)
        }
        val category2 = Category("lessoftenAllocatedCategory", masterCategory.id)
        categoryDao.insert(category2)
        val account = Account("my own account", budget.id)
        accountDao.insert(account)
        val operationList = listOf(
                Operation(account.id, TestData.nov_02_2020 , category.id, -40.00),
                Operation(account.id, TestData.nov_03_2020 , category.id, -20.00),
                Operation(account.id, TestData.feb_02_2021 , category2.id, -10.00),
                Operation(account.id, TestData.march_02_2021 , category.id, -30.00),

                )
        for (operation in operationList) {
            operationDao.insert(operation)
        }
        val person: Person = personDao.getById(TestData.person1Id)
        val budgetData = budgetDataService.getBudgetData(person, budget, TestData.dec_2020, TestData.may_2021)

        val expected = BudgetData()
        expected[TestData.dec_2020.comparable] = MonthData().set(category.id, CategoryData(20.00, 0.00, 0.00 ))
        expected[TestData.jan_2021.comparable] = MonthData().set(category.id, CategoryData(20.00, 0.00, 20.00 ))
        expected[TestData.feb_2021.comparable] = MonthData().set(category2.id, CategoryData(0.00, -10.00, -10.00 ))
        expected[TestData.mar_2021.comparable] = MonthData().set(category.id, CategoryData(0.00, -30.00, -10.00 ))
        expected[TestData.may_2021.comparable] = MonthData().set(category.id, CategoryData(20.00, 0.00, 10.00 ))

        Assertions.assertEquals(expected, budgetData)
    }

    @Test
    fun testFindBudgetDataForGivenMonthWithPriorOperationInCategories() {
        val budget = Budget("wellAllocatedBudget", TestData.person1Id)
        budgetDao.insert(budget)
        val masterCategory = MasterCategory("Fixed expense", budget.id)
        masterCategoryDao.insert(masterCategory)
        val category = Category("oftenAllocatedCategory", masterCategory.id)
        categoryDao.insert(category)
        val allocationList = listOf(
                Allocation(TestData.nov_2020,category.id, 40.00),
                Allocation(TestData.dec_2020,category.id, 20.00),
                Allocation(TestData.jan_2021,category.id, 10.00),
                Allocation(TestData.may_2021,category.id, 20.00),
                Allocation(TestData.jun_2021,category.id, 20.00)

        )
        for (allocation in allocationList) {
            allocationDao.insertOrUpdate(allocation)
        }
        val category2 = Category("lessoftenAllocatedCategory", masterCategory.id)
        categoryDao.insert(category2)
        val account = Account("my own account", budget.id)
        accountDao.insert(account)
        val operationList = listOf(
                Operation(account.id, TestData.nov_02_2020 , category.id, -40.00),
                Operation(account.id, TestData.nov_03_2020 , category.id, -20.00),
                Operation(account.id, TestData.feb_02_2021 , category2.id, -10.00),
                Operation(account.id, TestData.march_02_2021 , category.id, -30.00),

                )
        for (operation in operationList) {
            operationDao.insert(operation)
        }
        val person: Person = personDao.getById(TestData.person1Id)
        val budgetData = budgetDataService.getBudgetData(person, budget, TestData.apr_2021, TestData.may_2021)

        val expected = BudgetData()
        expected[TestData.apr_2021.comparable] = MonthData().set(category.id, CategoryData(0.00, 00.00, -20.00 ))
                                                            .set(category2.id, CategoryData(0.00, 00.00, -10.00 ))
        expected[TestData.may_2021.comparable] = MonthData().set(category.id, CategoryData(20.00, 0.00, 0.00 ))

        Assertions.assertEquals(expected, budgetData)
    }

    @Test
    fun testFindBudgetDataForOneEmptyMonth() {
        val budget = Budget("wellAllocatedBudget", TestData.person1Id)
        budgetDao.insert(budget)
        val masterCategory = MasterCategory("Fixed expense", budget.id)
        masterCategoryDao.insert(masterCategory)
        val category = Category("oftenAllocatedCategory", masterCategory.id)
        categoryDao.insert(category)
        val allocationList = listOf(
                Allocation(TestData.nov_2020,category.id, 40.00),
                Allocation(TestData.dec_2020,category.id, 20.00),
                Allocation(TestData.jan_2021,category.id, 10.00),
                Allocation(TestData.may_2021,category.id, 20.00),
                Allocation(TestData.jun_2021,category.id, 20.00)

        )
        for (allocation in allocationList) {
            allocationDao.insertOrUpdate(allocation)
        }
        val category2 = Category("lessoftenAllocatedCategory", masterCategory.id)
        categoryDao.insert(category2)
        val account = Account("my own account", budget.id)
        accountDao.insert(account)
        val operationList = listOf(
                Operation(account.id, TestData.nov_02_2020 , category.id, -40.00),
                Operation(account.id, TestData.nov_03_2020 , category.id, -20.00),
                Operation(account.id, TestData.feb_02_2021 , category2.id, -10.00),
                Operation(account.id, TestData.march_02_2021 , category.id, -30.00),

                )
        for (operation in operationList) {
            operationDao.insert(operation)
        }
        val person: Person = personDao.getById(TestData.person1Id)
        val budgetData = budgetDataService.getBudgetData(person, budget, TestData.apr_2021, TestData.apr_2021)

        val expected = BudgetData()
        expected[TestData.apr_2021.comparable] = MonthData().set(category.id, CategoryData(0.00, 00.00, -20.00 ))
                .set(category2.id, CategoryData(0.00, 00.00, -10.00 ))

        Assertions.assertEquals(expected, budgetData)
    }

    @Test
    fun testFindBudgetDataFromMonthToEnd() {
        val budget = Budget("wellAllocatedBudget", TestData.person1Id)
        budgetDao.insert(budget)
        val masterCategory = MasterCategory("Fixed expense", budget.id)
        masterCategoryDao.insert(masterCategory)
        val category = Category("oftenAllocatedCategory", masterCategory.id)
        categoryDao.insert(category)
        val allocationList = listOf(
                Allocation(TestData.nov_2020,category.id, 40.00),
                Allocation(TestData.dec_2020,category.id, 20.00),
                Allocation(TestData.jan_2021,category.id, 10.00),
                Allocation(TestData.may_2021,category.id, 20.00),
                Allocation(TestData.jun_2021,category.id, 20.00)
        )
        for (allocation in allocationList) {
            allocationDao.insertOrUpdate(allocation)
        }
        val category2 = Category("lessoftenAllocatedCategory", masterCategory.id)
        categoryDao.insert(category2)
        val account = Account("my own account", budget.id)
        accountDao.insert(account)
        val operationList = listOf(
                Operation(account.id, TestData.nov_02_2020 , category.id, -40.00),
                Operation( account.id,TestData.nov_03_2020 , category.id, -20.00),
                Operation( account.id,TestData.feb_02_2021 , category2.id, -10.00),
                Operation( account.id,TestData.march_02_2021 , category.id, -30.00),
        )
        for (operation in operationList) {
            operationDao.insert(operation)
        }
        val person: Person = personDao.getById(TestData.person1Id)
        val budgetData = budgetDataService.getBudgetData(person, budget, TestData.apr_2021)

        val expected = BudgetData()
        expected[TestData.apr_2021.comparable] = MonthData().set(category.id, CategoryData(0.00, 00.00, -20.00 ))
                .set(category2.id, CategoryData(0.00, 00.00, -10.00 ))
        expected[TestData.may_2021.comparable] = MonthData().set(category.id, CategoryData(20.00, 0.00, 0.00 ))
        expected[TestData.jun_2021.comparable] = MonthData().set(category.id, CategoryData(20.00, 0.00, 20.00 ))

        Assertions.assertEquals(expected, budgetData)
    }

    @Test
    fun testFindBudgetDataForEmptyBudget() {
        val budget = Budget("wellAllocatedBudget", TestData.person1Id)
        budgetDao.insert(budget)
        val person: Person = personDao.getById(TestData.person1Id)
        val budgetData = budgetDataService.getBudgetData(person, budget)
        val expected = BudgetData()
        Assertions.assertEquals(expected, budgetData)
    }

    @Test
    fun testFindBudgetDataForNonExistingBudget() {
        val budget = Budget("NotStoredBudget", TestData.person1Id)
        val person: Person = personDao.getById(TestData.person1Id)
        val exception = Assertions.assertThrows(TresorierException::class.java) {
            budgetDataService.getBudgetData(person, budget)
        }
        Assertions.assertEquals("the given object appears to have no owner", exception.message)
    }

    @Test
    fun testFindBudgetDataWithCents() {
        val budget = Budget("wellAllocatedBudget", TestData.person1Id)
        budgetDao.insert(budget)
        val masterCategory = MasterCategory("Fixed expense", budget.id)
        masterCategoryDao.insert(masterCategory)
        val category = Category("oftenAllocatedCategory", masterCategory.id)
        categoryDao.insert(category)
        val account = Account("my own account", budget.id)
        accountDao.insert(account)
        val operationList = listOf(
                Operation(account.id, TestData.oct_02_2020 , category.id, 45.54),
                Operation(account.id, TestData.nov_03_2020 , category.id, 20.00),
        )
        for (operation in operationList) {
            operationDao.insert(operation)
        }
        val person: Person = personDao.getById(TestData.person1Id)
        val budgetData = budgetDataService.getBudgetData(person, budget)

        val expected = BudgetData()
        expected[TestData.oct_2020.comparable] = MonthData().set(category.id, CategoryData(0.00, 45.54, 45.54 ))
        expected[TestData.nov_2020.comparable] = MonthData().set(category.id, CategoryData(0.00, 20.00, 65.54 )) // not 65.53999999999

        Assertions.assertEquals(expected, budgetData)
    }

}
