package com.example.Project3.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * Represents a customer in the application.
 * This class models a customer entity in the system, storing information such as their name, email address,
 * password (with write-only access for security), associated products, and locations. Additionally, it includes
 * a one-to-one relationship with the customer's profile.
 */
@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    @Column(unique = true)
    private String emailAddress;
    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @OneToMany(mappedBy = "customer")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Product> productList;
    @OneToMany(mappedBy = "customer")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Location> locationList;

    // user profile
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private CustomerProfile customerProfile;

}
