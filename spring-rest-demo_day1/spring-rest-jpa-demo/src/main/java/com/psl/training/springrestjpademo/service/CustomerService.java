package com.psl.training.springrestjpademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.training.springrestjpademo.dao.CustomerDao;
import com.psl.training.springrestjpademo.exceptions.CustomerNotFoundException;
import com.psl.training.springrestjpademo.model.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerdao ;

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerdao.findAll();
	}

	public Customer getCustomerById(long custid) {
		// TODO Auto-generated method stub
		return customerdao.findById(custid).orElseThrow(()-> {return new CustomerNotFoundException("Data Not Present");});
	}

	public String addCustomer(Customer cust) {
		// TODO Auto-generated method stub
	 customerdao.save(cust);
	 return "Customer added";
	}

	public String deleteCustomerById(long custid) {
		customerdao.deleteById(custid);
		return "Customer deleted ...";
		
	}

	public List<Customer> getCustomersByCity(String city) {
		return customerdao.findByCity(city);
	}

}
