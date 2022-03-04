package com.poc.reviewservice.service;

import com.poc.reviewservice.model.Review;

import java.util.List;

public interface ReviewService {
    Review saveReview(Review review);
    List<Review> getAllReviews();
    Review getReviewById(Long id);
    Review updateReview(Review review, long id_to_change);
    void deleteReview(long id_to_delete);
}
