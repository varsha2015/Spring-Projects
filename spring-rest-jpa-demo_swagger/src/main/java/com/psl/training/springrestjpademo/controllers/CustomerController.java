package com.psl.training.springrestjpademo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.psl.training.springrestjpademo.model.Customer;
import com.psl.training.springrestjpademo.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/customers")
@Api(value = "Customer Managent APIs allows to perform CRUD operations for Customer")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@GetMapping("/bycities")
	@ApiOperation(value = " Allow to access customers from specified city ",response = List.class)
	public List<Customer> getCustomersByCity(@RequestParam(value="city" ,required=true) String city){
	return	service.getCustomersByCity(city);
	}
	
	@GetMapping
	@ApiOperation(value = " Allow to access All customers information ",response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success - Customers retrived ")
	} )
	
	
	public List<Customer> getAllCustomers(){
		return service.getAllCustomers();
	}
	
	@GetMapping(value="/{fmt}/{custid}") 
	@ApiOperation(value = " Allow to access  customers information based on ID")
	public ResponseEntity<Customer> getCustomerById(@ApiParam( value = "needs Id of Customer") @PathVariable("custid") long custid,@PathVariable("fmt") String format ){
	//	return new Customer(100L, "Ram", "Pune");
		
	Customer c= service.getCustomerById(custid);
		if(c==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		if(format.equalsIgnoreCase("xml"))
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_XML).body(c);
		else
			return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(c);
	
	}
		
	@PutMapping
	public String updateCustomer(@RequestBody Customer cust){
		service.addCustomer(cust);
		return "ustomer Updated";
	}
	
	
	@PostMapping
	public String createCustomer(@RequestBody Customer cust){
		System.out.println(cust); 
		return service.addCustomer(cust);
	}
	
	@DeleteMapping("/{custid}")
	public String deleteCustomerById(@PathVariable("custid") long custid){
		return service.deleteCustomerById(custid);
	}
	
}
