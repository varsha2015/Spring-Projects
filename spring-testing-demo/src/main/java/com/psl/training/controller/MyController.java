package com.psl.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psl.training.model.User;

@RestController 
@RequestMapping("/greet")
public class MyController {

	@Autowired
private	MyService service;
	
	
	
	
	public MyService getService() {
		return service;
	}

	public void setService(MyService service) {
		this.service = service;
	}

	@GetMapping
	public String sayHello() {
		return "Welcome";
	}
	
	@GetMapping("/users/{userId}")
	public User getUsers(@PathVariable("userId") String userId) {
		return service.getUserById(userId);
	}
}
