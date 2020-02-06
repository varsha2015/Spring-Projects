package com.psl.training.springrestdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// http://localhost:9090/hi - GET
// spring 3
@Controller
@ResponseBody
public class HelloController {

	@RequestMapping(value="/hi" , method=RequestMethod.GET)
	public String sayHello(){
		return "Welcome to Spring Rest";
	}
}
