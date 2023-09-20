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
    private ProductService productService;

    public void setProductService(ProductService productService){
        this.productService=productService;

    }

//GETALL
    /**
     * Retrieve a list of all products.
     * This endpoint retrieves a list of all available products.
     * @return A list of Product objects representing the available products.
     */
@GetMapping(path = "/products/")
public List<Product> getProducts(){
    System.out.println("calling get Product");
    return productService.getProducts();
}
    /**
     * Retrieve a product by its unique identifier.
     * This endpoint retrieves a specific product based on its unique identifier.
     * @param productId The unique identifier of the product to retrieve.
     * @return An Optional containing the Product object if found, or an empty Optional if not found.
     */
@GetMapping(path = "/products/{productId}")
    public Optional<Product> getProduct(@PathVariable Long productId){
    System.out.println("getting the product with the id of" + productId);
    return productService.getProduct(productId);
    }


    /**
     * Create a new product.
     * This endpoint creates a new product by providing the necessary product information
     * in the request body.
     * @param productObject The Product object containing the details of the product to be created.
     * @return The created Product object with its unique identifier assigned.
     */
@PostMapping("/products/")
    public Product createProduct(@RequestBody Product productObject){
    System.out.println( "creating a product");
    return productService.createProduct(productObject);
    }

    /**
     * Update an existing product.
     * This endpoint updates an existing product by providing the product's unique identifier
     * in the URL path and the updated product details in the request body.
     * @param productId The unique identifier of the product to update.
     * @param productObject The Product object containing the updated details of the product.
     * @return The updated Product object with the specified unique identifier.
     */
    @PutMapping("/products/{productId}")
    public  Product updateProduct(@PathVariable(value = "productId") Long productId, @RequestBody Product productObject){
        System.out.println(" updating the product with the id of ");
        return productService.updateProduct(productId,productObject);
    }
    /**
     * Delete a product by its unique identifier.
     * This endpoint deletes a specific product based on its unique identifier.
     * @param productId The unique identifier of the product to delete.
     * @return An Optional containing the deleted Product object if found and deleted, or an empty Optional if not found.
     */
@DeleteMapping("/products/{productId}")
    public Optional<Product> deleteProduct(@PathVariable(value = "productId") Long productId){
    System.out.println( "deleting the product with the id of");
    return productService.deleteProduct(productId);
    }

}
