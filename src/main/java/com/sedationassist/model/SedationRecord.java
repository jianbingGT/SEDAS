package com.sedationassist.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.sedationassist.model.PatientMongo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "SedationRecord")
public class SedationRecord {
    @Id
    private ObjectId sedation_id;
    private PatientFHIR patientFHIR;
    private String patientscore;
    private String patientcategory;
    private String sedationoption;
    private Feedback feedback;
    private long datetime;
    public SedationRecord( ) {
        Date d = new Date();
        this.datetime = d.getTime();
    }

    public SedationRecord(PatientFHIR patientFHIR) {

        this.patientFHIR = patientFHIR;
        Date d = new Date();
        this.datetime = d.getTime();
    }

    public SedationRecord(PatientFHIR patientFHIR, String patientscore, String patientcategory, String sedationoption, Feedback feedback) {
        this.patientFHIR = patientFHIR;
        this.patientscore = patientscore;
        this.patientcategory = patientcategory;
        this.sedationoption = sedationoption;
        this.feedback = feedback;
        Date d = new Date();
        this.datetime = d.getTime();
    }

    public ObjectId getSedation_id() {
        return sedation_id;
    }

    public void setSedation_id(ObjectId sedation_id) {
        this.sedation_id = sedation_id;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    public PatientFHIR getPatientFHIR() {
        return patientFHIR;
    }

    public void setPatientFHIR(PatientFHIR patientFHIR) {
        this.patientFHIR = patientFHIR;
    }

    public String getPatientscore() {
        return patientscore;
    }

    public void setPatientscore(String patientscore) {
        this.patientscore = patientscore;
    }

    public String getPatientcategory() {
        return patientcategory;
    }

    public void setPatientcategory(String patientcategory) {
        this.patientcategory = patientcategory;
    }

    public String getSedationoption() {
        return sedationoption;
    }

    public void setSedationoption(String sedationoption) {
        this.sedationoption = sedationoption;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }
}