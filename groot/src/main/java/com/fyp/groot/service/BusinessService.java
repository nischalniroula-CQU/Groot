package com.fyp.groot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.Business;
import com.fyp.groot.model.ViewBusinessResponse;
import com.fyp.groot.model.ViewMultipleBusinessRequest;
import com.fyp.groot.model.ViewMultipleBusinessResponse;
import com.fyp.groot.repository.BusinessRepository;

@Service
public class BusinessService {
	
	@Autowired 
    private BusinessRepository businessRepository;

    public Business addBusiness(Business business) {
        // Add business logic here (validation, etc.)
        return businessRepository.save(business); 
    }
    
    public ViewBusinessResponse viewBusiness(Long businessId) {
        Business business = businessRepository.findById(businessId)
                .orElseThrow(() -> new RuntimeException("Business not found with ID: " + businessId));

        return mapBusinessToResponse(business);
    }
    
    
    public ViewMultipleBusinessResponse viewMultipleBusinesses(ViewMultipleBusinessRequest request) {
        // Fetch all businesses from the repository
        List<Business> businesses = businessRepository.findAll();

        // Apply filters based on request parameters
        if (request.getCountry() != null) {
            businesses = businesses.stream()
                    .filter(business -> request.getCountry().equalsIgnoreCase(business.getCountry()))
                    .collect(Collectors.toList());
        }

        if (request.getCategoryID() != null) {
            businesses = businesses.stream()
                    .filter(business -> request.getCategoryID().equals(business.getCategoryID()))
                    .collect(Collectors.toList());
        }

        if (request.getCultureID() != null) {
            businesses = businesses.stream()
                    .filter(business -> request.getCultureID().equals(business.getCultureID()))
                    .collect(Collectors.toList());
        }

        if (request.getCity() != null) {
            businesses = businesses.stream()
                    .filter(business -> request.getCity().equalsIgnoreCase(business.getCity()))
                    .collect(Collectors.toList());
        }

        // Map filtered businesses to response objects
        List<ViewBusinessResponse> businessResponses = businesses.stream()
                .map(this::mapBusinessToResponse)
                .collect(Collectors.toList());

        // Create and return response object
        ViewMultipleBusinessResponse response = new ViewMultipleBusinessResponse();
        response.setBusinesses(businessResponses);
        return response;
    }
    

    private ViewBusinessResponse mapBusinessToResponse(Business business) {
        ViewBusinessResponse response = new ViewBusinessResponse();
        response.setBusinessID(business.getBusinessID());
        response.setName(business.getName());
        response.setSubtitle(business.getSubtitle());
        response.setCategoryID(business.getCategoryID());
        response.setCultureID(business.getCultureID());
        response.setBasicDetails(business.getBasicDetails());
        response.setContactMethod(business.getContactMethod());
        response.setPhoneNumber(business.getPhoneNumber());
        response.setEmailID(business.getEmailID());
        response.setOwnerID(business.getOwnerID());
        response.setLocation(business.getLocation());
        response.setAddress(business.getAddress());
        response.setCity(business.getCity());
        response.setCountry(business.getCountry());
        response.setPriceRange(business.getPriceRange());
        response.setStatus(business.getStatus());
        
        return response;
    }

	public Business findById(Long businessId) {
		//Business business = businessRepository.findById(businessId)
          //      .orElseThrow(() -> new RuntimeException("Business not found with ID: " + businessId));
		//return business;
		return businessRepository.findById(businessId).orElse(null);
	}
    
    

}
