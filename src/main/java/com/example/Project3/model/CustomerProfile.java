package com.example.Project3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
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
