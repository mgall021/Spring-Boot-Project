package com.example.Project3.service;

import com.example.Project3.exception.InformationExistException;
import com.example.Project3.model.Customer;
import com.example.Project3.model.request.LoginRequest;
import com.example.Project3.repository.CustomerRepository;
import com.example.Project3.security.JWTUtils;
import com.example.Project3.security.MyCustomerDetails;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    private final JWTUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    private final MyCustomerDetails myCustomerDetails;

    public CustomerService(CustomerRepository customerRepository, @Lazy PasswordEncoder passwordEncoder, JWTUtils jwtUtils,
                           @Lazy AuthenticationManager authenticationManager, @Lazy  MyCustomerDetails myCustomerDetails) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.myCustomerDetails = myCustomerDetails;
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
    public Optional<String> loginCustomer(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(loginRequest.getEmailAddress(), loginRequest.getPassword());
        try {
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            MyCustomerDetails myCustomerDetails = (MyCustomerDetails) authentication.getPrincipal();
            return Optional.of(jwtUtils.generateJwtToken(myCustomerDetails));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
