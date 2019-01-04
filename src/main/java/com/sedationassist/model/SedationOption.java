package com.sedationassist.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
@Document
public class SedationOption {

    private String drug;
    private String dose;
    private Integer duration;


    public SedationOption(String drug, String dose, Integer duration) {
        this.drug = drug;
        this.dose = dose;
        this.duration = duration;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "SedationOption{" +
                "drug='" + drug + '\'' +
                ", dose='" + dose + '\'' +
                ", duration=" + duration +
                '}';
    }
}

