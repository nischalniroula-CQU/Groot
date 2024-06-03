package com.fyp.groot.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

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

import com.fyp.groot.entity.City;
import com.fyp.groot.model.GetAllCitiesResponse;
import com.fyp.groot.service.CityService;

/**
 * CityController handles HTTP requests for city-related operations.
 */
@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * Handles GET requests to get all cities.
     * 
     * @return a ResponseEntity containing the response with the list of all cities
     */
    @GetMapping("/getAll")
    public ResponseEntity<GetAllCitiesResponse> getAllCities() {
        List<City> cities = cityService.getAllCities();
        GetAllCitiesResponse response = new GetAllCitiesResponse();
        response.setCities(cities);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles GET requests to get a city by its ID.
     * 
     * @param id the ID of the city to retrieve
     * @return a ResponseEntity containing the city if found, or NOT_FOUND status if not found
     * @throws InterruptedException if the operation is interrupted
     * @throws ExecutionException if an execution error occurs
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) throws InterruptedException, ExecutionException {
        Optional<City> city = cityService.getCityByCityId(id);
        if (city.isPresent()) {
            return new ResponseEntity<>(city.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Handles POST requests to add a new city.
     * 
     * @param city the request body containing the new city details
     * @return a ResponseEntity containing the added city
     */
    @PostMapping("/add")
    public ResponseEntity<City> addCity(@RequestBody City city) {
        City addedCity = cityService.addCity(city);
        return new ResponseEntity<>(addedCity, HttpStatus.CREATED);
    }

    /**
     * Handles DELETE requests to delete a city by its ID.
     * 
     * @param cityId the ID of the city to delete
     * @return a ResponseEntity with HTTP status OK
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable("id") Long cityId) {
        cityService.deleteCity(cityId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Handles PUT requests to update a city.
     * 
     * @param cityId the ID of the city to update
     * @param city the request body containing the updated city details
     * @return a ResponseEntity containing the updated city
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<City> updateCity(@PathVariable("id") Long cityId, @RequestBody City city) {
        City updatedCity = cityService.updateCity(city, cityId);
        return new ResponseEntity<>(updatedCity, HttpStatus.OK);
    }
}
