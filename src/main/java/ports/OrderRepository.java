package ports;

import domain.entities.Order;

import java.util.List;

public interface OrderRepository {
    Order findById(int id);
    List<Order> findAll();
    void save(Order order);
    void update(Order order);
    void delete(int id);
}
