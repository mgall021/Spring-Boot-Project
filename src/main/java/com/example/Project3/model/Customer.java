package com.example.Project3.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
@Data
@Entity
@Table(name = "customers")
public class Customer {
private Long id;

private String customerName;

private String emailAddress;

private String password;


}
