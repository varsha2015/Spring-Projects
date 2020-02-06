package com.psl.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.psl.training.model.Employee;
import com.psl.training.repository.EmployeeRepository;

@SpringBootApplication
public class SpringMongodbDemoApplication {


	

	
	public static void main(String[] args) {
		SpringApplication.run(SpringMongodbDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner runMongoCommands() {
		return new  CommandLineRunner() {

			@Autowired
			 EmployeeRepository repo;
			
			@Override
			public void run(String... args) throws Exception {
				
				repo.save(new Employee("Radha","Pune"));
				repo.save(new Employee("Geeta","Mumbai"));
				
				repo.findAll().forEach(System.out::println);
							
			}
			
		};
				
		
	}
}
