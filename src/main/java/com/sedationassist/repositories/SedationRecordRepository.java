package com.sedationassist.repositories;

import com.sedationassist.model.SedationRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SedationRecordRepository extends MongoRepository<SedationRecord, String> {
    public List<SedationRecord> findAll();

    List<SedationRecord> findByPatientFHIR_patientNameAndPatientFHIR_PatientBirthday(String Name, String DOB);
    List<SedationRecord> findByPatientFHIR_PatientId(String ID);

    //SedationRecord findByID(String id);
}