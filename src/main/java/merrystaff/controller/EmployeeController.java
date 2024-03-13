package merrystaff.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import merrystaff.model.Employee;
import merrystaff.serviceImpl.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeServiceImpl;
 
	@GetMapping("/")
	public String viewHomePage(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		model.addAttribute("allemplist", employeeServiceImpl.getAllEmployee());
		return "index";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeServiceImpl.save(employee);
		return "redirect:/";
	}
 
	@GetMapping("/update/{id}")
	public String updateForm(@PathVariable(value = "id") long id, Model model) {
		Employee employee = employeeServiceImpl.getById(id);
		model.addAttribute("employee", employee);
		return "update_employee";
	}
 
	@GetMapping("/delete/{id}")
	public String deleteThroughId(@PathVariable(value = "id") long id) {
		employeeServiceImpl.deleteViaId(id);
		return "redirect:/";
 
	}
	
	@GetMapping("/search")
	@ResponseBody
	public List<Employee> searchEmployees(@RequestParam String query) {
		List<Employee> employees = employeeServiceImpl.search(query);
		return employees;
	}
}