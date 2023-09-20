package com.example.Project3.security;

import com.example.Project3.service.CustomerService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class MyCustomerDetailsService implements UserDetailsService{
    private CustomerService customerService;

    public MyCustomerDetailsService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
