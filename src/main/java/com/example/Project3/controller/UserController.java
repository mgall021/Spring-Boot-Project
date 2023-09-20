package com.example.Project3.controller;


import com.example.Project3.model.Customer;
import com.example.Project3.model.request.LoginRequest;
import com.example.Project3.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/auth/customers")
public class UserController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Create a new customer.
     * This endpoint creates a new customer by providing the necessary customer information
     * in the request body.
     * @param customerObject The Customer object containing the details of the customer to be created.
     * @return The created Customer object with its unique identifier assigned.
     */
    @PostMapping("/register")
    public Customer createCustomer(@RequestBody Customer customerObject) {
        System.out.println("calling create customer ");
        return customerService.createCustomer(customerObject);
    }

    /**
     * Log in a customer.
     * This endpoint allows a customer to log in by providing their login credentials in the request body.
     * @param loginRequest The LoginRequest object containing the customer's login credentials.
     * @return An Optional containing an authentication token if login is successful, or an empty Optional if login fails.
     */
    @PostMapping("/login")
    public Optional<String> loginCustomer(@RequestBody LoginRequest loginRequest){
        System.out.println("calling loginUser ==>");
        return customerService.loginCustomer(loginRequest);
    }
}
