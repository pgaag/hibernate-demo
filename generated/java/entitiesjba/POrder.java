package entitiesjba;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Entity
@Table(name = "p_order")
public class POrder {
    @EmbeddedId
    private POrderId id;

    @MapsId("customer")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "customer", nullable = false)
    private Customer customer;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "paid", nullable = false, precision = 1)
    private BigDecimal paid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clerk")
    private Emp clerk;

    public POrderId getId() {
        return id;
    }

    public void setId(POrderId id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getPaid() {
        return paid;
    }

    public void setPaid(BigDecimal paid) {
        this.paid = paid;
    }

    public Emp getClerk() {
        return clerk;
    }

    public void setClerk(Emp clerk) {
        this.clerk = clerk;
    }

    @Override
    public String toString() {
        return "POrder{" +
                "id=" + id +
                ", customer=" + customer.toString() +
                ", paid=" + paid +
                ", clerk=" + clerk +
                '}';
    }
}