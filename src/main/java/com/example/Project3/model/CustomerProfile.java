package com.example.Project3.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "profiles")
public class CustomerProfile {

    private Long id;

    private String firstName;


    private String lastName;


}
