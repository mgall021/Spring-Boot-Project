package com.example.Project3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
/**
 * Represents a location associated with a product and customer.
 * This class models a location entity in the system, storing information such as the city, state, and country.
 * It is associated with both a product and a customer. The relationship with the product is many-to-one,
 * and the relationship with the customer is also many-to-one.
 */

@Data
@Entity
@Table(name = "location")
/**
 * passes variables id, city, state, and country
 */
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String country;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
