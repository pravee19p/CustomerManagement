package com.example.feedbackmanagement.service;

import com.example.feedbackmanagement.model.Feedback;
import com.example.feedbackmanagement.repository.FeedbackRepository;
import com.example.feedbackmanagement.client.CustomerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private CustomerClient customerClient;

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Optional<Feedback> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    public Feedback saveFeedback(Feedback feedback) {
        // Validate customer
        if (customerClient.getCustomerById(feedback.getCustomerProfile().getCustomerId()) == null) {
            throw new RuntimeException("Invalid customer");
        }

        return feedbackRepository.save(feedback);
    }

    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}
