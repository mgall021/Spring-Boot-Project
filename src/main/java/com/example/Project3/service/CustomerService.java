package com.example.Project3.service;

import com.example.Project3.exception.InformationExistException;
import com.example.Project3.model.Customer;
import com.example.Project3.repository.CustomerRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomerService(CustomerRepository customerRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;

    }

    public Customer createCustomer(Customer customerObject) {
        System.out.println("service calling create Customerr ");
        if (!customerRepository.existsByEmailAddress(customerObject.getEmailAddress())) {
            customerObject.setPassword(passwordEncoder.encode(customerObject.getPassword()));
            return customerRepository.save(customerObject);
        } else {
            throw new InformationExistException("customer with email address " + customerObject.getEmailAddress() +
                    " already exists");
        }
    }


    public Customer findCustomerByEmailAddress(String email) {
        return customerRepository.findCustomerByEmailAddress(email);
    }


}
