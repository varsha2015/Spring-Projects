package com.psl.training.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest
//@WebMvcTest(MyController.class)
public class TestMyController {

	@Autowired
	WebApplicationContext context;
	
	@Autowired
	MockMvc mvc;
	
	
	@Test
	public void testHomePage() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/index")).andExpect(status().isOk());
	}
	
}
