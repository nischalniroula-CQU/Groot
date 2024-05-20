package com.fyp.groot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.BusinessReview;
import com.fyp.groot.entity.Product;
import com.fyp.groot.entity.Tag;
import com.fyp.groot.model.AddProductRequest;
import com.fyp.groot.model.GetAllProductsRequest;
import com.fyp.groot.repository.BusinessReviewRepository;

@Service
public class BusinessReviewService {
	
	@Autowired
	BusinessReviewRepository businessReviewRepository;
	
	public List<BusinessReview> getBusinessReview(Long businessId) {
		List<BusinessReview> businessReview = businessReviewRepository.findByBusinessId(businessId);
		
		if (businessReview.isEmpty()) {
	        throw new RuntimeException("No reviews found for business with ID: " + businessId);
	    }
				
		return businessReview;
	}
	
	public List<BusinessReview> getBusinessReviewByUserId(Long userId) {
		List<BusinessReview> businessReview = businessReviewRepository.findByUserId(userId);
		
		if (businessReview.isEmpty()) {
	        throw new RuntimeException("No reviews found of user with ID: " + userId);
	    }
				
		return businessReview;
	}
	
	public BusinessReview addBusinessReview(BusinessReview businessReview) {
        // Add business logic as required (validation, etc.)
        return businessReviewRepository.save(businessReview);
    }
    
    public List<BusinessReview> getAllBusinessReview() {
        return businessReviewRepository.findAll();
    }

}
