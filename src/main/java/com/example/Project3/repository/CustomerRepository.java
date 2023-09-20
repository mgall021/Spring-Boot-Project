package com.example.Project3.repository;

import com.example.Project3.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByEmailAddress(String customerEmailAddress);

    Customer findCustomerByEmailAddress(String emailAddress) ;// to login
}

