package com.poc.recommendationservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="recommendations")
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recommendationId;
    @Column(name="rate")
    private int rate;
    @Column(name="content")
    private String content;
    @Column(name="productId")
    private Long productId;
    @Column(name="authorId")
    private Long authorId;
    @Column(name="recommendedId")
    private Long recommendedId;
}
