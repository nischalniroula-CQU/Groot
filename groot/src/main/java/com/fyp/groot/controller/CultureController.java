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

import com.fyp.groot.entity.Culture;
import com.fyp.groot.model.GetAllCulturesResponse;
import com.fyp.groot.service.CultureService;

/**
 * CultureController handles HTTP requests for culture-related operations.
 */
@RestController
@RequestMapping("/api/cultures")
public class CultureController {

    @Autowired
    private CultureService cultureService;

    /**
     * Handles GET requests to get all cultures.
     * 
     * @return a ResponseEntity containing the response with the list of all cultures
     */
    @GetMapping("/getAll")
    public ResponseEntity<GetAllCulturesResponse> getAllCultures() {
        List<Culture> cultures = cultureService.getAllCultures();
        GetAllCulturesResponse response = new GetAllCulturesResponse();
        response.setCultures(cultures);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles GET requests to get a culture by its ID.
     * 
     * @param id the ID of the culture to retrieve
     * @return a ResponseEntity containing the culture if found, or NOT_FOUND status if not found
     */
    @GetMapping("/getByID/{id}")
    public ResponseEntity<Culture> getCultureById(@PathVariable Long id) {
        Culture culture = cultureService.getCultureById(id);
        if (culture != null) {
            return new ResponseEntity<>(culture, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Handles POST requests to add a new culture.
     * 
     * @param culture the request body containing the new culture details
     * @return a ResponseEntity containing the added culture
     */
    @PostMapping("/add")
    public ResponseEntity<Culture> addCulture(@RequestBody Culture culture) {
        Culture addedCulture = cultureService.addCulture(culture);
        return new ResponseEntity<>(addedCulture, HttpStatus.CREATED);
    }

    /**
     * Handles PUT requests to update a culture.
     * 
     * @param cultureId the ID of the culture to update
     * @param culture the request body containing the updated culture details
     * @return a ResponseEntity containing the updated culture
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Culture> updateCulture(@PathVariable("id") Long cultureId, @RequestBody Culture culture) {
        Culture updatedCulture = cultureService.updateCulture(culture, cultureId);
        return new ResponseEntity<>(updatedCulture, HttpStatus.OK);
    }

    /**
     * Handles DELETE requests to delete a culture by its ID.
     * 
     * @param cultureId the ID of the culture to delete
     * @return a ResponseEntity with HTTP status OK
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCulture(@PathVariable("id") Long cultureId) {
        cultureService.deleteCulture(cultureId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
