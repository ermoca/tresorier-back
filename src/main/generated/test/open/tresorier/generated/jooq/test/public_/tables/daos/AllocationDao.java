/*
 * This file is generated by jOOQ.
 */
package open.tresorier.generated.jooq.test.public_.tables.daos;


import java.util.List;

import open.tresorier.generated.jooq.test.public_.tables.Allocation;
import open.tresorier.generated.jooq.test.public_.tables.records.AllocationRecord;

import org.jooq.Configuration;
import org.jooq.Record2;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AllocationDao extends DAOImpl<AllocationRecord, open.tresorier.generated.jooq.test.public_.tables.pojos.Allocation, Record2<String, Integer>> {

    /**
     * Create a new AllocationDao without any configuration
     */
    public AllocationDao() {
        super(Allocation.ALLOCATION, open.tresorier.generated.jooq.test.public_.tables.pojos.Allocation.class);
    }

    /**
     * Create a new AllocationDao with an attached configuration
     */
    public AllocationDao(Configuration configuration) {
        super(Allocation.ALLOCATION, open.tresorier.generated.jooq.test.public_.tables.pojos.Allocation.class, configuration);
    }

    @Override
    public Record2<String, Integer> getId(open.tresorier.generated.jooq.test.public_.tables.pojos.Allocation object) {
        return compositeKeyRecord(object.getCategoryId(), object.getMonth());
    }

    /**
     * Fetch records that have <code>CATEGORY_ID BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<open.tresorier.generated.jooq.test.public_.tables.pojos.Allocation> fetchRangeOfCategoryId(String lowerInclusive, String upperInclusive) {
        return fetchRange(Allocation.ALLOCATION.CATEGORY_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>CATEGORY_ID IN (values)</code>
     */
    public List<open.tresorier.generated.jooq.test.public_.tables.pojos.Allocation> fetchByCategoryId(String... values) {
        return fetch(Allocation.ALLOCATION.CATEGORY_ID, values);
    }

    /**
     * Fetch records that have <code>MONTH BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<open.tresorier.generated.jooq.test.public_.tables.pojos.Allocation> fetchRangeOfMonth(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Allocation.ALLOCATION.MONTH, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>MONTH IN (values)</code>
     */
    public List<open.tresorier.generated.jooq.test.public_.tables.pojos.Allocation> fetchByMonth(Integer... values) {
        return fetch(Allocation.ALLOCATION.MONTH, values);
    }

    /**
     * Fetch records that have <code>AMOUNT BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<open.tresorier.generated.jooq.test.public_.tables.pojos.Allocation> fetchRangeOfAmount(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Allocation.ALLOCATION.AMOUNT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>AMOUNT IN (values)</code>
     */
    public List<open.tresorier.generated.jooq.test.public_.tables.pojos.Allocation> fetchByAmount(Integer... values) {
        return fetch(Allocation.ALLOCATION.AMOUNT, values);
    }
}
