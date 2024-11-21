package entitiesjba;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "person")
public class Person {
    @EmbeddedId
    private PersonId id;

    @Size(max = 200)
    @NotNull
    @Column(name = "street", nullable = false, length = 200)
    private String street;

    @NotNull
    @Column(name = "house_number", nullable = false, precision = 3)
    private BigDecimal houseNumber;

    @Size(max = 5)
    @NotNull
    @Column(name = "zip", nullable = false, length = 5, columnDefinition = "bpchar (Types#CHAR)")
    private String zip;

    @Size(max = 100)
    @NotNull
    @Column(name = "city", nullable = false, length = 100)
    private String city;

    public PersonId getId() {
        return id;
    }

    public void setId(PersonId id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public BigDecimal getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(BigDecimal houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}