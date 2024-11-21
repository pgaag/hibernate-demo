package entitiesjba;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class POrderId implements java.io.Serializable {
    private static final long serialVersionUID = 2704726691273332806L;
    @Size(max = 250)
    @NotNull
    @Column(name = "customer", nullable = false, length = 250)
    private String customer;

    @NotNull
    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        POrderId entity = (POrderId) o;
        return Objects.equals(this.orderDate, entity.orderDate) &&
                Objects.equals(this.customer, entity.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDate, customer);
    }

    @Override
    public String toString() {
        return "POrderId{" +
                "customer='" + customer + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }
}