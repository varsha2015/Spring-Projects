package com.psl.training.springsecurityjpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@GetMapping("/")
	public String getDefaultPage(){
		return "Welcome Page";
	}
	@GetMapping("/user")
	public String getUserPage(){
		return "User Page";
	}
	@GetMapping("/admin")
	public String getAdminPage(){
		return "Admin Page";
	}
}
