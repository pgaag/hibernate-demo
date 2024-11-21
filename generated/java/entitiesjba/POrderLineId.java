package entitiesjba;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class POrderLineId implements java.io.Serializable {
    private static final long serialVersionUID = -7838127596264934128L;
    @Size(max = 250)
    @NotNull
    @Column(name = "customer", nullable = false, length = 250)
    private String customer;

    @NotNull
    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    @Size(max = 100)
    @NotNull
    @Column(name = "article", nullable = false, length = 100)
    private String article;

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

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        POrderLineId entity = (POrderLineId) o;
        return Objects.equals(this.orderDate, entity.orderDate) &&
                Objects.equals(this.article, entity.article) &&
                Objects.equals(this.customer, entity.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDate, article, customer);
    }

    @Override
    public String toString() {
        return "POrderLineId{" +
                "customer='" + customer + '\'' +
                ", orderDate=" + orderDate +
                ", article='" + article + '\'' +
                '}';
    }
}