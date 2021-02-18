/*
 * This file is generated by jOOQ.
 */
package open.tresorier.generated.jooq.test.public_.tables.records;


import open.tresorier.generated.jooq.test.public_.tables.Person;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PersonRecord extends UpdatableRecordImpl<PersonRecord> implements Record7<String, String, String, String, Long, Integer, Boolean> {

    private static final long serialVersionUID = -1516864212;

    /**
     * Setter for <code>PUBLIC.PERSON.ID</code>.
     */
    public PersonRecord setId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>PUBLIC.PERSON.ID</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>PUBLIC.PERSON.EMAIL</code>.
     */
    public PersonRecord setEmail(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>PUBLIC.PERSON.EMAIL</code>.
     */
    public String getEmail() {
        return (String) get(1);
    }

    /**
     * Setter for <code>PUBLIC.PERSON.NAME</code>.
     */
    public PersonRecord setName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>PUBLIC.PERSON.NAME</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>PUBLIC.PERSON.PASSWORD</code>.
     */
    public PersonRecord setPassword(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>PUBLIC.PERSON.PASSWORD</code>.
     */
    public String getPassword() {
        return (String) get(3);
    }

    /**
     * Setter for <code>PUBLIC.PERSON.UNLOCKINGDATE</code>.
     */
    public PersonRecord setUnlockingdate(Long value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>PUBLIC.PERSON.UNLOCKINGDATE</code>.
     */
    public Long getUnlockingdate() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>PUBLIC.PERSON.LOGINATTEMPTCOUNT</code>.
     */
    public PersonRecord setLoginattemptcount(Integer value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>PUBLIC.PERSON.LOGINATTEMPTCOUNT</code>.
     */
    public Integer getLoginattemptcount() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>PUBLIC.PERSON.DELETED</code>.
     */
    public PersonRecord setDeleted(Boolean value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>PUBLIC.PERSON.DELETED</code>.
     */
    public Boolean getDeleted() {
        return (Boolean) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<String, String, String, String, Long, Integer, Boolean> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<String, String, String, String, Long, Integer, Boolean> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Person.PERSON.ID;
    }

    @Override
    public Field<String> field2() {
        return Person.PERSON.EMAIL;
    }

    @Override
    public Field<String> field3() {
        return Person.PERSON.NAME;
    }

    @Override
    public Field<String> field4() {
        return Person.PERSON.PASSWORD;
    }

    @Override
    public Field<Long> field5() {
        return Person.PERSON.UNLOCKINGDATE;
    }

    @Override
    public Field<Integer> field6() {
        return Person.PERSON.LOGINATTEMPTCOUNT;
    }

    @Override
    public Field<Boolean> field7() {
        return Person.PERSON.DELETED;
    }

    @Override
    public String component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getEmail();
    }

    @Override
    public String component3() {
        return getName();
    }

    @Override
    public String component4() {
        return getPassword();
    }

    @Override
    public Long component5() {
        return getUnlockingdate();
    }

    @Override
    public Integer component6() {
        return getLoginattemptcount();
    }

    @Override
    public Boolean component7() {
        return getDeleted();
    }

    @Override
    public String value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getEmail();
    }

    @Override
    public String value3() {
        return getName();
    }

    @Override
    public String value4() {
        return getPassword();
    }

    @Override
    public Long value5() {
        return getUnlockingdate();
    }

    @Override
    public Integer value6() {
        return getLoginattemptcount();
    }

    @Override
    public Boolean value7() {
        return getDeleted();
    }

    @Override
    public PersonRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public PersonRecord value2(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public PersonRecord value3(String value) {
        setName(value);
        return this;
    }

    @Override
    public PersonRecord value4(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public PersonRecord value5(Long value) {
        setUnlockingdate(value);
        return this;
    }

    @Override
    public PersonRecord value6(Integer value) {
        setLoginattemptcount(value);
        return this;
    }

    @Override
    public PersonRecord value7(Boolean value) {
        setDeleted(value);
        return this;
    }

    @Override
    public PersonRecord values(String value1, String value2, String value3, String value4, Long value5, Integer value6, Boolean value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PersonRecord
     */
    public PersonRecord() {
        super(Person.PERSON);
    }

    /**
     * Create a detached, initialised PersonRecord
     */
    public PersonRecord(String id, String email, String name, String password, Long unlockingdate, Integer loginattemptcount, Boolean deleted) {
        super(Person.PERSON);

        set(0, id);
        set(1, email);
        set(2, name);
        set(3, password);
        set(4, unlockingdate);
        set(5, loginattemptcount);
        set(6, deleted);
    }
}