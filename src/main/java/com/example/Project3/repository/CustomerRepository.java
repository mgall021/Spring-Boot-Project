package com.example.Project3.repository;

import com.example.Project3.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository extends JpaRepository<Customer, long> {
    boolean existsByEmailAddress(String customerEmailAddress);

    Customer findUserByEmailAddress(String emailAddress) ;// to login
}

