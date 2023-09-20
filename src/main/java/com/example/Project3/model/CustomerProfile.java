package com.example.Project3.model;

import javax.persistence.*;

@Entity
@Table(name = "profiles")
public class CustomerProfile {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;


    private String lastName;


}
