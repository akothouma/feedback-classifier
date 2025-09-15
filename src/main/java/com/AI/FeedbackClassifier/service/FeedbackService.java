package com.AI.FeedbackClassifier.service;


import com.AI.FeedbackClassifier.models.Feedback;
import com.AI.FeedbackClassifier.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    
    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public Feedback saveFeedback(Feedback feedback) {
        // --- THIS IS WHERE BUSINESS LOGIC LIVES ---
        // For now, our logic is simple: just save the feedback.
        // We call the 'save' method that Spring Data JPA provided for us.
        return feedbackRepository.save(feedback);
    }
}