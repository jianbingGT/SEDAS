package com.sedationassist.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class PatientMongo {
	  @Id
	  public ObjectId id;
	  
	  public String name;
	  public String weight;
	  public String height;
	  
	  public PatientMongo() {}
	  
	  public PatientMongo(ObjectId id, String name, String weight, String height) {
	    this.id = id;
	    this.name = name;
	    this.weight = weight;
	    this.height = height;
	  }
	  
	  public String get_id() { return id.toHexString(); }
	  public void set_id(ObjectId id) { this.id = id; }
	  
	  public String getName() { return name; }
	  public void setName(String name) { this.name = name; }
	  
	  public String getWeight() { return weight; }
	  public void setWeight(String weight) { this.weight = weight; }
	  
	  public String getHeight() { return height; }
	  public void setHeight(String height) { this.height = height; }
}

