package com.AI.FeedbackClassifier.controller;

import com.AI.FeedbackClassifier.models.Feedback;
import com.AI.FeedbackClassifier.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;      
import org.springframework.web.bind.annotation.*;

@RestController // @RestController marks this class as a web controller that handles HTTP requests. THIS IS CRITICAL FOR SWAGGER.
@RequestMapping("/api/v1/feedback") // This sets the base URL for all endpoints in this controller.
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired // Tells Spring to inject the FeedbackService bean.
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<Feedback> submitFeedback(@RequestBody Feedback feedback) {
        // @RequestBody tells Spring to convert the incoming JSON into a Feedback object.
        Feedback savedFeedback = feedbackService.saveFeedback(feedback);
        return new ResponseEntity<>(savedFeedback, HttpStatus.CREATED);
    }
}
