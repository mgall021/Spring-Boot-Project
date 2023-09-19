package com.example.Project3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/api")
public class ProductController {

    public String getProduct(){
        return "get all products";
    }
}
