package com.example.Project3.seed;

import com.example.Project3.model.Customer;
import com.example.Project3.model.Product;
import com.example.Project3.repository.CustomerRepository;
import com.example.Project3.repository.ProductRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Seed data class for initializing sample data in the application.
 * This class is responsible for seeding sample data into the database during application startup.
 * It creates and saves instances of Customer and Product entities with sample data for testing and development purposes.
 */
public class SeedData {
    private final PasswordEncoder passwordEncoder;

    private final CustomerRepository customerRepository;

    private final ProductRepository productRepository;

    public SeedData(@Lazy PasswordEncoder passwordEncoder, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.passwordEncoder = passwordEncoder;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }
    public void run(String... args) throws Exception {
        Customer customer = new Customer();
        customer.setCustomerName("marco");
        customer.setEmailAddress("mgall@gmail.com");
        customer.setPassword(passwordEncoder.encode("Jomamma"));
        customerRepository.save(customer);

        Product product = new Product();
        product.setName("Apple");
        product.setDescription("Macbook Pro");
        product.setCustomer(customer);
        productRepository.save(product);


    }

}
