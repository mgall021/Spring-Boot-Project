package com.example.Project3.service;

import com.example.Project3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepositoryRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



}
