package merrystaff.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import merrystaff.model.Employee;
import merrystaff.repository.EmployeeRepository;
import merrystaff.service.EmployeeServices;
@Service
public class EmployeeService implements EmployeeServices {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public void save(Employee employee) {
		empRepo.save(employee);
	}

	@Override
	public Employee getById(Long id) {
		Optional<Employee> optional = empRepo.findById(id);
		Employee employee = null;
		if (optional.isPresent())
			employee = optional.get();
		else
			throw new RuntimeException("Employee not found for id : " + id);
		return employee;
	}
	 
	@Override
	public void deleteViaId(long id) {
		empRepo.deleteById(id);
	}
	
	@Override
	public List<Employee> search(String query) {
		return empRepo.findByNameContainingIgnoreCase(query);
	}
}
