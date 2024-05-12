package com.fyp.groot.service;

import com.fyp.groot.entity.Product;
import com.fyp.groot.model.GetAllProductsRequest;
import com.fyp.groot.model.GetAllProductsResponse;
import com.fyp.groot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProducts(GetAllProductsRequest request) {
		// Fetch all businesses from the repository
		List<Product> products = productRepository.findAll();

		if (request.getProductTitle() != null) {
			products = products.stream().filter(product -> request.getProductTitle().equalsIgnoreCase(product.getProductTitle())).collect(Collectors.toList());
		}

		return products;
	}

	private GetAllProductsResponse mapProductToResponse(Product product) {
		return null;
	}

}
