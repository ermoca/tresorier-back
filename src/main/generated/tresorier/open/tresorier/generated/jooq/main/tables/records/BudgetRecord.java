/*
 * This file is generated by jOOQ.
 */
package open.tresorier.generated.jooq.main.tables.records;


import open.tresorier.generated.jooq.main.tables.Budget;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BudgetRecord extends UpdatableRecordImpl<BudgetRecord> implements Record4<String, String, String, Boolean> {

    private static final long serialVersionUID = -53278126;

    /**
     * Setter for <code>public.budget.id</code>.
     */
    public BudgetRecord setId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.budget.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.budget.person_id</code>.
     */
    public BudgetRecord setPersonId(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.budget.person_id</code>.
     */
    public String getPersonId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.budget.name</code>.
     */
    public BudgetRecord setName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.budget.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.budget.deleted</code>.
     */
    public BudgetRecord setDeleted(Boolean value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.budget.deleted</code>.
     */
    public Boolean getDeleted() {
        return (Boolean) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, String, Boolean> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<String, String, String, Boolean> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Budget.BUDGET.ID;
    }

    @Override
    public Field<String> field2() {
        return Budget.BUDGET.PERSON_ID;
    }

    @Override
    public Field<String> field3() {
        return Budget.BUDGET.NAME;
    }

    @Override
    public Field<Boolean> field4() {
        return Budget.BUDGET.DELETED;
    }

    @Override
    public String component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getPersonId();
    }

    @Override
    public String component3() {
        return getName();
    }

    @Override
    public Boolean component4() {
        return getDeleted();
    }

    @Override
    public String value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getPersonId();
    }

    @Override
    public String value3() {
        return getName();
    }

    @Override
    public Boolean value4() {
        return getDeleted();
    }

    @Override
    public BudgetRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public BudgetRecord value2(String value) {
        setPersonId(value);
        return this;
    }

    @Override
    public BudgetRecord value3(String value) {
        setName(value);
        return this;
    }

    @Override
    public BudgetRecord value4(Boolean value) {
        setDeleted(value);
        return this;
    }

    @Override
    public BudgetRecord values(String value1, String value2, String value3, Boolean value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BudgetRecord
     */
    public BudgetRecord() {
        super(Budget.BUDGET);
    }

    /**
     * Create a detached, initialised BudgetRecord
     */
    public BudgetRecord(String id, String personId, String name, Boolean deleted) {
        super(Budget.BUDGET);

        set(0, id);
        set(1, personId);
        set(2, name);
        set(3, deleted);
    }
}
