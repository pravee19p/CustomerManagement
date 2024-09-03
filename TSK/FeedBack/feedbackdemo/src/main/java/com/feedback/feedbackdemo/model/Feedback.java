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
    private int rating;
    private String feedbackType;

    public Feedback() {}

    public Feedback(Long id, String customerId, String feedbackText, int rating, String feedbackType) {
        this.id = id;
        this.customerId = customerId;
        this.feedbackText = feedbackText;
        this.rating = rating;
        this.feedbackType = feedbackType;
    }

    // Getters and Setters

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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedbackType() {
        return feedbackType;
    }

    public void setFeedbackType(String feedbackType) {
        this.feedbackType = feedbackType;
    }

    @Override
    public String toString() {
        return "Feedback [id=" + id + ", customerId=" + customerId + ", feedbackText=" + feedbackText + 
               ", rating=" + rating + ", feedbackType=" + feedbackType + "]";
    }
}
