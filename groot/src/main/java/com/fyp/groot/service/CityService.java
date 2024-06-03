package com.fyp.groot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.City;
import com.fyp.groot.repository.CityRepository;

/**
 * CityService handles the business logic for city-related operations.
 */
@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    /**
     * Adds a new city.
     * 
     * @param city the city to add
     * @return the added city
     */
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    /**
     * Retrieves all cities.
     * 
     * @return a list of all cities
     */
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    /**
     * Deletes a city by its ID.
     * 
     * @param cityId the ID of the city to delete
     */
    public void deleteCity(Long cityId) {
        cityRepository.deleteById(cityId);
    }

    /**
     * Retrieves a city by its ID.
     * 
     * @param id the ID of the city to retrieve
     * @return an Optional containing the city if found, otherwise empty
     */
    public Optional<City> getCityByCityId(Long id) {
        return cityRepository.findById(id);
    }

    /**
     * Updates an existing city.
     * 
     * @param city the city details to update
     * @param cityId the ID of the city to update
     * @return the updated city
     */
    public City updateCity(City city, Long cityId) {
        City existingCity = cityRepository.findById(cityId).orElseThrow();
        return cityRepository.save(existingCity);
    }

    /**
     * Counts the total number of cities.
     * 
     * @return the total number of cities
     */
    public long countCities() {
        return cityRepository.count();
    }
}
