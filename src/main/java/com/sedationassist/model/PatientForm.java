package com.sedationassist.model;

import org.springframework.stereotype.Component;

@Component
public class PatientForm {
	private String name;
	private long id;
	private String weight;
    
    public PatientForm() {  	
    }
    
    public PatientForm(String name, long id, String weight) {
    	this.name = name;
    	this.id = id;
    	this.weight = weight;
    	
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getWeight() {
		return weight;
	}

	public void setContactNumber(String weight) {
		this.weight = weight;
	}
    
	@Override
	public String toString() {
		return "PatientForm [name=" + name + ", id=" + id + ", contactNumber=" + weight + "]";
	}
}
