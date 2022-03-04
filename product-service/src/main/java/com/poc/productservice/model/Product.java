package com.poc.productservice.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(name = "name")
    private String name;
    //private type?? image;
    @Column(name = "brand")
    private String brand;
    @Column(name = "category")
    private String category;
    @Column(name = "description")
    private String description;
    @Column(name = "rating")
    private int rating;
    @Column(name = "price")
    private double price;
    @Column(name = "countInStock")
    private int countInStock;
}
