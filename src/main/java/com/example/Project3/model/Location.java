package com.example.Project3.model;

import lombok.Data;


import javax.persistence.*;

@Data // sets up all my setters, getters, To string classes
@Entity
@Table(name = "location")
/**
 * passes variables id,city,state,and country
 */
public class Location {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String country;



}
