package com.poc.reviewservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    @Column(name="name")
    private String name;
    @Column(name="rating")
    private int rating;
    @Column(name="comment")
    private String comment;
    @Column(name="productId")
    private Long productId;
}
