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
import com.fyp.groot.entity.Product;
import com.fyp.groot.entity.Tag;
import com.fyp.groot.model.GetAllBusinessReviewResponse;
import com.fyp.groot.model.GetAllProductsRequest;
import com.fyp.groot.model.GetAllProductsResponse;
import com.fyp.groot.model.GetAllTagsResponse;
import com.fyp.groot.service.BusinessReviewService;

@RestController
@RequestMapping("/api/review")
public class BusinessReviewController {
	
	@Autowired
	BusinessReviewService businessReviewService;
	
	
	@PostMapping("/add")
    public ResponseEntity<BusinessReview> addBusinessReview(@RequestBody BusinessReview businessReview) {
		BusinessReview addedBusinessReview = businessReviewService.addBusinessReview(businessReview);
        return new ResponseEntity<>(addedBusinessReview, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
    public ResponseEntity<GetAllBusinessReviewResponse> getAllBusinessReview() {
        List<BusinessReview> businessReview = businessReviewService.getAllBusinessReview();
        GetAllBusinessReviewResponse response = new GetAllBusinessReviewResponse();
        response.setBusinessReview(businessReview);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

	@GetMapping("/getbyBusinessid")
	public ResponseEntity<List<BusinessReview>> getBusinessReviewByBusinessId(@RequestParam Long businessId) {
		List<BusinessReview> response = businessReviewService.getBusinessReview(businessId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getbyUserid")
	public ResponseEntity<List<BusinessReview>> getBusinessReviewByUserId(@RequestParam Long userId) {
		List<BusinessReview> response = businessReviewService.getBusinessReviewByUserId(userId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
