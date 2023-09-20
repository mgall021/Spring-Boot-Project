package com.example.Project3.security;

import com.example.Project3.model.Customer;
import com.example.Project3.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Custom UserDetailsService implementation for loading customer details.
 * This class implements the UserDetailsService interface to provide a custom implementation for loading customer details
 * during authentication. It retrieves a Customer object by email address from the CustomerService and wraps it in
 * a MyCustomerDetails object for authentication and authorization purposes.
 */
@Service
public class MyCustomerDetailsService implements UserDetailsService{
    private CustomerService customerService;
@Autowired
    public MyCustomerDetailsService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Load customer details by email address for authentication.
     * @param email The email address used to identify the customer.
     * @return A UserDetails object representing the customer's details.
     * @throws UsernameNotFoundException If the customer with the specified email address is not found.
     */
@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerService.findCustomerByEmailAddress(email);
        return new MyCustomerDetails(customer);
    }

}
