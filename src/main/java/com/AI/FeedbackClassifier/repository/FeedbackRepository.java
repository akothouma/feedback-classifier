package com.AI.FeedbackClassifier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AI.FeedbackClassifier.models.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer>{

}
