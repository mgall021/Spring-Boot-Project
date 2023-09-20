package com.example.Project3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.List;
/**
 * Represents a product in the application.
 * This class models a product entity in the system, storing information such as the product name,
 * description, associated locations, and the customer who owns the product.
 */
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Location> locationsList;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
