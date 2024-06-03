package com.fyp.groot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.BusinessReview;
import com.fyp.groot.repository.BusinessReviewRepository;

/**
 * BusinessReviewService handles the business logic for business review-related operations.
 */
@Service
public class BusinessReviewService {

    @Autowired
    BusinessReviewRepository businessReviewRepository;

    /**
     * Retrieves business reviews by business ID.
     * 
     * @param businessId the ID of the business
     * @return a list of business reviews for the specified business
     */
    public List<BusinessReview> getBusinessReview(Long businessId) {
        List<BusinessReview> businessReview = businessReviewRepository.findByBusinessId(businessId);
        
        if (businessReview == null || businessReview.isEmpty()) {
            return List.of();
        }
                
        return businessReview;
    }

    /**
     * Retrieves business reviews by user ID.
     * 
     * @param userId the ID of the user
     * @return a list of business reviews for the specified user
     */
    public List<BusinessReview> getBusinessReviewByUserId(Long userId) {
        List<BusinessReview> businessReview = businessReviewRepository.findByUserId(userId);
        
        if (businessReview.isEmpty()) {
            throw new RuntimeException("No reviews found for user with ID: " + userId);
        }
                
        return businessReview;
    }

    /**
     * Adds a new business review.
     * 
     * @param businessReview the business review to add
     * @return the added business review
     */
    public BusinessReview addBusinessReview(BusinessReview businessReview) {
        return businessReviewRepository.save(businessReview);
    }
    
    /**
     * Retrieves all business reviews.
     * 
     * @return a list of all business reviews
     */
    public List<BusinessReview> getAllBusinessReview() {
        return businessReviewRepository.findAll();
    }
}
