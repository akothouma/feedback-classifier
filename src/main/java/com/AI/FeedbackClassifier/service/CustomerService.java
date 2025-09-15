package com.AI.FeedbackClassifier.service;

import com.AI.FeedbackClassifier.models.Customer;
import com.AI.FeedbackClassifier.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer){
        // --- THIS IS WHERE BUSINESS LOGIC LIVES ---
        // For now, our logic is simple: just save the feedback.
        // We call the 'save' method that Spring Data JPA provided for us.
        return customerRepository.save(customer);
    }


}
