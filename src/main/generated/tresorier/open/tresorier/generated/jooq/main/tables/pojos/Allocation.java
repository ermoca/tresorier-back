/*
 * This file is generated by jOOQ.
 */
package open.tresorier.generated.jooq.main.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Allocation implements Serializable {

    private static final long serialVersionUID = -2064004370;

    private final String     id;
    private final String     categoryId;
    private final Long       allocationMonth;
    private final BigDecimal inflow;
    private final BigDecimal outflow;

    public Allocation(Allocation value) {
        this.id = value.id;
        this.categoryId = value.categoryId;
        this.allocationMonth = value.allocationMonth;
        this.inflow = value.inflow;
        this.outflow = value.outflow;
    }

    public Allocation(
        String     id,
        String     categoryId,
        Long       allocationMonth,
        BigDecimal inflow,
        BigDecimal outflow
    ) {
        this.id = id;
        this.categoryId = categoryId;
        this.allocationMonth = allocationMonth;
        this.inflow = inflow;
        this.outflow = outflow;
    }

    public String getId() {
        return this.id;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public Long getAllocationMonth() {
        return this.allocationMonth;
    }

    public BigDecimal getInflow() {
        return this.inflow;
    }

    public BigDecimal getOutflow() {
        return this.outflow;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Allocation (");

        sb.append(id);
        sb.append(", ").append(categoryId);
        sb.append(", ").append(allocationMonth);
        sb.append(", ").append(inflow);
        sb.append(", ").append(outflow);

        sb.append(")");
        return sb.toString();
    }
}