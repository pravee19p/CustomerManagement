package com.feedback.feedbackdemo.repository;

import com.feedback.feedbackdemo.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}


