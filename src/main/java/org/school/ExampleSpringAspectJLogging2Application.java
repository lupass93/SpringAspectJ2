package org.school;

import org.school.abstraction.RepositoryForEmployee;
import org.school.model.Employee;
import org.school.repository.EmployeesRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.gson.Gson;

@SpringBootApplication
public class ExampleSpringAspectJLogging2Application {
	
	
	@Bean
	public RepositoryForEmployee emploeesRepository() {
		
		return EmployeesRepository.getInstance();
		
	}

	public static void main(String[] args) {
		
		Gson gson = new Gson();
		
		Employee example = new Employee(1, "Luca", "Passaretta", "lupass93@gmail.com");
		
		System.out.println(gson.toJson(example));
		
		SpringApplication.run(ExampleSpringAspectJLogging2Application.class, args);
		
	}

}
