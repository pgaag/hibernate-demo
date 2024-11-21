package ports;

import domain.entities.Department;

import java.util.List;

public interface DepartmentRepository {
    Department findById(int id);
    List<Department> findAll();
    void save(Department department);
    void update(Department department);
    void delete(int id);
}
