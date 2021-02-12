/*
 * This file is generated by jOOQ.
 */
package open.tresorier.generated.jooq.test.information_schema.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Constants implements Serializable {

    private static final long serialVersionUID = 1759112712;

    private final String  constantCatalog;
    private final String  constantSchema;
    private final String  constantName;
    private final Integer dataType;
    private final String  remarks;
    private final String  sql;
    private final Integer id;

    public Constants(Constants value) {
        this.constantCatalog = value.constantCatalog;
        this.constantSchema = value.constantSchema;
        this.constantName = value.constantName;
        this.dataType = value.dataType;
        this.remarks = value.remarks;
        this.sql = value.sql;
        this.id = value.id;
    }

    public Constants(
        String  constantCatalog,
        String  constantSchema,
        String  constantName,
        Integer dataType,
        String  remarks,
        String  sql,
        Integer id
    ) {
        this.constantCatalog = constantCatalog;
        this.constantSchema = constantSchema;
        this.constantName = constantName;
        this.dataType = dataType;
        this.remarks = remarks;
        this.sql = sql;
        this.id = id;
    }

    public String getConstantCatalog() {
        return this.constantCatalog;
    }

    public String getConstantSchema() {
        return this.constantSchema;
    }

    public String getConstantName() {
        return this.constantName;
    }

    public Integer getDataType() {
        return this.dataType;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public String getSql() {
        return this.sql;
    }

    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Constants (");

        sb.append(constantCatalog);
        sb.append(", ").append(constantSchema);
        sb.append(", ").append(constantName);
        sb.append(", ").append(dataType);
        sb.append(", ").append(remarks);
        sb.append(", ").append(sql);
        sb.append(", ").append(id);

        sb.append(")");
        return sb.toString();
    }
}
