package com.psl.training.controller;

import org.springframework.stereotype.Service;

import com.psl.training.model.User;

@Service
public class MyService {

	public User getUserById(String userId) {
		return new User();
		
	}

}
