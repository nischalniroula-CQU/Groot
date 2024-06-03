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

import com.fyp.groot.entity.Country;
import com.fyp.groot.model.GetAllCountriesResponse;
import com.fyp.groot.service.CountryService;

/**
 * CountryController handles HTTP requests for country-related operations.
 */
@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    /**
     * Handles GET requests to get all countries.
     * 
     * @return a ResponseEntity containing the response with the list of all countries
     */
    @GetMapping("/getAll")
    public ResponseEntity<GetAllCountriesResponse> getAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        GetAllCountriesResponse response = new GetAllCountriesResponse();
        response.setCountries(countries);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles POST requests to add a new country.
     * 
     * @param country the request body containing the new country details
     * @return a ResponseEntity containing the added country
     */
    @PostMapping("/add")
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {
        Country addedCountry = countryService.addCountry(country);
        return new ResponseEntity<>(addedCountry, HttpStatus.CREATED);
    }

    /**
     * Handles DELETE requests to delete a country by its ID.
     * 
     * @param countryId the ID of the country to delete
     * @return a ResponseEntity with HTTP status OK
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable("id") Long countryId) {
        countryService.deleteCountry(countryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Handles PUT requests to update a country.
     * 
     * @param countryId the ID of the country to update
     * @param country the request body containing the updated country details
     * @return a ResponseEntity containing the updated country
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable("id") Long countryId, @RequestBody Country country) {
        Country updatedCountry = countryService.updateCountry(country, countryId);
        return new ResponseEntity<>(updatedCountry, HttpStatus.OK);
    }

}
