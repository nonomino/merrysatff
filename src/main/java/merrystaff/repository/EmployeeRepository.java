package merrystaff.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import merrystaff.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	List<Employee> findByNameContainingIgnoreCase(String name);
}
