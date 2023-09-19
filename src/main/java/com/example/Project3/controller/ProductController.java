package com.example.Project3.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/api")

public class ProductController {
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
    public  String updateProduct(@PathVariable(value = "productId") Long productId, @RequestBody String body){
        return " updating the prooduct with the id of " + productId + body;
    }

}
