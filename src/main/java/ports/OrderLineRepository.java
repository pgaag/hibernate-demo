package ports;

import domain.entities.OrderLine;

import java.util.List;

public interface OrderLineRepository {
    OrderLine findById(int id);
    List<OrderLine> findAll();
    void save(OrderLine order);
    void update(OrderLine order);
    void delete(int id);
}

