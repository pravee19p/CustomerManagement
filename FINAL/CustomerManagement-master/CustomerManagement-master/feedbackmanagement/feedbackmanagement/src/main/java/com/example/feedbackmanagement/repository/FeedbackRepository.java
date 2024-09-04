package com.example.feedbackmanagement.repository;

import com.example.feedbackmanagement.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
