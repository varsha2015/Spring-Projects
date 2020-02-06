package com.psl.training.model;

public class User {
private 	String userid;
private	String username;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userid, String username) {
		super();
		this.userid = username ;
		this.username = userid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
