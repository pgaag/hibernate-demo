package ports;

import domain.entities.Bonus;

import java.util.List;

public interface BonusRepository {
    Bonus findById(int id);
    List<Bonus> findAll();
    void save(Bonus bonus);
    void update(Bonus bonus);
    void delete(int id);
}
