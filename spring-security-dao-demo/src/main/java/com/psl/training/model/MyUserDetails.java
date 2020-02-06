package com.psl.training.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.psl.training.repository.UserRepository;

public class MyUserDetails implements UserDetails {

	private User user;
	@Autowired
	UserRepository reposity;
	
	public MyUserDetails() {
	}
	
	public MyUserDetails(String userName) {
	// do dao call and get details for userName
		
		//this.user=reposity.findByUsername(userName).orElseThrow(()-> new RuntimeException());
		
		this.user=new User(1, userName, "pass123", "ROLE_USER", true);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		SimpleGrantedAuthority simpleAuth=new SimpleGrantedAuthority("ROLE_USER");
		
		List<SimpleGrantedAuthority> authList=new ArrayList<>();
		authList.add(simpleAuth);
		
		
		return authList;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
