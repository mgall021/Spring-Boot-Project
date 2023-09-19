package com.example.Project3.service;

import com.example.Project3.exception.InformationExistException;
import com.example.Project3.exception.InformationNotFoundException;
import com.example.Project3.model.Product;
import com.example.Project3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

   // Get ALL
    public List<Product> getProducts(){
    System.out.println("service calling get All Products");
    return productRepository.findAll();
    }
// get Product with ID
    public Optional<Product> getProduct(Long productId) {
        System.out.println("service get Product");
        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            return product;
        } else {
            throw new InformationNotFoundException("Product with id" + productId + " not found");
        }
    }


    public Product createProduct(Product productObject) {
        System.out.println("service calling to createProduct ");

        Product product = productRepository.findByName(productObject.getName());
        if (product != null) {
            throw new InformationExistException("category with name " + product.getName() + " already exists");
        } else {
            return productRepository.save(productObject);
        }
    }

    public  String updateProduct(@PathVariable(value = "productId") Long productId, @RequestBody String body){
        return " updating the prooduct with the id of " + productId + body;
    }

    public String deleteProduct(@PathVariable(value = "productId") Long productId){
        return "deleting the product with the id of" + productId;
    }






}
