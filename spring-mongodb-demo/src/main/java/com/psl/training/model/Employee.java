package com.psl.training.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {

	@Id
	private String id;
	private String empname;
	private String city;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String empname, String city) {
		super();
		this.empname = empname;
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empname=" + empname + ", city=" + city + "]";
	}
	
	
	
}
