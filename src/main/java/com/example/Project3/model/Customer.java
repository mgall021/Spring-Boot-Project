package com.example.Project3.model;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
private Long id;

private String customerName;

private String emailAddress;

private String password;


}
