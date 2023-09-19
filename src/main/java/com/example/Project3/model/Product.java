package com.example.Project3.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class Product {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column
    private String name;
@Column
    private String description;


}
