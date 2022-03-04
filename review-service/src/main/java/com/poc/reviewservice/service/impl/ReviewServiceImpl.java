package com.poc.reviewservice.service.impl;

import com.poc.reviewservice.exception.NotFoundException;
import com.poc.reviewservice.model.Review;
import com.poc.reviewservice.repository.ReviewRepository;
import com.poc.reviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        super();
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElseThrow( ()->new NotFoundException("Review", "Id", id));
    }

    @Override
    public Review updateReview(Review review, long id_to_change) {
        Review existing_review = reviewRepository.findById(id_to_change).orElseThrow( ()->new NotFoundException("Review", "Id", id_to_change));
        existing_review.setName(review.getName());
        existing_review.setRating(review.getRating());
        existing_review.setComment(review.getComment());
        reviewRepository.save(existing_review);
        return existing_review;
    }

    @Override
    public void deleteReview(long id_to_delete) {
        reviewRepository.findById(id_to_delete).orElseThrow( ()->new NotFoundException("Review", "Id", id_to_delete));
        reviewRepository.deleteById(id_to_delete);
    }
}
