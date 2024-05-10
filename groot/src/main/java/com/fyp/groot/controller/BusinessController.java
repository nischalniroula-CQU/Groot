package com.fyp.groot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fyp.groot.model.ViewMultipleBusinessRequest;
import com.fyp.groot.model.ViewMultipleBusinessResponse;
import com.fyp.groot.service.BusinessService;

@RestController
@RequestMapping("/api/business")
public class BusinessController {

	@Autowired
	private BusinessService businessService;

	@PostMapping("/getall")
	public ResponseEntity<ViewMultipleBusinessResponse> viewMultipleBusinesses(
			@RequestBody ViewMultipleBusinessRequest request) {
		ViewMultipleBusinessResponse response = businessService.viewMultipleBusinesses(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

//	@PostMapping("/getbyid")
//    public ResponseEntity<ViewBusinessResponse> viewBusiness(@RequestBody ViewBusinessRequest request) {
//        ViewBusinessResponse response = businessService.viewBusiness(request.getBusinessId());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//	@PutMapping("/updateBusiness/{id}")
//	public ResponseEntity<AddBusinessResponse> updateBusiness(@PathVariable("id") Long businessId, @RequestBody AddBusinessRequest request) {
//	    Business existingBusiness = businessService.findById(businessId);
//	    if (existingBusiness == null) {
//	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//
//	    existingBusiness.setName(request.getName());
//	    existingBusiness.setSubtitle(request.getSubtitle());
//	    existingBusiness.setBasicDetails(request.getBasicDetails());
//	    existingBusiness.setContactMethod(request.getContactMethod());
//	    existingBusiness.setPhoneNumber(request.getPhoneNumber());
//	    existingBusiness.setEmailId(request.getEmailID());
//	    existingBusiness.setLocation(request.getLocation());
//	    existingBusiness.setAddress(request.getAddress());
//	    existingBusiness.setCity(request.getCity());
//	    existingBusiness.setCountry(request.getCountry());
//	    existingBusiness.setPriceRange(request.getPriceRange());
//	    existingBusiness.setStatus(request.getStatus());
//
//	    Business updatedBusiness = businessService.updateBusiness(existingBusiness);
//
//	    AddBusinessResponse response = new AddBusinessResponse();
//	    response.setBusinessID(updatedBusiness.getBusinessId());
//	    response.setName(updatedBusiness.getName());
//	    response.setSubtitle(updatedBusiness.getSubtitle());
//	    response.setBasicDetails(updatedBusiness.getBasicDetails());
//	    response.setContactMethod(updatedBusiness.getContactMethod());
//	    response.setPhoneNumber(updatedBusiness.getPhoneNumber());
//	    response.setEmailID(updatedBusiness.getEmailId());
//	    response.setLocation(updatedBusiness.getLocation());
//	    response.setAddress(updatedBusiness.getAddress());
//	    response.setCity(updatedBusiness.getCity());
//	    response.setCountry(updatedBusiness.getCountry());
//	    response.setPriceRange(updatedBusiness.getPriceRange());
//	    response.setStatus(updatedBusiness.getStatus());
//
//	    return new ResponseEntity<>(response, HttpStatus.OK);
//	}
//	
//	
//	
//	@DeleteMapping("/deleteBusiness/{id}")
//	public ResponseEntity<Void> deleteBusiness(@PathVariable("id") Long businessId) {
//	    Business existingBusiness = businessService.findById(businessId);
//	    if (existingBusiness == null) {
//	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//
//	    businessService.deleteBusiness(businessId);
//	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	}
//	
//	@PostMapping("/businesses")
//    public ResponseEntity<AddBusinessResponse> addBusiness(@RequestBody AddBusinessRequest request) {
//        Business business = new Business();
//        business.setName(request.getName());
//        business.setSubtitle(request.getSubtitle());
//        //business.setCategoryID(request.getCategoryID());
//        //business.setCultureID(request.getCultureID());
//        business.setBasicDetails(request.getBasicDetails());
//        business.setContactMethod(request.getContactMethod());
//        business.setPhoneNumber(request.getPhoneNumber());
//        business.setEmailId(request.getEmailID());
//        //business.setOwnerID(request.getOwnerID());
//        business.setLocation(request.getLocation());
//        business.setAddress(request.getAddress());
//        business.setCity(request.getCity());
//        business.setCountry(request.getCountry());
//        business.setPriceRange(request.getPriceRange());
//        business.setStatus(request.getStatus());
//        
//        Business savedBusiness = businessService.addBusiness(business);
//
//        AddBusinessResponse response = new AddBusinessResponse();
//        response.setBusinessID(savedBusiness.getBusinessId());
//        response.setName(savedBusiness.getName());
//        response.setSubtitle(savedBusiness.getSubtitle());
//        //response.setCategoryID(savedBusiness.getCategoryID());
//        //response.setCultureID(savedBusiness.getCultureID());
//        response.setBasicDetails(savedBusiness.getBasicDetails());
//        response.setContactMethod(savedBusiness.getContactMethod());
//        response.setPhoneNumber(savedBusiness.getPhoneNumber());
//        response.setEmailID(savedBusiness.getEmailId());
//        //response.setOwnerID(savedBusiness.getOwnerID());
//        response.setLocation(savedBusiness.getLocation());
//        response.setAddress(savedBusiness.getAddress());
//        response.setCity(savedBusiness.getCity());
//        response.setCountry(savedBusiness.getCountry());
//        response.setPriceRange(savedBusiness.getPriceRange());
//        response.setStatus(savedBusiness.getStatus());
//        
//        
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//	}

}
