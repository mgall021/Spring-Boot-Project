package com.example.Project3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
/**
 * Represents the profile information of a customer.
 * This class models the profile information of a customer, including their first name, last name,
 * and a one-to-one relationship with the associated customer.
 */
@Data
@Entity
@Table(name = "profiles")
public class CustomerProfile {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @JsonIgnore
    @OneToOne(mappedBy = "customerProfile")
    private Customer customer;
}
