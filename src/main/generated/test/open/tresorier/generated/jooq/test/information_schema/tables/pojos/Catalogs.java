/*
 * This file is generated by jOOQ.
 */
package open.tresorier.generated.jooq.test.information_schema.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Catalogs implements Serializable {

    private static final long serialVersionUID = -1197865790;

    private final String catalogName;

    public Catalogs(Catalogs value) {
        this.catalogName = value.catalogName;
    }

    public Catalogs(
        String catalogName
    ) {
        this.catalogName = catalogName;
    }

    public String getCatalogName() {
        return this.catalogName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Catalogs (");

        sb.append(catalogName);

        sb.append(")");
        return sb.toString();
    }
}
