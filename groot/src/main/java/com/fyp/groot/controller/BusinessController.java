package com.fyp.groot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fyp.groot.entity.Business;
import com.fyp.groot.model.AddBusinessRequest;
import com.fyp.groot.model.AddBusinessResponse;
import com.fyp.groot.service.BusinessService;

@RestController
@RequestMapping("/api/businesses")
public class BusinessController {
	
	@Autowired
    private BusinessService businessService;
	
	@PostMapping
    public ResponseEntity<AddBusinessResponse> addBusiness(@RequestBody AddBusinessRequest request) {
        Business business = new Business();
        business.setName(request.getName());
        business.setSubtitle(request.getSubtitle());
        business.setCategoryID(request.getCategoryID());
        business.setCultureID(request.getCultureID());
        business.setBasicDetails(request.getBasicDetails());
        business.setContactMethod(request.getContactMethod());
        business.setPhoneNumber(request.getPhoneNumber());
        business.setEmailID(request.getEmailID());
        business.setOwnerID(request.getOwnerID());
        business.setLocation(request.getLocation());
        business.setAddress(request.getAddress());
        business.setCity(request.getCity());
        business.setCountry(request.getCountry());
        business.setPriceRange(request.getPriceRange());
        business.setStatus(request.getStatus());
        
        Business savedBusiness = businessService.addBusiness(business);

        AddBusinessResponse response = new AddBusinessResponse();
        response.setBusinessID(savedBusiness.getBusinessID());
        response.setName(savedBusiness.getName());
        response.setSubtitle(savedBusiness.getSubtitle());
        response.setCategoryID(savedBusiness.getCategoryID());
        response.setCultureID(savedBusiness.getCultureID());
        response.setBasicDetails(savedBusiness.getBasicDetails());
        response.setContactMethod(savedBusiness.getContactMethod());
        response.setPhoneNumber(savedBusiness.getPhoneNumber());
        response.setEmailID(savedBusiness.getEmailID());
        response.setOwnerID(savedBusiness.getOwnerID());
        response.setLocation(savedBusiness.getLocation());
        response.setAddress(savedBusiness.getAddress());
        response.setCity(savedBusiness.getCity());
        response.setCountry(savedBusiness.getCountry());
        response.setPriceRange(savedBusiness.getPriceRange());
        response.setStatus(savedBusiness.getStatus());
        
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
