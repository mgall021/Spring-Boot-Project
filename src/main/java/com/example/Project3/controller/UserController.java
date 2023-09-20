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

    @PostMapping("/register")
    public Customer createCustomer(@RequestBody Customer customerObject) {
        System.out.println("calling create customer ");
        return customerService.createCustomer(customerObject);
    }

    @PostMapping("/login")
    public Optional<String> loginCustomer(@RequestBody LoginRequest loginRequest){
        System.out.println("calling loginUser ==>");
        return customerService.loginCustomer(loginRequest);
    }
}
