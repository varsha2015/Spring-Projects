package com.psl.training.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	//accessb 
	@GetMapping("/index")
	public String getHomePage() {
		return " Welcome to Home Page";
	}
	
	// only ppl with user role will access this
	@GetMapping("/user")
	public String getUserPage() {
		return " Welcome to User Page";
	}
	// only ppl with Admin rol will access this
	@GetMapping("/admin")
	public String getAdminPage() {
		return "Welcome to Admin Page";
	}
}
