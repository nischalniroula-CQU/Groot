package com.fyp.groot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fyp.groot.entity.Event;
import com.fyp.groot.entity.Product;
import com.fyp.groot.model.GetAllEventResponse;
import com.fyp.groot.model.GetAllProductsRequest;
import com.fyp.groot.model.GetAllProductsResponse;
import com.fyp.groot.model.ViewMultipleBusinessRequest;
import com.fyp.groot.model.ViewMultipleBusinessResponse;
import com.fyp.groot.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
//	@PostMapping("/getall")
//	public ResponseEntity<GetAllProductsResponse> getAllProducts(
//			@RequestBody GetAllProductsRequest request) {
//		List<Product> product = productService.getAllProducts(request);
//		GetAllProductsResponse response = productService.getAllProducts();
//		return new ResponseEntity<>(response, HttpStatus.OK);
//	}

	@PostMapping("/getall")
	public ResponseEntity<GetAllProductsResponse> getAllProducts(@RequestBody GetAllProductsRequest request) {
		List<Product> product = productService.getAllProducts(request);
		GetAllProductsResponse response = new GetAllProductsResponse();
        response.setProduct(product);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
