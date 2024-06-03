package com.fyp.groot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.Product;
import com.fyp.groot.model.AddProductRequest;
import com.fyp.groot.model.AddProductResponse;
import com.fyp.groot.model.GetAllProductsRequest;
import com.fyp.groot.model.GetAllProductsResponse;
import com.fyp.groot.model.GetProductsByForeignIdRequest;
import com.fyp.groot.repository.ProductRepository;

/**
 * ProductService handles the business logic for product-related operations.
 */
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    /**
     * Maps AddProductRequest to Product entity for creating or updating a product.
     * 
     * @param request the AddProductRequest object containing product details
     * @param product the Product entity to map to
     * @return the mapped Product entity
     */
    private Product mapRequestToProduct(AddProductRequest request, Product product) {
        product = Product.builder()
                .linkedId(request.getLinkedId())
                .price(request.getPrice())
                .productDescription(request.getProductDescription())
                .productTitle(request.getProductTitle())
                .status(request.getStatus())
                .build();
        return product;
    }

    /**
     * Retrieves all products based on request parameters.
     * 
     * @param request the GetAllProductsRequest object containing filter criteria
     * @return a list of products matching the filter criteria
     */
    public List<Product> getAllProducts(GetAllProductsRequest request) {
        List<Product> products = productRepository.findAll();

        if (request.getProductTitle() != null) {
            products = products.stream()
                    .filter(product -> request.getProductTitle().equalsIgnoreCase(product.getProductTitle()))
                    .collect(Collectors.toList());
        }

        return products;
    }

    /**
     * Retrieves a product by its ID.
     * 
     * @param productId the ID of the product to retrieve
     * @return the product with the specified ID
     */
    public Product getProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
        return product;
    }

    /**
     * Updates an existing product.
     * 
     * @param request the AddProductRequest object containing updated product details
     * @param productId the ID of the product to update
     * @return an AddProductResponse containing the updated product details
     */
    public AddProductResponse updateProduct(AddProductRequest request, Long productId) {
        AddProductResponse response = new AddProductResponse();

        Product existingProduct = productRepository.findById(productId).orElseThrow();
        existingProduct = mapRequestToProduct(request, existingProduct);

        Product updatedProduct = productRepository.save(existingProduct);
        response.setProduct(updatedProduct);
        return response;
    }

    /**
     * Adds a new product.
     * 
     * @param request the AddProductRequest object containing new product details
     * @return the added product
     */
    public Product addProduct(AddProductRequest request) {
        Product product = mapRequestToProduct(request, new Product());
        return productRepository.save(product);
    }

    /**
     * Deletes a product by its ID.
     * 
     * @param productId the ID of the product to delete
     */
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    /**
     * Retrieves products by foreign ID filter criteria.
     * 
     * @param request the GetProductsByForeignIdRequest object containing filter criteria
     * @return a GetAllProductsResponse containing the list of products
     */
    public GetAllProductsResponse getProductsByForeignId(GetProductsByForeignIdRequest request) {
        List<Product> products = productRepository.findAll();

        if (request.getLinkedId() != null) {
            products = products.stream()
                    .filter(product -> request.getLinkedId().equals(product.getLinkedId()))
                    .collect(Collectors.toList());
        }

        if (request.getProductTitle() != null) {
            products = products.stream()
                    .filter(product -> request.getProductTitle().equalsIgnoreCase(product.getProductTitle()))
                    .collect(Collectors.toList());
        }

        GetAllProductsResponse response = new GetAllProductsResponse();
        response.setProducts(products);
        return response;
    }

    /**
     * Counts the total number of products.
     * 
     * @return the total number of products
     */
    public long countProducts() {
        return productRepository.count();
    }

    /**
     * Counts the number of products by business IDs.
     * 
     * @param businessIds the list of business IDs
     * @return the number of products associated with the specified business IDs
     */
    public long countProductsByBid(List<Long> businessIds) {
        return productRepository.countByBusinessIds(businessIds);
    }
}
