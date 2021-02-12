/*
 * This file is generated by jOOQ.
 */
package open.tresorier.generated.jooq.test.information_schema.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Collations implements Serializable {

    private static final long serialVersionUID = 1709005773;

    private final String name;
    private final String key;

    public Collations(Collations value) {
        this.name = value.name;
        this.key = value.key;
    }

    public Collations(
        String name,
        String key
    ) {
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return this.name;
    }

    public String getKey() {
        return this.key;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Collations (");

        sb.append(name);
        sb.append(", ").append(key);

        sb.append(")");
        return sb.toString();
    }
}
