package ports;

import domain.entities.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer findById(int id);
    List<Customer> findAll();
    void save(Customer customer);
    void update(Customer customer);
    void delete(int id);
}
