package com.fyp.groot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fyp.groot.entity.BusinessReview;
import com.fyp.groot.model.GetAllBusinessReviewResponse;
import com.fyp.groot.service.BusinessReviewService;

/**
 * BusinessReviewController handles HTTP requests for business review-related operations.
 */
@RestController
@RequestMapping("/api/review")
public class BusinessReviewController {

    @Autowired
    BusinessReviewService businessReviewService;

    /**
     * Handles POST requests to add a new business review.
     * 
     * @param businessReview the request body containing the business review details
     * @return a ResponseEntity containing the added business review
     */
    @PostMapping("/add")
    public ResponseEntity<BusinessReview> addBusinessReview(@RequestBody BusinessReview businessReview) {
        BusinessReview addedBusinessReview = businessReviewService.addBusinessReview(businessReview);
        return new ResponseEntity<>(addedBusinessReview, HttpStatus.CREATED);
    }

    /**
     * Handles GET requests to get all business reviews.
     * 
     * @return a ResponseEntity containing the response with the list of all business reviews
     */
    @GetMapping("/getAll")
    public ResponseEntity<GetAllBusinessReviewResponse> getAllBusinessReview() {
        List<BusinessReview> businessReview = businessReviewService.getAllBusinessReview();
        GetAllBusinessReviewResponse response = new GetAllBusinessReviewResponse();
        response.setBusinessReview(businessReview);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles GET requests to get business reviews by business ID.
     * 
     * @param businessId the ID of the business
     * @return a ResponseEntity containing the list of business reviews for the specified business
     */
    @GetMapping("/getbyBusinessid")
    public ResponseEntity<List<BusinessReview>> getBusinessReviewByBusinessId(@RequestParam Long businessId) {
        List<BusinessReview> response = businessReviewService.getBusinessReview(businessId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles GET requests to get business reviews by user ID.
     * 
     * @param userId the ID of the user
     * @return a ResponseEntity containing the list of business reviews for the specified user
     */
    @GetMapping("/getbyUserid")
    public ResponseEntity<List<BusinessReview>> getBusinessReviewByUserId(@RequestParam Long userId) {
        List<BusinessReview> response = businessReviewService.getBusinessReviewByUserId(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
