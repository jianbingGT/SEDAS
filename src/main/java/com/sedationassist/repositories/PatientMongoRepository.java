package com.sedationassist.repositories;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sedationassist.model.PatientMongo;

@Repository
public interface PatientMongoRepository extends MongoRepository<PatientMongo, String> {
//	public PatientMongo findByid(ObjectId id);
	// public PatientMongo findOneByName(String name);
	public List<PatientMongo> findAll();
	}