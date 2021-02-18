/*
 * This file is generated by jOOQ.
 */
package open.tresorier.generated.jooq.test.public_;


import java.util.Arrays;
import java.util.List;

import open.tresorier.generated.jooq.test.DefaultCatalog;
import open.tresorier.generated.jooq.test.public_.tables.Account;
import open.tresorier.generated.jooq.test.public_.tables.Allocation;
import open.tresorier.generated.jooq.test.public_.tables.Budget;
import open.tresorier.generated.jooq.test.public_.tables.Category;
import open.tresorier.generated.jooq.test.public_.tables.FlywaySchemaHistory;
import open.tresorier.generated.jooq.test.public_.tables.Operation;
import open.tresorier.generated.jooq.test.public_.tables.Person;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = -1690963215;

    /**
     * The reference instance of <code>PUBLIC</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>PUBLIC.ACCOUNT</code>.
     */
    public final Account ACCOUNT = Account.ACCOUNT;

    /**
     * The table <code>PUBLIC.ALLOCATION</code>.
     */
    public final Allocation ALLOCATION = Allocation.ALLOCATION;

    /**
     * The table <code>PUBLIC.BUDGET</code>.
     */
    public final Budget BUDGET = Budget.BUDGET;

    /**
     * The table <code>PUBLIC.CATEGORY</code>.
     */
    public final Category CATEGORY = Category.CATEGORY;

    /**
     * The table <code>PUBLIC.flyway_schema_history</code>.
     */
    public final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;

    /**
     * The table <code>PUBLIC.OPERATION</code>.
     */
    public final Operation OPERATION = Operation.OPERATION;

    /**
     * The table <code>PUBLIC.PERSON</code>.
     */
    public final Person PERSON = Person.PERSON;

    /**
     * No further instances allowed
     */
    private Public() {
        super("PUBLIC", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            Account.ACCOUNT,
            Allocation.ALLOCATION,
            Budget.BUDGET,
            Category.CATEGORY,
            FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY,
            Operation.OPERATION,
            Person.PERSON);
    }
}
