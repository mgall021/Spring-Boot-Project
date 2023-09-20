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

/**
 * Service class for managing customer-related operations.
 * This class provides methods for creating customers, finding customers by email address,
 * and handling customer login operations. It also includes validation for duplicate email addresses
 * and uses JWT (JSON Web Token) for authentication and authorization.
 */
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

    /**
     * Create a new customer.
     * @param customerObject The Customer object to create.
     * @return The created customer.
     * @throws InformationExistException If a customer with the same email address already exists.
     */
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


    /**
     * Find a customer by email address.
     * @param email The email address of the customer to find.
     * @return The customer with the specified email address, or null if not found.
     */
    public Customer findCustomerByEmailAddress(String email) {
        return customerRepository.findCustomerByEmailAddress(email);
    }

    /**
     * Authenticate and log in a customer.
     * @param loginRequest The LoginRequest containing email and password for authentication.
     * @return An Optional containing the JWT token if login is successful, or empty if authentication fails.
     */
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
