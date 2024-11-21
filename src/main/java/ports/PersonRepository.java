package ports;

import domain.entities.Person;

import java.util.List;

public interface PersonRepository {
    Person findById(int id);
    List<Person> findAll();
    void save(Person order);
    void update(Person order);
    void delete(int id);
}
