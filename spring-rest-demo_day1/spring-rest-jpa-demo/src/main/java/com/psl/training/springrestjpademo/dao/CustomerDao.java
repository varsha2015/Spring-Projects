package com.psl.training.springrestjpademo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psl.training.springrestjpademo.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {

	List<Customer> findByCity(String city);
	
}
