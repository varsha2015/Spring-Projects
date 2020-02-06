package com.psl.training.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.psl.training.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
