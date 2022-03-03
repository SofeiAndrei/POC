package com.poc.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
public class Product {
    @Id
    private int productId;
    private String Name;
    //private type?? image;
    private String brand;
    private String category;
    private String description;
    private int rating;
    private double price;
    private int countInStock;

    public Product(String name, String brand, String category, String description, int rating, double price, int countInStock) {
        Name = name;
        this.brand = brand;
        this.category = category;
        this.description = description;
        this.rating = rating;
        this.price = price;
        this.countInStock = countInStock;
    }
}
