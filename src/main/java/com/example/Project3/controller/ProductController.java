package com.example.Project3.controller;

import com.example.Project3.model.Product;
import com.example.Project3.repository.ProductRepository;
import com.example.Project3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="/api")

public class ProductController {
//    private ProductRepository productRepository;
//    @Autowired
//    public void setProductRepository(ProductRepository productRepository){
//        this.productRepository=productRepository;
//    }

    private ProductService productService;

    public void setProductService(ProductService productService){
        this.productService=productService;

    }

//GETALL
@GetMapping(path = "/products/")
public List<Product> getProducts(){
    System.out.println("calling get Product");
    return productService.getProducts();
}

@GetMapping(path = "/products/{productId}")
    public Optional<Product> getProduct(@PathVariable Long productId){
    System.out.println("getting the product with the id of" + productId);
    return productService.getProduct(productId);
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
