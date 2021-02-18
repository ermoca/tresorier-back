/*
 * This file is generated by jOOQ.
 */
package open.tresorier.generated.jooq.test.information_schema.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SessionState implements Serializable {

    private static final long serialVersionUID = 756569971;

    private final String key;
    private final String sql;

    public SessionState(SessionState value) {
        this.key = value.key;
        this.sql = value.sql;
    }

    public SessionState(
        String key,
        String sql
    ) {
        this.key = key;
        this.sql = sql;
    }

    public String getKey() {
        return this.key;
    }

    public String getSql() {
        return this.sql;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SessionState (");

        sb.append(key);
        sb.append(", ").append(sql);

        sb.append(")");
        return sb.toString();
    }
}