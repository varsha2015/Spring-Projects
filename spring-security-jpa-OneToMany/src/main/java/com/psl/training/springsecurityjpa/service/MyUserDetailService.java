package com.psl.training.springsecurityjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.psl.training.springsecurityjpa.model.MyUserDetails;
import com.psl.training.springsecurityjpa.model.User;
import com.psl.training.springsecurityjpa.repositories.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// call JPA repository to get Correct User instance based on User Name
		// throw new Exception if Not found
		
		// inject it to MyUserDetails Model and Get userdetails will get consumed for AuthenticationBuilder
		User user=userRepo.findByUsername(username).orElseThrow(()-> new RuntimeException("Not Found"));
		
		
		UserDetails userDetails=new MyUserDetails(user);
		return userDetails;
	}

}
