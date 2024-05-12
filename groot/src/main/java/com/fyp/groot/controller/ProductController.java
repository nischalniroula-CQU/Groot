package com.fyp.groot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fyp.groot.entity.Product;
import com.fyp.groot.model.AddProductRequest;
import com.fyp.groot.model.AddProductResponse;
import com.fyp.groot.model.GetAllProductsRequest;
import com.fyp.groot.model.GetAllProductsResponse;
import com.fyp.groot.model.GetProductsByForeignIdRequest;
import com.fyp.groot.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/getAll")
	public ResponseEntity<GetAllProductsResponse> getAllProducts(@RequestBody GetAllProductsRequest request) {
		List<Product> products = productService.getAllProducts(request);
		GetAllProductsResponse response = new GetAllProductsResponse();
		response.setProducts(products);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/getbyid")
	public ResponseEntity<Product> getProduct(@RequestParam Long productId) {
		Product response = productService.getProduct(productId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<AddProductResponse> updateProduct(@PathVariable("id") Long productId,
			@RequestBody AddProductRequest request) {
		AddProductResponse response = productService.updateProduct(request, productId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<AddProductResponse> addProduct(@RequestBody AddProductRequest request) {
		AddProductResponse response = new AddProductResponse();
		response.setProduct(productService.addProduct(request));
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PostMapping("/getbyfilter")
	public ResponseEntity<GetAllProductsResponse> getProductsByForeignId(
			@RequestBody GetProductsByForeignIdRequest request) {
		GetAllProductsResponse response = productService.getProductsByForeignId(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
