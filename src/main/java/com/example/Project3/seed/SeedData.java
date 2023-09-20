package com.example.Project3.seed;

import com.example.Project3.repository.CustomerRepository;
import com.example.Project3.repository.ProductRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SeedData {
    private final PasswordEncoder passwordEncoder;

    private final CustomerRepository customerRepository;

    private final ProductRepository productRepository;

    public SeedData(@Lazy PasswordEncoder passwordEncoder, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.passwordEncoder = passwordEncoder;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }


}
