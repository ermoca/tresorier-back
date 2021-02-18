/*
 * This file is generated by jOOQ.
 */
package open.tresorier.generated.jooq.test.information_schema.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Users implements Serializable {

    private static final long serialVersionUID = 2090638430;

    private final String  name;
    private final String  admin;
    private final String  remarks;
    private final Integer id;

    public Users(Users value) {
        this.name = value.name;
        this.admin = value.admin;
        this.remarks = value.remarks;
        this.id = value.id;
    }

    public Users(
        String  name,
        String  admin,
        String  remarks,
        Integer id
    ) {
        this.name = name;
        this.admin = admin;
        this.remarks = remarks;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getAdmin() {
        return this.admin;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Users (");

        sb.append(name);
        sb.append(", ").append(admin);
        sb.append(", ").append(remarks);
        sb.append(", ").append(id);

        sb.append(")");
        return sb.toString();
    }
}
