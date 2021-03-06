/*
 * This file is generated by jOOQ.
 */
package open.tresorier.generated.jooq.test.public_.tables;


import java.util.Arrays;
import java.util.List;

import open.tresorier.generated.jooq.test.public_.Keys;
import open.tresorier.generated.jooq.test.public_.Public;
import open.tresorier.generated.jooq.test.public_.tables.records.AccountRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Account extends TableImpl<AccountRecord> {

    private static final long serialVersionUID = -213084198;

    /**
     * The reference instance of <code>PUBLIC.ACCOUNT</code>
     */
    public static final Account ACCOUNT = new Account();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AccountRecord> getRecordType() {
        return AccountRecord.class;
    }

    /**
     * The column <code>PUBLIC.ACCOUNT.ID</code>.
     */
    public final TableField<AccountRecord, String> ID = createField(DSL.name("ID"), org.jooq.impl.SQLDataType.VARCHAR(36).nullable(false), this, "");

    /**
     * The column <code>PUBLIC.ACCOUNT.BUDGET_ID</code>.
     */
    public final TableField<AccountRecord, String> BUDGET_ID = createField(DSL.name("BUDGET_ID"), org.jooq.impl.SQLDataType.VARCHAR(36).nullable(false), this, "");

    /**
     * The column <code>PUBLIC.ACCOUNT.NAME</code>.
     */
    public final TableField<AccountRecord, String> NAME = createField(DSL.name("NAME"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>PUBLIC.ACCOUNT.ARCHIVED</code>.
     */
    public final TableField<AccountRecord, Boolean> ARCHIVED = createField(DSL.name("ARCHIVED"), org.jooq.impl.SQLDataType.BOOLEAN.defaultValue(org.jooq.impl.DSL.field("FALSE", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>PUBLIC.ACCOUNT.DELETED</code>.
     */
    public final TableField<AccountRecord, Boolean> DELETED = createField(DSL.name("DELETED"), org.jooq.impl.SQLDataType.BOOLEAN.defaultValue(org.jooq.impl.DSL.field("FALSE", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * Create a <code>PUBLIC.ACCOUNT</code> table reference
     */
    public Account() {
        this(DSL.name("ACCOUNT"), null);
    }

    /**
     * Create an aliased <code>PUBLIC.ACCOUNT</code> table reference
     */
    public Account(String alias) {
        this(DSL.name(alias), ACCOUNT);
    }

    /**
     * Create an aliased <code>PUBLIC.ACCOUNT</code> table reference
     */
    public Account(Name alias) {
        this(alias, ACCOUNT);
    }

    private Account(Name alias, Table<AccountRecord> aliased) {
        this(alias, aliased, null);
    }

    private Account(Name alias, Table<AccountRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Account(Table<O> child, ForeignKey<O, AccountRecord> key) {
        super(child, key, ACCOUNT);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<AccountRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_E;
    }

    @Override
    public List<UniqueKey<AccountRecord>> getKeys() {
        return Arrays.<UniqueKey<AccountRecord>>asList(Keys.CONSTRAINT_E);
    }

    @Override
    public List<ForeignKey<AccountRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<AccountRecord, ?>>asList(Keys.CONSTRAINT_E4);
    }

    public Budget budget() {
        return new Budget(this, Keys.CONSTRAINT_E4);
    }

    @Override
    public Account as(String alias) {
        return new Account(DSL.name(alias), this);
    }

    @Override
    public Account as(Name alias) {
        return new Account(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Account rename(String name) {
        return new Account(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Account rename(Name name) {
        return new Account(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<String, String, String, Boolean, Boolean> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
