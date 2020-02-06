package com.psl.training.springsecurityjpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {

	@Id
	private String id;
	
	private String username;
	private String role;
	private boolean active;
	
}
