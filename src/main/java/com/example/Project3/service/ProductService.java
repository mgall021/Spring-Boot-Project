package com.example.Project3.service;

import com.example.Project3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

   // Get ALL
    public String getProducts(){
        return "get all products";
    }
    public String getProduct(@PathVariable Long productId){
        return "getting the product with the id of" + productId;
    }

    public String createProduct(@RequestBody String body){
        return "creating a product" + body;
    }

    public  String updateProduct(@PathVariable(value = "productId") Long productId, @RequestBody String body){
        return " updating the prooduct with the id of " + productId + body;
    }

    public String deleteProduct(@PathVariable(value = "productId") Long productId){
        return "deleting the product with the id of" + productId;
    }

}




}
