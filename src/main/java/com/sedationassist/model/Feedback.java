package com.sedationassist.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Feedback {
    private String selection;
    private String degree;
    private String satisfaction;
    private String recovery;

    public Feedback(String selection, String degree, String satisfaction, String recovery) {
        this.selection = selection;
        this.degree = degree;
        this.satisfaction = satisfaction;
        this.recovery = recovery;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(String satisfaction) {
        this.satisfaction = satisfaction;
    }

    public String getRecovery() {
        return recovery;
    }

    public void setRecovery(String recovery) {
        this.recovery = recovery;
    }
}
