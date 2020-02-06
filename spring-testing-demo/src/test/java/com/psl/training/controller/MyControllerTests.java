package com.psl.training.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.psl.training.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@Extensions(SpringRunner.class)
public class MyControllerTests {

	@InjectMocks
	MyController controller;

	@MockBean
	private MyService service;

	MockMvc mvc;

	@Before
	public void setUp() {
		controller.setService(service);
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testSayHello() throws Exception {
		MvcResult result = mvc.perform(get("/greet")).andExpect(status().isOk()).andReturn();
		Assert.assertEquals("Welcome To Spring Test", result.getResponse().getContentAsString());
	}

	@Test
	public void testGetUserById() throws Exception {
		// adding mock instance
		controller.setService(service);
		Mockito.when(service.getUserById("101")).thenReturn(new User("101", "Harry"));
		mvc.perform(get("/greet/users/101").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.userid", Matchers.is("101")))
		.andExpect(jsonPath("$.username", Matchers.is("Harry")));
	}
	
	

}
