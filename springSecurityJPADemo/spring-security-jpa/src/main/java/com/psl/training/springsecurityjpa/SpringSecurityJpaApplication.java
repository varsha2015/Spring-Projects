package com.psl.training.springsecurityjpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.psl.training.springsecurityjpa.model.*;

import com.psl.training.springsecurityjpa.repositories.UserRepository;

@SpringBootApplication
public class SpringSecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(UserRepository repo){
		return args->{
			repo.save(new User(1,"ram","ram",true,"USER"));
			repo.save(new User(2,"ccc","ccc",true,"ADMIN"));
			repo.save(new User(3,"aaa","aaa",true,"USER"));
			repo.save(new User(4,"bbb","bbb",true,"USER"));
		};
	}
}
