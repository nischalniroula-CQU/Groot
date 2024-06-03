package com.fyp.groot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fyp.groot.entity.Product;
import com.fyp.groot.model.AddProductRequest;
import com.fyp.groot.model.AddProductResponse;
import com.fyp.groot.model.GetAllProductsRequest;
import com.fyp.groot.model.GetAllProductsResponse;
import com.fyp.groot.model.GetProductsByForeignIdRequest;
import com.fyp.groot.service.ProductService;

/**
 * ProductController handles HTTP requests for product-related operations.
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Handles POST requests to get all products.
     * 
     * @param request the request body containing criteria to view multiple products
     * @return a ResponseEntity containing the response with the list of products
     */
    @PostMapping("/getAll")
    public ResponseEntity<GetAllProductsResponse> getAllProducts(@RequestBody GetAllProductsRequest request) {
        List<Product> products = productService.getAllProducts(request);
        GetAllProductsResponse response = new GetAllProductsResponse();
        response.setProducts(products);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles GET requests to get a product by its ID.
     * 
     * @param productId the ID of the product to retrieve
     * @return a ResponseEntity containing the product details
     */
    @GetMapping("/getbyid")
    public ResponseEntity<Product> getProduct(@RequestParam Long productId) {
        Product response = productService.getProduct(productId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles PUT requests to update a product.
     * 
     * @param productId the ID of the product to update
     * @param request the request body containing the updated product details
     * @return a ResponseEntity containing the updated product
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<AddProductResponse> updateProduct(@PathVariable("id") Long productId,
            @RequestBody AddProductRequest request) {
        AddProductResponse response = productService.updateProduct(request, productId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles DELETE requests to delete a product by its ID.
     * 
     * @param productId the ID of the product to delete
     * @return a ResponseEntity with HTTP status OK
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Handles POST requests to add a new product.
     * 
     * @param request the request body containing the new product details
     * @return a ResponseEntity containing the added product
     */
    @PostMapping("/add")
    public ResponseEntity<AddProductResponse> addProduct(@RequestBody AddProductRequest request) {
        AddProductResponse response = new AddProductResponse();
        response.setProduct(productService.addProduct(request));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Handles POST requests to get products by filter criteria.
     * 
     * @param request the request body containing filter criteria
     * @return a ResponseEntity containing the response with the filtered products
     */
    @PostMapping("/getbyfilter")
    public ResponseEntity<GetAllProductsResponse> getProductsByForeignId(
            @RequestBody GetProductsByForeignIdRequest request) {
        GetAllProductsResponse response = productService.getProductsByForeignId(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
