package omersiddiqui;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.reflect.Array;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner {
	
	private EmployeeRepository employeeRepository;
	
	
	
	public DbSeeder(EmployeeRepository hotelRepository) {
		this.employeeRepository = hotelRepository;
	}



	@Override
	public void run(String... strings) throws Exception {
		System.out.println("starting main method from db seeder");
		
		Employee employee1 = new Employee(
				"Ervin Howell",
				"Developer",
				"South West",
				"Shanna@melissa.tv"
		);
		
		Employee employee2 = new Employee(
				"Clementine Bauch",
				"Sales",
				"Southeast",
				"Nathan@yesenia.net"
		);
		
		Employee employee3 = new Employee(
				"Kurtis Weissnat",
				"Human Resources",
				"Midwest",
				"Kurtis Weissnat"
		);

		
		// drop all hotels
		this.employeeRepository.deleteAll();
		
		// add our hotels to the database
		List<Employee> employees = Arrays.asList(employee1, employee2, employee3);
		this.employeeRepository.saveAll(employees);
		
	}

}