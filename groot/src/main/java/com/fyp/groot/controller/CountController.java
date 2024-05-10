package com.fyp.groot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fyp.groot.service.BusinessService;
import com.fyp.groot.service.CategoryService;
import com.fyp.groot.service.CultureService;
import com.fyp.groot.service.EventService;
import com.fyp.groot.service.UniversityService;

@RestController
@RequestMapping("/api/count")
public class CountController {
	
	@Autowired
    private BusinessService businessService;

    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private CultureService cultureService;
    
    @Autowired
    private EventService eventService;
    
    @Autowired
    private UniversityService universityService;
    
    @GetMapping("/allCounts")
    public ResponseEntity<Long> getCount(@RequestParam String entityType) {
        switch (entityType) {
            case "business":
                return ResponseEntity.ok(businessService.countBusinesses());
            case "category":
                return ResponseEntity.ok(categoryService.countCategories());
            case "culture":
                return ResponseEntity.ok(cultureService.countCultures());
            case "event":
                return ResponseEntity.ok(eventService.countEvents());
            case "university":
                return ResponseEntity.ok(universityService.countUniversities());
            // ... cases for other entities ...
            default:
                throw new IllegalArgumentException("Invalid entity type"); 
        }
    }

}
