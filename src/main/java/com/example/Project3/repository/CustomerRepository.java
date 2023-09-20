package com.example.Project3.repository;

import com.example.Project3.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Repository interface for managing customer data.
 * This repository interface provides methods for performing database operations related to customer entities.
 * It extends JpaRepository to leverage Spring Data JPA functionality for common CRUD operations.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByEmailAddress(String customerEmailAddress);

    Customer findCustomerByEmailAddress(String emailAddress) ;// to login
}

