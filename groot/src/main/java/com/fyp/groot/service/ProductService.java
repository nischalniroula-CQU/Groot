package com.fyp.groot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.Business;
import com.fyp.groot.entity.Product;
import com.fyp.groot.model.GetAllProductRequest;
import com.fyp.groot.model.GetAllProductResponse;
import com.fyp.groot.model.ViewBusinessResponse;
import com.fyp.groot.model.ViewMultipleBusinessRequest;
import com.fyp.groot.model.ViewMultipleBusinessResponse;
import com.fyp.groot.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        // Add business logic as required (validation, etc.)
        return productRepository.save(product);
    }
    
    public Optional<Product> getEventById(Long productId) {
        return productRepository.findById(productId);
    }
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public long countProducts() {
        return productRepository.count();
    }
    
    
    public List<GetAllProductResponse> getAllProducts(GetAllProductRequest request) {
		// Fetch all businesses from the repository
		List<Product> product = productRepository.findAll();

		// Apply filters based on request parameters
		if (request.getProductTitle() != null) {
			product = product.stream()
					.filter(e -> request.getProductTitle().equalsIgnoreCase(e.getProductTitle()))
					.collect(Collectors.toList());
		}

		if (request.getPromoId() != null) {
			product = product.stream()
					.filter(e -> request.getPromoId().equals(e.getPromoId()))
					.collect(Collectors.toList());
		}

		if (request.getLinkedId() != null) {
			product = product.stream().filter(e -> request.getLinkedId().equals(e.getLinkedId()))
					.collect(Collectors.toList());
		}

		// Map filtered businesses to response objects
		List<GetAllProductResponse> productResponses = product.stream().map(this::mapProductToResponse)
				.collect(Collectors.toList());

		//Create and return response object
		//GetAllEventResponse response = new GetAllEventResponse();
		//response.setEvent(eventResponses);
		//return response;
		return product.stream()
                .map(this::mapProductToResponse) // Call the correct mapping method
                .collect(Collectors.toList());
	}

	private GetAllProductResponse mapProductToResponse(Product product) {
		return GetAllProductResponse.builder()
				.product(getAllProducts())
//				.name(business.getName())
//				.addedOn(business.getAddOn())
//				.address(business.getAddress())
//				.basicDetail(business.getBasicDetails())
//				.address(business.getAddress())
//				.subtitle(business.getSubtitle())
//				.cultureId(business.getCultureId())
//				.contactMethod(business.getContactMethod())
//				.phoneNumber(business.getPhoneNumber())
//				.email(business.getEmailId())
//				.latitude(business.getLatitude())
//				.longitude(business.getLongitude())
//				.city(business.getCity())
//				.country(business.getCountry())
//				.priceRange(business.getPriceRange())
//				.status(business.getStatus())
				.build();
	}

}
