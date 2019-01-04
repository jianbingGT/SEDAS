package com.sedationassist.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sedationassist.model.User;


@Repository
public interface UserRepo extends MongoRepository<User, String> {
//	public PatientMongo findByid(ObjectId id);
	// public PatientMongo findOneByName(String name);
	//public List<User> findAll();
	User findByUsername(String username);
	}