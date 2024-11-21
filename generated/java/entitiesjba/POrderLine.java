package entitiesjba;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Entity
@Table(name = "p_order_line")
public class POrderLine {
    @EmbeddedId
    private POrderLineId id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "customer", referencedColumnName = "customer", nullable = false),
            @JoinColumn(name = "order_date", referencedColumnName = "order_date", nullable = false)
    })
    private POrder pOrder;

    @MapsId("article")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "article", nullable = false)
    private Article article;

    @NotNull
    @Column(name = "amount", nullable = false, precision = 3)
    private BigDecimal amount;

    @Column(name = "discount", precision = 3, scale = 2)
    private BigDecimal discount;

    public POrderLine(POrderLineId id, POrder pOrder, Article article, BigDecimal amount, BigDecimal discount) {
        this.id = id;
        this.pOrder = pOrder;
        this.article = article;
        this.amount = amount;
        this.discount = discount;
    }

    public POrderLine() {

    }

    public POrderLineId getId() {
        return id;
    }

    public void setId(POrderLineId id) {
        this.id = id;
    }

    public POrder getPOrder() {
        return pOrder;
    }

    public void setPOrder(POrder pOrder) {
        this.pOrder = pOrder;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "POrderLine{" +
                "id=" + id +
                ", pOrder=" + pOrder.toString() +
                ", article=" + article.toString() +
                ", amount=" + amount +
                ", discount=" + discount +
                '}';
    }
}