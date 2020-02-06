package com.psl.training.springrestjpademo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@XmlRootElement
@ApiModel(value = "Customer Entity")
public class Customer {

	@Id
	private long custid;

	@ApiModelProperty(name = "Customers Name",required = true,example = "a-z charcters allowed ")
	private String custname;
	
	private String city;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	
	public Customer(long custid, String custname, String city) {
		super();
		this.custid = custid;
		this.custname = custname;
		this.city = city;
	}


	public long getCustid() {
		return custid;
	}

	public void setCustid(long custid) {
		this.custid = custid;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", custname=" + custname
				+ ", city=" + city + "]";
	}
	
	
	
	
	
}
