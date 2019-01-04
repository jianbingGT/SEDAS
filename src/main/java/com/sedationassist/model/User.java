package com.sedationassist.model;


import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class User {
	  
	@Id
	private ObjectId id;
	private String username;
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ "]";
	}
	private String password;
	private List<String> role;
	
	public List<String> getRoles() {
		 List<String> list = new ArrayList<String>();
		 list.add("USER");  
		return list;
	}


	public void setRole(List<String> role) {
		this.role = role;
	}

	public User() {
	}

	public User(String username,String password) {
		this.username = username;
		this.password = password;
	}

	
	public ObjectId getId() {
		return id;
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
	  	  
}
