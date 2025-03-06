package com.example.job.review.service;

import com.example.job.review.repository.ReviewRepository;
import com.example.job.review.entity.Review;
import com.example.job.company.service.CompanyService;
import com.example.job.company.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> findAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public Review findReviewById(Long id, Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(x -> x.getId().equals(id)).
                findFirst().
                orElse(null);
    }

    @Override
    public boolean addReview(Review review, Long companyId) {
        Company company = companyService.findCompanyById(companyId);
        if(company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReview(Review review, Long id, Long companyId) {
        Optional<Review> existingReview = reviewRepository.findById(id);
        Company company = companyService.findCompanyById(companyId);

        if(existingReview.isPresent() && company != null){
            Review currentReview = existingReview.get();
            currentReview.setTitle(review.getTitle());
            currentReview.setDescription(review.getDescription());
            currentReview.setRating(review.getRating());
            currentReview.setCompany(company);

            reviewRepository.save(currentReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long id, Long companyId) {
        if(companyService.findCompanyById(companyId) != null && reviewRepository.existsById(id)){
            Review review = reviewRepository.findById(id).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);
            companyService.updateCompanyById(companyId, company);
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
