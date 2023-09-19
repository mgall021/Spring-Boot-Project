package com.example.Project3.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/api")
public class ProductController {

    public String getProducts(){
        return "get all products";
    }

    public String getProduct(@PathVariable Long productId){
        return "getting the product with the id of" + productId;
    }
}
