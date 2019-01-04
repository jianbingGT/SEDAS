package com.sedationassist.model;

public class PatientFHIR {
    String patientName;
    String patientAge;
    String patientBirthday;
    String patientId;
    String patientHeight;
    String patientWeight;
    String patientBloodPres;
    String patientGender;
    String patientBmi;
    Boolean isSmoking;
    Boolean isBenzo;
    Boolean isOpioid;
    Boolean isOther;
    String patientPhone;
    String patientAddress;

    public PatientFHIR() {

    }

    public PatientFHIR(String patientName, String patientAge, String patientBirthday, String patientId, String patientHeight, String patientWeight, String patientBloodPres, String patientGender, String patientBmi, Boolean isSmoking, Boolean isBenzo, Boolean isOpioid, Boolean isOther, String patientPhone, String patientAddress) {
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientBirthday = patientBirthday;
        this.patientId = patientId;
        this.patientHeight = patientHeight;
        this.patientWeight = patientWeight;
        this.patientBloodPres = patientBloodPres;
        this.patientGender = patientGender;
        this.patientBmi = patientBmi;
        this.isSmoking = isSmoking;
        this.isBenzo = isBenzo;
        this.isOpioid = isOpioid;
        this.isOther = isOther;
        this.patientPhone = patientPhone;
        this.patientAddress = patientAddress;
    }


    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientBirthday() {
        return patientBirthday;
    }

    public void setPatientBirthday(String patientBirthday) {
        this.patientBirthday = patientBirthday;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientHeight() {
        return patientHeight;
    }

    public void setPatientHeight(String patientHeight) {
        this.patientHeight = patientHeight;
    }

    public String getPatientWeight() {
        return patientWeight;
    }

    public void setPatientWeight(String patientWeight) {
        this.patientWeight = patientWeight;
    }

    public String getPatientBloodPres() {
        return patientBloodPres;
    }

    public void setPatientBloodPres(String patientBloodPres) {
        this.patientBloodPres = patientBloodPres;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientBmi() {
        return patientBmi;
    }

    public void setPatientBmi(String patientBmi) {
        this.patientBmi = patientBmi;
    }

    public Boolean getSmoking() {
        return isSmoking;
    }

    public void setSmoking(Boolean smoking) {
        isSmoking = smoking;
    }

    public Boolean getBenzo() {
        return isBenzo;
    }

    public void setBenzo(Boolean benzo) {
        isBenzo = benzo;
    }

    public Boolean getOpioid() {
        return isOpioid;
    }

    public void setOpioid(Boolean opioid) {
        isOpioid = opioid;
    }

    public Boolean getOther() {
        return isOther;
    }

    public void setOther(Boolean other) {
        isOther = other;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }
}

