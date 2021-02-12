/*
 * This file is generated by jOOQ.
 */
package open.tresorier.generated.jooq.test.information_schema.tables.records;


import open.tresorier.generated.jooq.test.information_schema.tables.Domains;

import org.jooq.Field;
import org.jooq.Record14;
import org.jooq.Row14;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DomainsRecord extends TableRecordImpl<DomainsRecord> implements Record14<String, String, String, String, String, Integer, Integer, Integer, String, Integer, String, String, String, Integer> {

    private static final long serialVersionUID = 2008475713;

    /**
     * Setter for <code>INFORMATION_SCHEMA.DOMAINS.DOMAIN_CATALOG</code>.
     */
    public DomainsRecord setDomainCatalog(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.DOMAINS.DOMAIN_CATALOG</code>.
     */
    public String getDomainCatalog() {
        return (String) get(0);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.DOMAINS.DOMAIN_SCHEMA</code>.
     */
    public DomainsRecord setDomainSchema(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.DOMAINS.DOMAIN_SCHEMA</code>.
     */
    public String getDomainSchema() {
        return (String) get(1);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.DOMAINS.DOMAIN_NAME</code>.
     */
    public DomainsRecord setDomainName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.DOMAINS.DOMAIN_NAME</code>.
     */
    public String getDomainName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.DOMAINS.COLUMN_DEFAULT</code>.
     */
    public DomainsRecord setColumnDefault(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.DOMAINS.COLUMN_DEFAULT</code>.
     */
    public String getColumnDefault() {
        return (String) get(3);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.DOMAINS.IS_NULLABLE</code>.
     */
    public DomainsRecord setIsNullable(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.DOMAINS.IS_NULLABLE</code>.
     */
    public String getIsNullable() {
        return (String) get(4);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.DOMAINS.DATA_TYPE</code>.
     */
    public DomainsRecord setDataType(Integer value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.DOMAINS.DATA_TYPE</code>.
     */
    public Integer getDataType() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.DOMAINS.PRECISION</code>.
     */
    public DomainsRecord setPrecision(Integer value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.DOMAINS.PRECISION</code>.
     */
    public Integer getPrecision() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.DOMAINS.SCALE</code>.
     */
    public DomainsRecord setScale(Integer value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.DOMAINS.SCALE</code>.
     */
    public Integer getScale() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.DOMAINS.TYPE_NAME</code>.
     */
    public DomainsRecord setTypeName(String value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.DOMAINS.TYPE_NAME</code>.
     */
    public String getTypeName() {
        return (String) get(8);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.DOMAINS.SELECTIVITY</code>.
     */
    public DomainsRecord setSelectivity(Integer value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.DOMAINS.SELECTIVITY</code>.
     */
    public Integer getSelectivity() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.DOMAINS.CHECK_CONSTRAINT</code>.
     */
    public DomainsRecord setCheckConstraint(String value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.DOMAINS.CHECK_CONSTRAINT</code>.
     */
    public String getCheckConstraint() {
        return (String) get(10);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.DOMAINS.REMARKS</code>.
     */
    public DomainsRecord setRemarks(String value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.DOMAINS.REMARKS</code>.
     */
    public String getRemarks() {
        return (String) get(11);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.DOMAINS.SQL</code>.
     */
    public DomainsRecord setSql(String value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.DOMAINS.SQL</code>.
     */
    public String getSql() {
        return (String) get(12);
    }

    /**
     * Setter for <code>INFORMATION_SCHEMA.DOMAINS.ID</code>.
     */
    public DomainsRecord setId(Integer value) {
        set(13, value);
        return this;
    }

    /**
     * Getter for <code>INFORMATION_SCHEMA.DOMAINS.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(13);
    }

    // -------------------------------------------------------------------------
    // Record14 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row14<String, String, String, String, String, Integer, Integer, Integer, String, Integer, String, String, String, Integer> fieldsRow() {
        return (Row14) super.fieldsRow();
    }

    @Override
    public Row14<String, String, String, String, String, Integer, Integer, Integer, String, Integer, String, String, String, Integer> valuesRow() {
        return (Row14) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Domains.DOMAINS.DOMAIN_CATALOG;
    }

    @Override
    public Field<String> field2() {
        return Domains.DOMAINS.DOMAIN_SCHEMA;
    }

    @Override
    public Field<String> field3() {
        return Domains.DOMAINS.DOMAIN_NAME;
    }

    @Override
    public Field<String> field4() {
        return Domains.DOMAINS.COLUMN_DEFAULT;
    }

    @Override
    public Field<String> field5() {
        return Domains.DOMAINS.IS_NULLABLE;
    }

    @Override
    public Field<Integer> field6() {
        return Domains.DOMAINS.DATA_TYPE;
    }

    @Override
    public Field<Integer> field7() {
        return Domains.DOMAINS.PRECISION;
    }

    @Override
    public Field<Integer> field8() {
        return Domains.DOMAINS.SCALE;
    }

    @Override
    public Field<String> field9() {
        return Domains.DOMAINS.TYPE_NAME;
    }

    @Override
    public Field<Integer> field10() {
        return Domains.DOMAINS.SELECTIVITY;
    }

    @Override
    public Field<String> field11() {
        return Domains.DOMAINS.CHECK_CONSTRAINT;
    }

    @Override
    public Field<String> field12() {
        return Domains.DOMAINS.REMARKS;
    }

    @Override
    public Field<String> field13() {
        return Domains.DOMAINS.SQL;
    }

    @Override
    public Field<Integer> field14() {
        return Domains.DOMAINS.ID;
    }

    @Override
    public String component1() {
        return getDomainCatalog();
    }

    @Override
    public String component2() {
        return getDomainSchema();
    }

    @Override
    public String component3() {
        return getDomainName();
    }

    @Override
    public String component4() {
        return getColumnDefault();
    }

    @Override
    public String component5() {
        return getIsNullable();
    }

    @Override
    public Integer component6() {
        return getDataType();
    }

    @Override
    public Integer component7() {
        return getPrecision();
    }

    @Override
    public Integer component8() {
        return getScale();
    }

    @Override
    public String component9() {
        return getTypeName();
    }

    @Override
    public Integer component10() {
        return getSelectivity();
    }

    @Override
    public String component11() {
        return getCheckConstraint();
    }

    @Override
    public String component12() {
        return getRemarks();
    }

    @Override
    public String component13() {
        return getSql();
    }

    @Override
    public Integer component14() {
        return getId();
    }

    @Override
    public String value1() {
        return getDomainCatalog();
    }

    @Override
    public String value2() {
        return getDomainSchema();
    }

    @Override
    public String value3() {
        return getDomainName();
    }

    @Override
    public String value4() {
        return getColumnDefault();
    }

    @Override
    public String value5() {
        return getIsNullable();
    }

    @Override
    public Integer value6() {
        return getDataType();
    }

    @Override
    public Integer value7() {
        return getPrecision();
    }

    @Override
    public Integer value8() {
        return getScale();
    }

    @Override
    public String value9() {
        return getTypeName();
    }

    @Override
    public Integer value10() {
        return getSelectivity();
    }

    @Override
    public String value11() {
        return getCheckConstraint();
    }

    @Override
    public String value12() {
        return getRemarks();
    }

    @Override
    public String value13() {
        return getSql();
    }

    @Override
    public Integer value14() {
        return getId();
    }

    @Override
    public DomainsRecord value1(String value) {
        setDomainCatalog(value);
        return this;
    }

    @Override
    public DomainsRecord value2(String value) {
        setDomainSchema(value);
        return this;
    }

    @Override
    public DomainsRecord value3(String value) {
        setDomainName(value);
        return this;
    }

    @Override
    public DomainsRecord value4(String value) {
        setColumnDefault(value);
        return this;
    }

    @Override
    public DomainsRecord value5(String value) {
        setIsNullable(value);
        return this;
    }

    @Override
    public DomainsRecord value6(Integer value) {
        setDataType(value);
        return this;
    }

    @Override
    public DomainsRecord value7(Integer value) {
        setPrecision(value);
        return this;
    }

    @Override
    public DomainsRecord value8(Integer value) {
        setScale(value);
        return this;
    }

    @Override
    public DomainsRecord value9(String value) {
        setTypeName(value);
        return this;
    }

    @Override
    public DomainsRecord value10(Integer value) {
        setSelectivity(value);
        return this;
    }

    @Override
    public DomainsRecord value11(String value) {
        setCheckConstraint(value);
        return this;
    }

    @Override
    public DomainsRecord value12(String value) {
        setRemarks(value);
        return this;
    }

    @Override
    public DomainsRecord value13(String value) {
        setSql(value);
        return this;
    }

    @Override
    public DomainsRecord value14(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public DomainsRecord values(String value1, String value2, String value3, String value4, String value5, Integer value6, Integer value7, Integer value8, String value9, Integer value10, String value11, String value12, String value13, Integer value14) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DomainsRecord
     */
    public DomainsRecord() {
        super(Domains.DOMAINS);
    }

    /**
     * Create a detached, initialised DomainsRecord
     */
    public DomainsRecord(String domainCatalog, String domainSchema, String domainName, String columnDefault, String isNullable, Integer dataType, Integer precision, Integer scale, String typeName, Integer selectivity, String checkConstraint, String remarks, String sql, Integer id) {
        super(Domains.DOMAINS);

        set(0, domainCatalog);
        set(1, domainSchema);
        set(2, domainName);
        set(3, columnDefault);
        set(4, isNullable);
        set(5, dataType);
        set(6, precision);
        set(7, scale);
        set(8, typeName);
        set(9, selectivity);
        set(10, checkConstraint);
        set(11, remarks);
        set(12, sql);
        set(13, id);
    }
}
