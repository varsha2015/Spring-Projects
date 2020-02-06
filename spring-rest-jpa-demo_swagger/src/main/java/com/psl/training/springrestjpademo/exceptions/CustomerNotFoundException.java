package com.psl.training.springrestjpademo.exceptions;

public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public CustomerNotFoundException(String msg) {
		super(msg);
	}
}
