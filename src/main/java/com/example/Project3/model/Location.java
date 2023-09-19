package com.example.Project3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.parameters.P;


import javax.persistence.*;
import java.util.List;

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

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "product_id" )
//    private Product product;


}
