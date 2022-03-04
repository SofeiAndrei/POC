package com.poc.reviewservice.controller;

import com.poc.reviewservice.model.Review;
import com.poc.reviewservice.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        super();
        this.reviewService = reviewService;
    }
    @PostMapping("/save")
    public ResponseEntity<Review> saveReview(@RequestBody Review review){
        return new ResponseEntity<Review>(reviewService.saveReview(review), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<Review>(reviewService.getReviewById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@RequestBody Review review,@PathVariable(name = "id") Long id_to_change){
        return new ResponseEntity<Review>(reviewService.updateReview(review, id_to_change), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable(name = "id")Long id_to_delete){
        reviewService.deleteReview(id_to_delete);
        return new ResponseEntity<String>("Review deleted successfully!", HttpStatus.OK);
    }
}
