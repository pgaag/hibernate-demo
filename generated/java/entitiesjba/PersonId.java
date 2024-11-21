package entitiesjba;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class PersonId implements java.io.Serializable {
    private static final long serialVersionUID = 6035535301549017772L;
    @Size(max = 10)
    @NotNull
    @Column(name = "name", nullable = false, length = 10)
    private String name;

    @NotNull
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PersonId entity = (PersonId) o;
        return Objects.equals(this.birthday, entity.birthday) &&
                Objects.equals(this.name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthday, name);
    }

    @Override
    public String toString() {
        return "PersonId{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}