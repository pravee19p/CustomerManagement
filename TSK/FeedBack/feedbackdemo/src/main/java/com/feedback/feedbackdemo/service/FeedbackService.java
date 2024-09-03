package com.feedback.feedbackdemo.service;

import com.feedback.feedbackdemo.model.Feedback;
import com.feedback.feedbackdemo.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {
    private final FeedbackRepository repository;

    public FeedbackService(FeedbackRepository repository) {
        this.repository = repository;
    }

    public Feedback submitFeedback(Feedback feedback) {
        return repository.save(feedback);
    }

    public Optional<Feedback> getFeedback(Long id) {
        return repository.findById(id);
    }

    public List<Feedback> getAllFeedbacks() {
        return repository.findAll();
    }
}
