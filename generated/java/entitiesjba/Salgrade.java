package entitiesjba;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "salgrade")
public class Salgrade {
    @Id
    @Column(name = "grade", nullable = false, precision = 2)
    private BigDecimal id;

    @Column(name = "losal", precision = 7, scale = 2)
    private BigDecimal losal;

    @Column(name = "hisal", precision = 7, scale = 2)
    private BigDecimal hisal;

    public Salgrade(BigDecimal id, BigDecimal losal, BigDecimal hisal) {
        this.id = id;
        this.losal = losal;
        this.hisal = hisal;
    }

    public Salgrade() {

    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getLosal() {
        return losal;
    }

    public void setLosal(BigDecimal losal) {
        this.losal = losal;
    }

    public BigDecimal getHisal() {
        return hisal;
    }

    public void setHisal(BigDecimal hisal) {
        this.hisal = hisal;
    }

    @Override
    public String toString() {
        return "Salgrade{" +
                "id=" + id +
                ", losal=" + losal +
                ", hisal=" + hisal +
                '}';
    }
}