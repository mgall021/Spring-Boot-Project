package com.example.Project3.security;

import com.example.Project3.model.Customer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
/**
 * Custom UserDetails implementation representing customer details.
 * This class implements the UserDetails interface to provide customer-specific authentication and authorization details.
 * It encapsulates a Customer object and provides the necessary methods to retrieve user-related information for security purposes.
 */
public class MyCustomerDetails implements UserDetails {
    private Customer customer;
    public MyCustomerDetails(Customer customer){
        this.customer=customer;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<>();
    }

    @Override
    public String getPassword() {
        return customer.getPassword();
    }

    @Override
    public String getUsername() {
        return customer.getEmailAddress();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Customer getUser() {
        return customer;
    }
}

