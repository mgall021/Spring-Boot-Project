package com.example.Project3.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerService customerService;
    private final PasswordEncoder passwordEncoder;

}
