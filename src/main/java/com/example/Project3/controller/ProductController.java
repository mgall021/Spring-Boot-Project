package com.example.Project3.controller;

import com.example.Project3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/api")

public class ProductController {
    private ProductRepository productRepository;
    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository=productRepository;
    }


    @GetMapping(path = "/products/")
    public String getProducts(){
        return "get all products";
    }
@GetMapping(path = "/products/{productId}")
    public String getProduct(@PathVariable Long productId){
        return "getting the product with the id of" + productId;
    }
@PostMapping("/products/")
    public String createProduct(@RequestBody String body){
        return "creating a product" + body;
    }
    @PutMapping("/products/{productId}")
    public  String updateProduct(@PathVariable(value = "productId") Long productId, @RequestBody String body){
        return " updating the prooduct with the id of " + productId + body;
    }
@DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable(value = "productId") Long productId){
        return "deleting the product with the id of" + productId;
    }

}
