package com.fyp.groot.service;

import com.fyp.groot.entity.Business;
import com.fyp.groot.model.GetBusinessesByForeignIdRequest;
import com.fyp.groot.model.ViewBusinessResponse;
import com.fyp.groot.model.ViewMultipleBusinessRequest;
import com.fyp.groot.model.ViewMultipleBusinessResponse;
import com.fyp.groot.model.junk.AddBusinessRequest;
import com.fyp.groot.model.junk.AddBusinessResponse;
import com.fyp.groot.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessService {

	@Autowired
	private BusinessRepository businessRepository;

	private Business mapRequestToBusiness(AddBusinessRequest request, Business business) {

		business = Business.builder().name(request.getName()).subtitle(request.getSubtitle()).basicDetails(request.getBasicDetails())
				.contactMethod(request.getContactMethod()).phoneNumber(request.getPhoneNumber()).emailId(request.getEmailId()).location(request.getLocation())
				.address(request.getAddress()).city(request.getCity()).country(request.getCountry()).priceRange(request.getPriceRange())
				.status(request.getStatus()).addOn(request.getAddOn()).latitude(request.getLatitude()).longitude(request.getLongitude())
				.categoryId(request.getCategoryId()).cultureId(request.getCultureId()).ownerId(request.getOwnerId()).build();

		return business;
	}

	public ViewBusinessResponse viewBusiness(Long businessId) {
		Business business = businessRepository.findById(businessId).orElseThrow(() -> new RuntimeException("Business not found with ID: " + businessId));

		return mapBusinessToResponse(business);
	}

	public AddBusinessResponse updateBusiness(AddBusinessRequest request, Long businessId) {
		AddBusinessResponse response = new AddBusinessResponse();

		Business existingBusiness = businessRepository.findById(businessId).orElseThrow();
		existingBusiness = mapRequestToBusiness(request, existingBusiness);

		Business updatedBusiness = businessRepository.save(existingBusiness);
		response.setBusiness(updatedBusiness);
		return response;
	}

	public Business addBusiness(AddBusinessRequest request) {
		// Add business logic here (validation, etc.)
		Business business = mapRequestToBusiness(request, new Business());
		return businessRepository.save(business);
	}

	public void deleteBusiness(Long businessId) {
		businessRepository.deleteById(businessId);
	}

	public ViewMultipleBusinessResponse viewMultipleBusinesses(ViewMultipleBusinessRequest request) {
		// Fetch all businesses from the repository
		List<Business> businesses = businessRepository.findAll();

		// Apply filters based on request parameters
		if (request.getCountry() != null) {
			businesses = businesses.stream().filter(business -> request.getCountry().equalsIgnoreCase(business.getCountry())).collect(Collectors.toList());
		}

		if (request.getCategoryID() != null) {
			businesses = businesses.stream().filter(business -> request.getCategoryID().equals(business.getCategoryId())).collect(Collectors.toList());
		}

		if (request.getName() != null) {
			businesses = businesses.stream().filter(business -> request.getName().equalsIgnoreCase(business.getName())).collect(Collectors.toList());
		}

		if (request.getCultureID() != null) {
			businesses = businesses.stream().filter(business -> request.getCultureID().equals(business.getCultureId())).collect(Collectors.toList());
		}

		if (request.getCity() != null) {
			businesses = businesses.stream().filter(business -> request.getCity().equalsIgnoreCase(business.getCity())).collect(Collectors.toList());
		}

		// Map filtered businesses to response objects
		List<ViewBusinessResponse> businessResponses = businesses.stream().map(this::mapBusinessToResponse).collect(Collectors.toList());

		// Create and return response object
		ViewMultipleBusinessResponse response = new ViewMultipleBusinessResponse();
		response.setBusinesses(businessResponses);
		return response;
	}

	private ViewBusinessResponse mapBusinessToResponse(Business business) {
		return ViewBusinessResponse.builder().name(business.getName()).addedOn(business.getAddOn()).address(business.getAddress())
				.basicDetail(business.getBasicDetails()).address(business.getAddress()).subtitle(business.getSubtitle()).cultureId(business.getCultureId())
				.contactMethod(business.getContactMethod()).phoneNumber(business.getPhoneNumber()).email(business.getEmailId()).latitude(business.getLatitude())
				.longitude(business.getLongitude()).city(business.getCity()).country(business.getCountry()).priceRange(business.getPriceRange())
				.status(business.getStatus()).build();
	}

	public long countBusinesses() {
		return businessRepository.count();
	}

	public ViewMultipleBusinessResponse getBusinessesByFilter(GetBusinessesByForeignIdRequest request) {
		// Fetch all businesses from the repository
		List<Business> businesses = businessRepository.findAll();

		// Apply filters based on request parameters

		if (request.getCategoryID() != null) {
			businesses = businesses.stream().filter(business -> request.getCategoryID().equals(business.getCategoryId())).collect(Collectors.toList());
		}

		if (request.getCultureID() != null) {
			businesses = businesses.stream().filter(business -> request.getCultureID().equals(business.getCultureId())).collect(Collectors.toList());
		}

		if (request.getOwnerId() != null) {
			businesses = businesses.stream().filter(business -> request.getOwnerId().equals(business.getOwnerId())).collect(Collectors.toList());
		}

		// Map filtered businesses to response objects
		List<ViewBusinessResponse> businessResponses = businesses.stream().map(this::mapBusinessToResponse).collect(Collectors.toList());

		// Create and return response object
		ViewMultipleBusinessResponse response = new ViewMultipleBusinessResponse();
		response.setBusinesses(businessResponses);
		return response;
	}
}
