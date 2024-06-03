package com.fyp.groot.controller;

import com.fyp.groot.model.GetBusinessesByForeignIdRequest;
import com.fyp.groot.model.ViewBusinessResponse;
import com.fyp.groot.model.ViewMultipleBusinessRequest;
import com.fyp.groot.model.ViewMultipleBusinessResponse;
import com.fyp.groot.model.AddBusinessRequest;
import com.fyp.groot.model.AddBusinessResponse;
import com.fyp.groot.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * BusinessController handles HTTP requests for business-related operations.
 */
@RestController
@RequestMapping("/api/business")
public class BusinessController {

    @Autowired
    BusinessService businessService;

    /**
     * Handles POST requests to get all businesses.
     * 
     * @param request the request body containing criteria to view multiple businesses
     * @return a ResponseEntity containing the response with the list of businesses
     */
    @PostMapping("/getall")
    public ResponseEntity<ViewMultipleBusinessResponse> getBusinesses(@RequestBody ViewMultipleBusinessRequest request) {
        ViewMultipleBusinessResponse response = businessService.viewMultipleBusinesses(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles GET requests to view a business by its ID.
     * 
     * @param businessId the ID of the business to view
     * @return a ResponseEntity containing the response with the business details
     */
    @GetMapping("/getbyid")
    public ResponseEntity<ViewBusinessResponse> viewBusiness(@RequestParam Long businessId) {
        ViewBusinessResponse response = businessService.viewBusiness(businessId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles PUT requests to update a business.
     * 
     * @param businessId the ID of the business to update
     * @param request the request body containing the updated business details
     * @return a ResponseEntity containing the response with the updated business details
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<AddBusinessResponse> updateBusiness(@PathVariable("id") Long businessId, @RequestBody AddBusinessRequest request) {
        AddBusinessResponse response = businessService.updateBusiness(request, businessId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles DELETE requests to delete a business by its ID.
     * 
     * @param businessId the ID of the business to delete
     * @return a ResponseEntity with HTTP status OK
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBusiness(@PathVariable("id") Long businessId) {
        businessService.deleteBusiness(businessId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Handles POST requests to add a new business.
     * 
     * @param request the request body containing the new business details
     * @return a ResponseEntity containing the response with the added business details
     */
    @PostMapping("/add")
    public ResponseEntity<AddBusinessResponse> addBusiness(@RequestBody AddBusinessRequest request) {
        AddBusinessResponse response = businessService.addBusiness(request); // Get the response from the service
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Handles POST requests to get businesses by filter criteria.
     * 
     * @param request the request body containing filter criteria
     * @return a ResponseEntity containing the response with the filtered businesses
     */
    @PostMapping("/getbyfilter")
    public ResponseEntity<ViewMultipleBusinessResponse> getBusinessesByFilter(@RequestBody GetBusinessesByForeignIdRequest request) {
        ViewMultipleBusinessResponse response = businessService.getBusinessesByFilter(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
