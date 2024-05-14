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
import com.fyp.groot.model.AddBusinessRequest;
import com.fyp.groot.model.AddBusinessResponse;
import com.fyp.groot.model.ViewCategoryResponse;
import com.fyp.groot.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
    private CategoryService categoryService;
	
	
	@GetMapping("/getAll")
    public ResponseEntity<ViewCategoryResponse> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        ViewCategoryResponse response = new ViewCategoryResponse();
        response.setCategories(categories);
        return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	@PostMapping("/addCategory")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category addedCategory = categoryService.addCategory(category);
        return new ResponseEntity<>(addedCategory, HttpStatus.CREATED);
    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long categoryId) {
		categoryService.deleteCategory(categoryId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable("id") Long categoryId, @RequestBody Category category) {
		Category updatedcategory = categoryService.updateCategory(category, categoryId);
		return new ResponseEntity<>(updatedcategory, HttpStatus.OK);
	}

}
