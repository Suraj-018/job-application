package com.example.job.review.service;

import com.example.job.review.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAllReviews(Long companyId);

    Review findReviewById(Long id, Long companyId);

    boolean addReview(Review review, Long companyId);

    boolean updateReview(Review review, Long id, Long companyId);

    boolean deleteReview(Long id, Long companyId);
}
