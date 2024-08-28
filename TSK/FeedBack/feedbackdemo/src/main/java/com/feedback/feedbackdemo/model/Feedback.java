package com.feedback.feedbackdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerId;
    private String feedbackText;
    public Feedback() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getFeedbackText() {
        return feedbackText;
    }
    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }
    public Feedback(Long id, String customerId, String feedbackText) {
        this.id = id;
        this.customerId = customerId;
        this.feedbackText = feedbackText;
    }
    @Override
    public String toString() {
        return "Feedback [id=" + id + ", customerId=" + customerId + ", feedbackText=" + feedbackText + "]";
    }
    

}



