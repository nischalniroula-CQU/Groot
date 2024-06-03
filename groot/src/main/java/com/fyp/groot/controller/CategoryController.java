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
import org.springframework.web.bind.annotation.RestController;

import com.fyp.groot.entity.Category;
import com.fyp.groot.model.ViewCategoryResponse;
import com.fyp.groot.service.CategoryService;

/**
 * CategoryController handles HTTP requests for category-related operations.
 */
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * Handles GET requests to get all categories.
     * 
     * @return a ResponseEntity containing the response with the list of all categories
     */
    @GetMapping("/getAll")
    public ResponseEntity<ViewCategoryResponse> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        ViewCategoryResponse response = new ViewCategoryResponse();
        response.setCategories(categories);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles GET requests to get a category by its ID.
     * 
     * @param id the ID of the category to retrieve
     * @return a ResponseEntity containing the category if found, or NOT_FOUND status if not found
     */
    @GetMapping("/getByID/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Handles POST requests to add a new category.
     * 
     * @param category the request body containing the new category details
     * @return a ResponseEntity containing the added category
     */
    @PostMapping("/addCategory")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category addedCategory = categoryService.addCategory(category);
        return new ResponseEntity<>(addedCategory, HttpStatus.CREATED);
    }

    /**
     * Handles DELETE requests to delete a category by its ID.
     * 
     * @param categoryId the ID of the category to delete
     * @return a ResponseEntity with HTTP status OK
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Handles PUT requests to update a category.
     * 
     * @param categoryId the ID of the category to update
     * @param category the request body containing the updated category details
     * @return a ResponseEntity containing the updated category
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long categoryId, @RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategory(category, categoryId);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

}
