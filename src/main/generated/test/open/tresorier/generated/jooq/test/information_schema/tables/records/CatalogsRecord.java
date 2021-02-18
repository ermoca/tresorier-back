/*
 * This file is generated by jOOQ.
 */
package open.tresorier.generated.jooq.test.information_schema.tables.records;


import open.tresorier.generated.jooq.test.information_schema.tables.Catalogs;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Row1;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CatalogsRecord extends TableRecordImpl<CatalogsRecord> implements Record1<String> {

    private static final long serialVersionUID = -710305178;

    /**
     * Setter for <code>INFORMATION_SCHEMA.CATALOGS.CATALOG_NAME</code>.
     */
    public CatalogsRecord setCatalogName(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.CATALOGS.CATALOG_NAME</code>.
     */
    public String getCatalogName() {
        return (String) get(0);
    }

    // -------------------------------------------------------------------------
    // Record1 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row1<String> fieldsRow() {
        return (Row1) super.fieldsRow();
    }

    @Override
    public Row1<String> valuesRow() {
        return (Row1) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Catalogs.CATALOGS.CATALOG_NAME;
    }

    @Override
    public String component1() {
        return getCatalogName();
    }

    @Override
    public String value1() {
        return getCatalogName();
    }

    @Override
    public CatalogsRecord value1(String value) {
        setCatalogName(value);
        return this;
    }

    @Override
    public CatalogsRecord values(String value1) {
        value1(value1);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CatalogsRecord
     */
    public CatalogsRecord() {
        super(Catalogs.CATALOGS);
    }

    /**
     * Create a detached, initialised CatalogsRecord
     */
    public CatalogsRecord(String catalogName) {
        super(Catalogs.CATALOGS);

        set(0, catalogName);
    }
}
