package entitiesjba;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @Size(max = 100)
    @Column(name = "art_name", nullable = false, length = 100)
    private String artName;

    @Size(max = 4000)
    @NotNull
    @Column(name = "description", nullable = false, length = 4000)
    private String description;

    @NotNull
    @Column(name = "price", nullable = false, precision = 7, scale = 2)
    private BigDecimal price;

    @Column(name = "shipping_surcharge", precision = 5, scale = 2)
    private BigDecimal shippingSurcharge;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department", nullable = false)
    private entitiesjba.Dept department;

    public Article(String artName, String description, BigDecimal price, BigDecimal shippingSurcharge, Dept department) {
        this.artName = artName;
        this.description = description;
        this.price = price;
        this.shippingSurcharge = shippingSurcharge;
        this.department = department;
    }

    public Article() {

    }

    public String getArtName() {
        return artName;
    }

    public void setArtName(String artName) {
        this.artName = artName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getShippingSurcharge() {
        return shippingSurcharge;
    }

    public void setShippingSurcharge(BigDecimal shippingSurcharge) {
        this.shippingSurcharge = shippingSurcharge;
    }

    public entitiesjba.Dept getDepartment() {
        return department;
    }

    public void setDepartment(entitiesjba.Dept department) {
        this.department = department;
    }
    @Override
    public String toString() {
        return "Article{" +
                "artName='" + artName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", shippingSurcharge=" + shippingSurcharge +
                ", department=" + department.toString() +
                '}';
    }
}