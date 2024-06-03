package com.fyp.groot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.Category;
import com.fyp.groot.repository.CategoryRepository;

/**
 * CategoryService handles the business logic for category-related operations.
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Adds a new category.
     * 
     * @param category the category to add
     * @return the added category
     */
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    /**
     * Retrieves all categories.
     * 
     * @return a list of all categories
     */
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    /**
     * Retrieves a category by its ID.
     * 
     * @param id the ID of the category to retrieve
     * @return the category if found, otherwise null
     */
    public Category getCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    /**
     * Deletes a category by its ID.
     * 
     * @param categoryId the ID of the category to delete
     */
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    /**
     * Updates an existing category.
     * 
     * @param category the category details to update
     * @param categoryId the ID of the category to update
     * @return the updated category
     */
    public Category updateCategory(Category category, Long categoryId) {
        Category existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId));
        existingCategory.setCategoryName(category.getCategoryName());
        return categoryRepository.save(existingCategory);
    }

    /**
     * Counts the total number of categories.
     * 
     * @return the total number of categories
     */
    public long countCategories() {
        return categoryRepository.count();
    }
}
