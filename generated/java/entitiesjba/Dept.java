package entitiesjba;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "dept")
public class Dept {
    @Id
    @Column(name = "deptno", nullable = false, precision = 2)
    private BigDecimal id;

    @Size(max = 14)
    @NotNull
    @Column(name = "dname", nullable = false, length = 14)
    private String dname;

    @Size(max = 13)
    @NotNull
    @Column(name = "loc", nullable = false, length = 13)
    private String loc;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}