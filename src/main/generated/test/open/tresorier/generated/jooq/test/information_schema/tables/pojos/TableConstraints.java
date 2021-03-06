/*
 * This file is generated by jOOQ.
 */
package open.tresorier.generated.jooq.test.information_schema.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TableConstraints implements Serializable {

    private static final long serialVersionUID = -2040587224;

    private final String constraintCatalog;
    private final String constraintSchema;
    private final String constraintName;
    private final String constraintType;
    private final String tableCatalog;
    private final String tableSchema;
    private final String tableName;
    private final String isDeferrable;
    private final String initiallyDeferred;

    public TableConstraints(TableConstraints value) {
        this.constraintCatalog = value.constraintCatalog;
        this.constraintSchema = value.constraintSchema;
        this.constraintName = value.constraintName;
        this.constraintType = value.constraintType;
        this.tableCatalog = value.tableCatalog;
        this.tableSchema = value.tableSchema;
        this.tableName = value.tableName;
        this.isDeferrable = value.isDeferrable;
        this.initiallyDeferred = value.initiallyDeferred;
    }

    public TableConstraints(
        String constraintCatalog,
        String constraintSchema,
        String constraintName,
        String constraintType,
        String tableCatalog,
        String tableSchema,
        String tableName,
        String isDeferrable,
        String initiallyDeferred
    ) {
        this.constraintCatalog = constraintCatalog;
        this.constraintSchema = constraintSchema;
        this.constraintName = constraintName;
        this.constraintType = constraintType;
        this.tableCatalog = tableCatalog;
        this.tableSchema = tableSchema;
        this.tableName = tableName;
        this.isDeferrable = isDeferrable;
        this.initiallyDeferred = initiallyDeferred;
    }

    public String getConstraintCatalog() {
        return this.constraintCatalog;
    }

    public String getConstraintSchema() {
        return this.constraintSchema;
    }

    public String getConstraintName() {
        return this.constraintName;
    }

    public String getConstraintType() {
        return this.constraintType;
    }

    public String getTableCatalog() {
        return this.tableCatalog;
    }

    public String getTableSchema() {
        return this.tableSchema;
    }

    public String getTableName() {
        return this.tableName;
    }

    public String getIsDeferrable() {
        return this.isDeferrable;
    }

    public String getInitiallyDeferred() {
        return this.initiallyDeferred;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TableConstraints (");

        sb.append(constraintCatalog);
        sb.append(", ").append(constraintSchema);
        sb.append(", ").append(constraintName);
        sb.append(", ").append(constraintType);
        sb.append(", ").append(tableCatalog);
        sb.append(", ").append(tableSchema);
        sb.append(", ").append(tableName);
        sb.append(", ").append(isDeferrable);
        sb.append(", ").append(initiallyDeferred);

        sb.append(")");
        return sb.toString();
    }
}
