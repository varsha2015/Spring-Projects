package com.psl.training.springsecurityjpa.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.UniqueElements;

@Entity
public class User {

	@Id
	private int userid;
	@UniqueElements
	private String username;
	private String password;
	private boolean active;
	@OneToMany
	@JoinColumn(name="username")
	private List<Role> roles;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	


	public User(int userid, String username, String password, boolean active,
			String role) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.active = active;
	//	this.role = role;
	}





	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

/*	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
*/


	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username
				+ ", password=" + password + ", active=" + active + ", role="
				+ roles + "]";
	}
	
	
	
	
}