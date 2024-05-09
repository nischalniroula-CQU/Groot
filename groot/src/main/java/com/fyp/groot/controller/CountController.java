package com.fyp.groot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fyp.groot.service.BusinessService;
import com.fyp.groot.service.CategoryService;

@RestController
@RequestMapping("/api/count")
public class CountController {
	
	@Autowired
    private BusinessService businessService;

    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/allCounts")
    public ResponseEntity<Long> getCount(@RequestParam String entityType) {
        switch (entityType) {
            case "business":
                return ResponseEntity.ok(businessService.countBusinesses());
            case "category":
                return ResponseEntity.ok(categoryService.countCategories());
            // ... cases for other entities ...
            default:
                throw new IllegalArgumentException("Invalid entity type"); 
        }
    }

}
