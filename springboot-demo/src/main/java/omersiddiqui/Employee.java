package omersiddiqui;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Employees")
public class Employee {
	@Id
	private String id;
	private String name;
	private String jobTitle;
	private String region;
	private String email;
	
	protected Employee() {}

	public Employee(String name, String jobTitle, String region, String email) {
		this.name = name;
		this.jobTitle = jobTitle;
		this.region = region;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public String getRegion() {
		return region;
	}

	public String getEmail() {
		return email;
	};

}
