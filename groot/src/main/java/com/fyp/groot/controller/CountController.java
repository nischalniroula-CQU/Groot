package com.fyp.groot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.fyp.groot.service.*;

/**
 * CountController handles HTTP requests for counting various entities in the system.
 */
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

    @Autowired
    private UserService userService;

    @Autowired
    private InterestService interestService;

    @Autowired
    private TagService tagService;

    @Autowired
    private ProductService productService;

    /**
     * Handles GET requests to get the count of a specified entity type.
     *
     * @param entityType the type of entity to count
     * @return a ResponseEntity containing the count of the specified entity type
     */
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
            case "users":
                return ResponseEntity.ok(userService.countUsers());
            case "interests":
                return ResponseEntity.ok(interestService.countInterests());
            case "tags":
                return ResponseEntity.ok(tagService.countTags());
            case "product":
                return ResponseEntity.ok(productService.countProducts());
            default:
                throw new IllegalArgumentException("Invalid entity type"); 
        }
    }

    /**
     * Handles GET requests to get the count of businesses by user ID.
     *
     * @param entityType the type of entity to count
     * @param userId the user ID to filter by
     * @return a ResponseEntity containing the count of businesses for the specified user
     */
    @GetMapping("/allCountsByUID")
    public ResponseEntity<Long> getCountByUid(@RequestParam String entityType, @RequestParam Long userId) {
        switch (entityType) {
            case "business":
                return ResponseEntity.ok(businessService.countBusinessesByUid(userId));
            default:
                throw new IllegalArgumentException("Invalid entity type");
        }
    }

    /**
     * Handles GET requests to get the count of events or products by business IDs.
     *
     * @param entityType the type of entity to count
     * @param businessIds the business IDs to filter by, as a comma-separated string
     * @return a ResponseEntity containing the count of events or products for the specified business IDs
     */
    @GetMapping("/allCountsByBID")
    public ResponseEntity<Long> getCountByBid(@RequestParam String entityType, @RequestParam String businessIds) {
        // Clean and parse the business IDs
        String cleanedBusinessIds = businessIds.replaceAll("[\\[\\]]", "");
        List<Long> businessIdList = Stream.of(cleanedBusinessIds.split(","))
                                          .map(String::trim) // trim whitespace
                                          .map(Long::parseLong)
                                          .collect(Collectors.toList());
        switch (entityType) {
            case "events":
                return ResponseEntity.ok(eventService.countEventsByBid(businessIdList));
            case "products":
                return ResponseEntity.ok(productService.countProductsByBid(businessIdList));
            default:
                throw new IllegalArgumentException("Invalid entity type");
        }
    }

}
