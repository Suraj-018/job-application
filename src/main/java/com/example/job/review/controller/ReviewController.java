package com.example.job.review.controller;

import com.example.job.review.service.ReviewService;
import com.example.job.review.entity.Review;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies/{companyId}/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.findAllReviews(companyId), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Review> getReviewByID(@PathVariable Long id, @PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.findReviewById(id, companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestBody Review review, @PathVariable Long companyId){
        boolean reviewSaved = reviewService.addReview(review, companyId);
        if(reviewSaved)
            return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
        return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateReview(@RequestBody Review review, @PathVariable Long id, @PathVariable Long companyId){
        boolean updatedReview = reviewService.updateReview(review, id, companyId);
        if(updatedReview)
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id, @PathVariable Long companyId){
        boolean deletedReview = reviewService.deleteReview(id, companyId);
        if(deletedReview)
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
    }

}
