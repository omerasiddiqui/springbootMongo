package omersiddiqui;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private EmployeeRepository employeeRepository;

	public EmployeeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@GetMapping("/all")
	public List<Employee> getAll() {
		List<Employee> employees = this.employeeRepository.findAll();
		
		return employees;
	}
	
	@PutMapping
	public void insert(@RequestBody Employee employee) {
		this.employeeRepository.insert(employee);
	}
	
	@PostMapping
	public void update(@RequestBody Employee employee) {
		this.employeeRepository.save(employee);
	}
	
	@GetMapping("/{id}")
    public Optional<Employee> getById(@PathVariable("id") String id){
        Optional<Employee> employee = this.employeeRepository.findById(id);

        return employee;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		this.employeeRepository.deleteById(id);
	}
	

}
