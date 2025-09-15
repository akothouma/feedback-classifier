package com.AI.FeedbackClassifier.controller;

import com.AI.FeedbackClassifier.models.Customer;
import com.AI.FeedbackClassifier.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;      
import org.springframework.web.bind.annotation.*;

@RestController // @RestController marks this class as a web controller that handles HTTP requests. THIS IS CRITICAL FOR SWAGGER.
@RequestMapping("/api/v1/Customer") // This sets the base URL for all endpoints in this controller.
public class CustomerController {

    private final CustomerService customerService;

    @Autowired // Tells Spring to inject the CustomerService bean.
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> submitCustomer(@RequestBody Customer customer) {
        // @RequestBody tells Spring to convert the incoming JSON into a Customer object.
        Customer savedCustomer = customerService.saveCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }
}
