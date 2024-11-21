package entitiesjba;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "emp")
public class Emp {
    @Id
    @Column(name = "empno", nullable = false, precision = 4)
    private BigDecimal id;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "ename", referencedColumnName = "name", nullable = false),
            @JoinColumn(name = "ebirthday", referencedColumnName = "birthday", nullable = false)
    })
    private entitiesjba.Person person;

    @Size(max = 9)
    @NotNull
    @Column(name = "job", nullable = false, length = 9)
    private String job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mgr")
    private Emp mgr;

    @Column(name = "hiredate")
    private LocalDate hiredate;

    @NotNull
    @Column(name = "sal", nullable = false, precision = 7, scale = 2)
    private BigDecimal sal;

    @Column(name = "comm", precision = 7, scale = 2)
    private BigDecimal comm;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "deptno", nullable = false)
    private Dept deptno;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public entitiesjba.Person getPerson() {
        return person;
    }

    public void setPerson(entitiesjba.Person person) {
        this.person = person;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Emp getMgr() {
        return mgr;
    }

    public void setMgr(Emp mgr) {
        this.mgr = mgr;
    }

    public LocalDate getHiredate() {
        return hiredate;
    }

    public void setHiredate(LocalDate hiredate) {
        this.hiredate = hiredate;
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

    public Dept getDeptno() {
        return deptno;
    }

    public void setDeptno(Dept deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", person=" + person +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptno=" + deptno +
                '}';
    }
}