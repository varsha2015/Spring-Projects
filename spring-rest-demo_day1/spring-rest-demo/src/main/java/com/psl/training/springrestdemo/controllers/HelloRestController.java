package com.psl.training.springrestdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Spring 4 or above
@RestController
public class HelloRestController {

	@GetMapping("/welcome")
	public String sayWelcome(){
		
		return " Hello How Are you?";
	}
	
}
