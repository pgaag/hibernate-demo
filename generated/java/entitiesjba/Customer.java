package entitiesjba;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Size(max = 250)
    @Column(name = "e_mail", nullable = false, length = 250)
    private String eMail;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "cname", referencedColumnName = "name", nullable = false),
            @JoinColumn(name = "cbirthday", referencedColumnName = "birthday", nullable = false)
    })
    private entitiesjba.Person person;

    @Column(name = "card_number", precision = 16)
    private BigDecimal cardNumber;

    @Column(name = "expiry_month", precision = 2)
    private BigDecimal expiryMonth;

    @Column(name = "expiry_year", precision = 4)
    private BigDecimal expiryYear;



    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public entitiesjba.Person getPerson() {
        return person;
    }

    public void setPerson(entitiesjba.Person person) {
        this.person = person;
    }

    public BigDecimal getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(BigDecimal cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BigDecimal getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(BigDecimal expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public BigDecimal getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(BigDecimal expiryYear) {
        this.expiryYear = expiryYear;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "eMail='" + eMail + '\'' +
                ", person=" + person +
                ", cardNumber=" + cardNumber +
                ", expiryMonth=" + expiryMonth +
                ", expiryYear=" + expiryYear +
                '}';
    }
}