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

/**
 * BusinessService handles the business logic for business-related operations.
 */
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

    /**
     * Maps AddBusinessRequest to Business entity for creating a new business.
     * 
     * @param request the AddBusinessRequest object containing business details
     * @param business the Business entity to map to
     * @return the mapped Business entity
     */
    private Business mapRequestToBusiness(AddBusinessRequest request, Business business) {
        business = Business.builder()
                .businessId(request.getBusinessId())
                .name(request.getName())
                .subtitle(request.getSubtitle())
                .basicDetails(request.getBasicDetails())
                .contactMethod(request.getContactMethod())
                .phoneNumber(request.getPhoneNumber())
                .emailId(request.getEmailId())
                .location(request.getLocation())
                .address(request.getAddress())
                .city(request.getCity())
                .country(request.getCountry())
                .priceRange(request.getPriceRange())
                .status(request.getStatus())
                .addOn(request.getAddOn())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .categoryId(request.getCategoryId())
                .cultureId(request.getCultureId())
                .ownerId(request.getOwnerId())
                .build();
        return business;
    }

    /**
     * Maps AddBusinessRequest to existing Business entity for updating business details.
     * 
     * @param request the AddBusinessRequest object containing business details
     * @param business the existing Business entity to update
     * @return the updated Business entity
     */
    private Business mapRequestToBusinessForUpdate(AddBusinessRequest request, Business business) {
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
        business.setLatitude(request.getLatitude());
        business.setLongitude(request.getLongitude());
        business.setCategoryId(request.getCategoryId());
        business.setCultureId(request.getCultureId());
        business.setOwnerId(request.getOwnerId());
        return business;
    }

    /**
     * Retrieves business details by business ID.
     * 
     * @param businessId the ID of the business
     * @return a ViewBusinessResponse containing business details
     */
    public ViewBusinessResponse viewBusiness(Long businessId) {
        Business business = businessRepository.findById(businessId)
                .orElseThrow(() -> new RuntimeException("Business not found with ID: " + businessId));
        return mapBusinessToResponse(business);
    }

    /**
     * Updates business details.
     * 
     * @param request the AddBusinessRequest object containing updated business details
     * @param businessId the ID of the business to update
     * @return an AddBusinessResponse containing the updated business details
     */
    public AddBusinessResponse updateBusiness(AddBusinessRequest request, Long businessId) {
        AddBusinessResponse response = new AddBusinessResponse();

        Business existingBusiness = businessRepository.findById(businessId).orElseThrow();
        existingBusiness = mapRequestToBusinessForUpdate(request, existingBusiness);

        Business updatedBusiness = businessRepository.save(existingBusiness);
        
        // Update business timing if provided
        if (request.getBusinessTiming() != null) {
            BusinessTiming existingBusinessTiming = businessTimingRepository.findByBusinessId(businessId);
            if (existingBusinessTiming != null) {
                existingBusinessTiming.setMonday(request.getBusinessTiming().getMonday());
                existingBusinessTiming.setTuesday(request.getBusinessTiming().getTuesday());
                existingBusinessTiming.setWednesday(request.getBusinessTiming().getWednesday());
                existingBusinessTiming.setThursday(request.getBusinessTiming().getThursday());
                existingBusinessTiming.setFriday(request.getBusinessTiming().getFriday());
                existingBusinessTiming.setSaturday(request.getBusinessTiming().getSaturday());
                existingBusinessTiming.setSunday(request.getBusinessTiming().getSunday());
                businessTimingRepository.save(existingBusinessTiming);
            } else {
                request.getBusinessTiming().setBusinessId(businessId);
                businessTimingRepository.save(request.getBusinessTiming());
            }
        }

        // Update images if provided
        if (request.getImages() != null && !request.getImages().isEmpty()) {
            List<ImageLibrary> existingImageLibrary = imageLibraryRepository.findByBusinessId(businessId);
            if (existingImageLibrary != null && !existingImageLibrary.isEmpty()) {
                for (ImageLibrary image : request.getImages()) {
                    imageLibraryService.addImage(image);
                }
            }
        }
        
        response.setBusiness(updatedBusiness);
        return response;
    }

    /**
     * Adds a new business.
     * 
     * @param request the AddBusinessRequest object containing new business details
     * @return an AddBusinessResponse containing the added business details
     */
    public AddBusinessResponse addBusiness(AddBusinessRequest request) {
        Business business = mapRequestToBusiness(request, new Business());
        business = businessRepository.save(business);

        // Save the images associated with the business
        if (request.getImages() != null && !request.getImages().isEmpty()) {
            for (ImageLibrary image : request.getImages()) {
                image.setBusinessId(business.getBusinessId()); 
                imageLibraryService.addImage(image);
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

    /**
     * Deletes a business by its ID.
     * 
     * @param businessId the ID of the business to delete
     */
    public void deleteBusiness(Long businessId) {
        businessRepository.deleteById(businessId);
    }

    /**
     * Retrieves multiple businesses based on request parameters.
     * 
     * @param request the ViewMultipleBusinessRequest object containing filter criteria
     * @return a ViewMultipleBusinessResponse containing the list of businesses
     */
    public ViewMultipleBusinessResponse viewMultipleBusinesses(ViewMultipleBusinessRequest request) {
        List<Business> businesses = businessRepository.findAll();

        // Apply filters based on request parameters
        if (request.getCountry() != null) {
            businesses = businesses.stream()
                    .filter(business -> request.getCountry().equalsIgnoreCase(business.getCountry()))
                    .collect(Collectors.toList());
        }

        if (request.getCategoryID() != null) {
            businesses = businesses.stream()
                    .filter(business -> request.getCategoryID().equals(business.getCategoryId()))
                    .collect(Collectors.toList());
        }

        if (request.getName() != null && !request.getName().isEmpty()) {
            String nameFilter = request.getName().toLowerCase();
            businesses = businesses.stream()
                    .filter(business -> business.getName().toLowerCase().contains(nameFilter))
                    .collect(Collectors.toList());
        }

        if (request.getCultureID() != null) {
            businesses = businesses.stream()
                    .filter(business -> request.getCultureID().equals(business.getCultureId()))
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

        ViewMultipleBusinessResponse response = new ViewMultipleBusinessResponse();
        response.setBusinesses(businessResponses);
        return response;
    }

    /**
     * Maps a Business entity to a ViewBusinessResponse object.
     * 
     * @param business the Business entity to map
     * @return a ViewBusinessResponse containing business details
     */
    private ViewBusinessResponse mapBusinessToResponse(Business business) {
        List<ImageLibrary> imagelibrary = imageLibraryRepository.findByBusinessId(business.getBusinessId());
        BusinessTiming businessTiming = businessTimingRepository.findByBusinessId(business.getBusinessId());
        
        return ViewBusinessResponse.builder()
                .businessId(business.getBusinessId())
                .name(business.getName())
                .addedOn(business.getAddOn())
                .address(business.getAddress())
                .basicDetail(business.getBasicDetails())
                .subtitle(business.getSubtitle())
                .categoryId(business.getCategoryId())
                .cultureId(business.getCultureId())
                .ownerId(business.getOwnerId())
                .contactMethod(business.getContactMethod())
                .phoneNumber(business.getPhoneNumber())
                .email(business.getEmailId())
                .latitude(business.getLatitude())
                .longitude(business.getLongitude())
                .city(business.getCity())
                .country(business.getCountry())
                .priceRange(business.getPriceRange())
                .status(business.getStatus())
                .images(imagelibrary)
                .businessTiming(businessTiming)
                .build();
    }

    /**
     * Counts the total number of businesses.
     * 
     * @return the total number of businesses
     */
    public long countBusinesses() {
        return businessRepository.count();
    }
    
    /**
     * Counts the number of businesses by user ID.
     * 
     * @param userId the ID of the user
     * @return the number of businesses owned by the user
     */
    public long countBusinessesByUid(Long userId) {
        return businessRepository.countByUserId(userId);
    }

    /**
     * Retrieves businesses by filter criteria.
     * 
     * @param request the GetBusinessesByForeignIdRequest object containing filter criteria
     * @return a ViewMultipleBusinessResponse containing the list of businesses
     */
    public ViewMultipleBusinessResponse getBusinessesByFilter(GetBusinessesByForeignIdRequest request) {
        List<Business> businesses = businessRepository.findAll();

        // Apply filters based on request parameters
        if (request.getCategoryID() != null) {
            businesses = businesses.stream()
                    .filter(business -> request.getCategoryID().equals(business.getCategoryId()))
                    .collect(Collectors.toList());
        }

        if (request.getCultureID() != null) {
            businesses = businesses.stream()
                    .filter(business -> request.getCultureID().equals(business.getCultureId()))
                    .collect(Collectors.toList());
        }

        if (request.getOwnerId() != null) {
            businesses = businesses.stream()
                    .filter(business -> request.getOwnerId().equals(business.getOwnerId()))
                    .collect(Collectors.toList());
        }

        // Map filtered businesses to response objects
        List<ViewBusinessResponse> businessResponses = businesses.stream()
                .map(this::mapBusinessToResponse)
                .collect(Collectors.toList());

        ViewMultipleBusinessResponse response = new ViewMultipleBusinessResponse();
        response.setBusinesses(businessResponses);
        return response;
    }
}
