package merrystaff.service;

import java.util.List;
import merrystaff.model.Employee;

public interface EmployeeServices {
	List<Employee> getAllEmployee();
	void save(Employee employee);
	Employee getById(Long id);
	void deleteViaId(long id);
	List<Employee> search(String query);
}

