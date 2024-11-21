package helper;

import java.time.LocalDate;

public class PersonData {

    private String name; // Name (character varying(10))
    private LocalDate birthday; // Birthday (date)
    private String city; // City (character varying(100))

    // Constructor
    public PersonData(String name, LocalDate birthday, String city) {
        this.name = name;
        this.birthday = birthday;

        this.city = city;
    }

    public PersonData() {}

    // Getters and Setters
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // toString method for easy display
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", city='" + city + '\'' +
                '}';
    }
}

