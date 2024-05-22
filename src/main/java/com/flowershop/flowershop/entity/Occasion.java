package com.flowershop.flowershop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="occasion")
// @Data -- known bug
@Getter
@Setter
public class Occasion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "occasion_name")
    private String occasionName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "occasion")
    private Set<Product> products;

}







