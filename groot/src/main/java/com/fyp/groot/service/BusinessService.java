package com.fyp.groot.service;

import com.fyp.groot.entity.Business;
import com.fyp.groot.entity.BusinessTiming;
import com.fyp.groot.entity.ImageLibrary;
import com.fyp.groot.model.GetBusinessesByForeignIdRequest;
import com.fyp.groot.model.ViewBusinessResponse;
import com.fyp.groot.model.ViewMultipleBusinessRequest;
import com.fyp.groot.model.ViewMultipleBusinessResponse;
import com.fyp.groot.model.AddBusinessRequest;
import com.fyp.groot.model.AddBusinessResponse;
import com.fyp.groot.repository.BusinessRepository;
import com.fyp.groot.repository.BusinessTimingRepository;
import com.fyp.groot.repository.ImageLibraryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessService {

	@Autowired
	private BusinessRepository businessRepository;
	
	@Autowired
    private ImageLibraryService imageLibraryService; 

    @Autowired
    private BusinessTimingRepository businessTimingRepository;
    
    @Autowired
    private ImageLibraryRepository imageLibraryRepository;

	private Business mapRequestToBusiness(AddBusinessRequest request, Business business) {

		business = Business.builder().name(request.getName()).subtitle(request.getSubtitle()).basicDetails(request.getBasicDetails())
				.contactMethod(request.getContactMethod()).phoneNumber(request.getPhoneNumber()).emailId(request.getEmailId()).location(request.getLocation())
				.address(request.getAddress()).city(request.getCity()).country(request.getCountry()).priceRange(request.getPriceRange())
				.status(request.getStatus()).addOn(LocalDateTime.now()).latitude(request.getLatitude()).longitude(request.getLongitude())
				.categoryId(request.getCategoryId()).cultureId(request.getCultureId()).ownerId(request.getOwnerId()).build();

		return business;
	}
	
	 private Business mapRequestToBusinessForUpdate(AddBusinessRequest request, Business business) {
	        // Update existing properties, don't create a new Business object
	        business.setName(request.getName());
	        business.setSubtitle(request.getSubtitle());
	        business.setBasicDetails(request.getBasicDetails());
	        business.setContactMethod(request.getContactMethod());
	        business.setPhoneNumber(request.getPhoneNumber());
	        business.setEmailId(request.getEmailId());
	        business.setLocation(request.getLocation());
	        business.setAddress(request.getAddress());
	        business.setCity(request.getCity());
	        business.setCountry(request.getCountry());
	        business.setPriceRange(request.getPriceRange());
	        business.setStatus(request.getStatus());
	        business.setAddOn(LocalDateTime.now());
	        business.setLatitude(request.getLatitude());
	        business.setLongitude(request.getLongitude());
	        business.setCategoryId(request.getCategoryId());
	        business.setCultureId(request.getCultureId());
	        business.setOwnerId(request.getOwnerId());
	        

	        return business;
	    }
	

	public ViewBusinessResponse viewBusiness(Long businessId) {
		Business business = businessRepository.findById(businessId).orElseThrow(() -> new RuntimeException("Business not found with ID: " + businessId));

		return mapBusinessToResponse(business);
	}

	public AddBusinessResponse updateBusiness(AddBusinessRequest request, Long businessId) {
		AddBusinessResponse response = new AddBusinessResponse();

		Business existingBusiness = businessRepository.findById(businessId).orElseThrow();
		existingBusiness = mapRequestToBusinessForUpdate(request, existingBusiness);

		Business updatedBusiness = businessRepository.save(existingBusiness);
		
		if (request.getBusinessTiming() != null) {
            BusinessTiming existingBusinessTiming = businessTimingRepository.findByBusinessId(businessId);
            if (existingBusinessTiming != null) {
                // Update the existing BusinessTiming entity
                existingBusinessTiming.setMonday(request.getBusinessTiming().getMonday());
                existingBusinessTiming.setTuesday(request.getBusinessTiming().getTuesday());
                existingBusinessTiming.setWednesday(request.getBusinessTiming().getWednesday());
                existingBusinessTiming.setThursday(request.getBusinessTiming().getThursday());
                existingBusinessTiming.setFriday(request.getBusinessTiming().getFriday());
                existingBusinessTiming.setSaturday(request.getBusinessTiming().getSaturday());
                existingBusinessTiming.setSunday(request.getBusinessTiming().getSunday());

                businessTimingRepository.save(existingBusinessTiming);
            } else {
                // Create a new BusinessTiming entity if it doesn't exist
                request.getBusinessTiming().setBusinessId(businessId);
                businessTimingRepository.save(request.getBusinessTiming());
            }
        }
		
		// Update or replace images
	    if (request.getImages() != null) {
	        List<ImageLibrary> existingImageLibrary = imageLibraryRepository.findByBusinessId(businessId);
	        if (existingImageLibrary != null && !existingImageLibrary.isEmpty()) {
	            // Remove existing images
	            imageLibraryRepository.deleteAll(existingImageLibrary);
	        }

	        // Add new images
	        for (ImageLibrary image : request.getImages()) {
	            image.setBusinessId(businessId); // Ensure the image is associated with the business
	            imageLibraryService.addImage(image);
	        }
	    }
		
		response.setBusiness(updatedBusiness);
		return response;
	}

	public AddBusinessResponse addBusiness(AddBusinessRequest request) {
        Business business = mapRequestToBusiness(request, new Business());
        business = businessRepository.save(business);

        // Save the images associated with the business
        if (request.getImages() != null && !request.getImages().isEmpty()) {
            for (ImageLibrary image : request.getImages()) {
                image.setBusinessId(business.getBusinessId()); 
                imageLibraryService.addImage(image); // Pass ImageLibrary directly
            }
        }
        
        // Save the business timing associated with the business
        if (request.getBusinessTiming() != null) {
            request.getBusinessTiming().setBusinessId(business.getBusinessId());
            businessTimingRepository.save(request.getBusinessTiming());
        }

        AddBusinessResponse response = new AddBusinessResponse();
        response.setBusiness(business);
        return response;
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
		
		List<ImageLibrary> imagelibrary=imageLibraryRepository.findByBusinessId(business.getBusinessId());
        BusinessTiming businessTiming = businessTimingRepository.findByBusinessId(business.getBusinessId());
        
        return ViewBusinessResponse.builder().name(business.getName()).addedOn(business.getAddOn()).address(business.getAddress())
				.basicDetail(business.getBasicDetails()).address(business.getAddress()).subtitle(business.getSubtitle()).cultureId(business.getCultureId())
				.contactMethod(business.getContactMethod()).phoneNumber(business.getPhoneNumber()).email(business.getEmailId()).latitude(business.getLatitude())
				.longitude(business.getLongitude()).city(business.getCity()).country(business.getCountry()).priceRange(business.getPriceRange())
				.status(business.getStatus())
				.images(imagelibrary)
				.businessTiming(businessTiming)
				.build();
		
		// Fetch and add imageLibrary and businessTiming details to the response
        //List<ImageLibraryResponse> images = imageLibraryService.getImagesByBusinessId(business.getBusinessId());
        
		 //List<ImageLibrary> imagelibrary=imageLibraryRepository.findByBusinessId(business.getBusinessId());
         //BusinessTiming businessTiming = businessTimingRepository.findByBusinessId(business.getBusinessId());
        //return ViewBusinessResponse.builder()
                //.images(imagelibrary) // Use imagelibrary (List<ImageLibrary>)
                //.businessTiming(businessTiming)
                // ... other fields
                //.build();
        
//        ViewBusinessResponse response = ViewBusinessResponse.builder()
//            .images(images)
//            .businessTiming(businessTiming)
//            .build();

        //return response;
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
