package com.fyp.groot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.Business;
import com.fyp.groot.entity.BusinessTiming;
import com.fyp.groot.entity.ImageLibrary;
import com.fyp.groot.entity.Product;
import com.fyp.groot.model.AddProductRequest;
import com.fyp.groot.model.AddProductResponse;
import com.fyp.groot.model.GetAllProductsRequest;
import com.fyp.groot.model.GetAllProductsResponse;
import com.fyp.groot.model.GetProductsByForeignIdRequest;
import com.fyp.groot.model.ViewBusinessResponse;
import com.fyp.groot.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	private Product mapRequestToProduct(AddProductRequest request, Product product) {

		product = Product.builder().linkedId(request.getLinkedId()).price(request.getPrice())
				.productDescription(request.getProductDescription()).productTitle(request.getProductTitle())
				.status(request.getStatus()).build();
		return product;
	}

	public List<Product> getAllProducts(GetAllProductsRequest request) {
		// Fetch all businesses from the repository
		List<Product> products = productRepository.findAll();

		if (request.getProductTitle() != null) {
			products = products.stream()
					.filter(product -> request.getProductTitle().equalsIgnoreCase(product.getProductTitle()))
					.collect(Collectors.toList());
		}

		return products;
	}

	public Product getProduct(Long productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new RuntimeException("Business not found with ID: " + productId));

		return product;
	}

	public AddProductResponse updateProduct(AddProductRequest request, Long productId) {
		AddProductResponse response = new AddProductResponse();

		Product existingProduct = productRepository.findById(productId).orElseThrow();
		existingProduct = mapRequestToProduct(request, existingProduct);

		Product updatedProduct = productRepository.save(existingProduct);
		response.setProduct(updatedProduct);
		return response;
	}

	public Product addProduct(AddProductRequest request) {
		// Add business logic here (validation, etc.)
		Product product = mapRequestToProduct(request, new Product());
		return productRepository.save(product);
	}

	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);
	}

	public GetAllProductsResponse getProductsByForeignId(GetProductsByForeignIdRequest request) {
		// Fetch all businesses from the repository
		List<Product> products = productRepository.findAll();
		//List<Product> products = productRepository.findByBusinessId(request);

		// Apply filters based on request parameters

		if (request.getLinkedId() != null) {
			products = products.stream().filter(product -> request.getLinkedId().equals(product.getLinkedId()))
					.collect(Collectors.toList());
		}
		
		if (request.getProductTitle() != null) {
			products = products.stream().filter(product -> request.getProductTitle().equalsIgnoreCase(product.getProductTitle())).collect(Collectors.toList());
		}
		
		//List<GetAllProductsResponse> productsResponse = products.stream().map(this::mapProductToResponse).collect(Collectors.toList());

//		List<GetAllProductsResponse> productsResponse = products.stream()
//			    .map(product -> {
//			        GetAllProductsResponse response = new GetAllProductsResponse();
//			        response.setPromoId(product.getPromoId());
//			        response.setLinkedId(product.getLinkedId());
//			        response.setProductTitle(product.getProductTitle());
//			        response.setProductDescription(product.getProductDescription());
//			        response.setPrice(product.getPrice());
//			        response.setStatus(product.getStatus());
//			        return response;
//			    })
//			    .collect(Collectors.toList());

		// Create and return response object
		GetAllProductsResponse response = new GetAllProductsResponse();
		response.setProducts(products);
		return response;
	}
	
	
	

}