package com.psl.training.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	
	
	@GetMapping("/index")
	public String getHomePage() {
		return " Welcome to Home Page";
	}
	
	@GetMapping("/user")
	public String getUserPage() {
		return " Welcome to User Page";
	}

	@GetMapping("/admin")
	public String getAdminPage() {
		return "Welcome to Admin Page";
	}
}
