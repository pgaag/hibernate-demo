package entitiesjba;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Entity
@Table(name = "bonus")
public class Bonus {
    @Id
    @Column(name = "bonus_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "empno", nullable = false)
    private entitiesjba.Emp empno;

    @NotNull
    @Column(name = "sal", nullable = false, precision = 7, scale = 2)
    private BigDecimal sal;

    @Column(name = "comm", precision = 7, scale = 2)
    private BigDecimal comm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public entitiesjba.Emp getEmpno() {
        return empno;
    }

    public void setEmpno(entitiesjba.Emp empno) {
        this.empno = empno;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public BigDecimal getComm() {
        return comm;
    }

    public void setComm(BigDecimal comm) {
        this.comm = comm;
    }

    @Override
    public String toString() {
        return "Bonus{" +
                "id=" + id +
                ", empno=" + empno +
                ", sal=" + sal +
                ", comm=" + comm +
                '}';
    }
}