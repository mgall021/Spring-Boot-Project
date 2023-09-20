package com.example.Project3.model;

import javax.persistence.*;

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


}
