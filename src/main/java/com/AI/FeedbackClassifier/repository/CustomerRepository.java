package com.AI.FeedbackClassifier.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.AI.FeedbackClassifier.models.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
