package com.example.Project3.repository;

import com.example.Project3.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Repository interface for managing product data.
 * This repository interface provides methods for performing database operations related to product entities.
 * It extends JpaRepository to leverage Spring Data JPA functionality for common CRUD operations.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String productName);





}
