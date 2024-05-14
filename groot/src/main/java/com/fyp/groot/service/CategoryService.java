package com.fyp.groot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.Business;
import com.fyp.groot.entity.Category;
import com.fyp.groot.model.AddBusinessRequest;
import com.fyp.groot.model.AddBusinessResponse;
import com.fyp.groot.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
    private CategoryRepository categoryRepository;

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
    public void deleteCategory(Long categoryId) {
    	categoryRepository.deleteById(categoryId);
	}
    
    public Category updateCategory(Category category, Long categoryId) {
		//AddBusinessResponse response = new AddBusinessResponse();

    	Category existingCategory = categoryRepository.findById(categoryId).orElseThrow();
    	//existingCategory = mapRequestToBusiness(request, existingBusiness);

    	//Category updatedCategory = categoryRepository.save(existingCategory);
		//response.setBusiness(updatedBusiness);
		return categoryRepository.save(existingCategory);
	}
    
    
    public long countCategories() {
        return categoryRepository.count();
    }

}
