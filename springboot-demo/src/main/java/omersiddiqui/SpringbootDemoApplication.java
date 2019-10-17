package omersiddiqui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		System.out.println("starting from demo app main method");
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}
}
