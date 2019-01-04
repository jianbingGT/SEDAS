package com.sedationassist.model;



import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class UserForm {
	  
	private String username;
	@Override
	public String toString() {
		return ", username=" + username + ", password=" + password +  ", passwordConfirm=" + passwordConfirm +", role=" + role
				+ "]";
	}
	private String password;
	private String passwordConfirm;
	private List<String> role;
	
	public List<String> getRoles() {
		 List<String> list = new ArrayList<String>();
		 list.add("USER");  
		return list;
	}


	public void setRole(List<String> role) {
		this.role = role;
	}

	public UserForm() {
	}

	public UserForm(String username,String password, String passwordConfirm) {
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
//		List<String> list = new ArrayList<String>();
//		list.add("USER");
//		this.role = list;
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
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	  
	  
}
