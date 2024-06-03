package com.fyp.groot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.Country;
import com.fyp.groot.repository.CountryRepository;

/**
 * CountryService handles the business logic for country-related operations.
 */
@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    /**
     * Adds a new country.
     * 
     * @param country the country to add
     * @return the added country
     */
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    /**
     * Retrieves all countries.
     * 
     * @return a list of all countries
     */
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    /**
     * Deletes a country by its ID.
     * 
     * @param countryId the ID of the country to delete
     */
    public void deleteCountry(Long countryId) {
        countryRepository.deleteById(countryId);
    }

    /**
     * Updates an existing country.
     * 
     * @param country the country details to update
     * @param countryId the ID of the country to update
     * @return the updated country
     */
    public Country updateCountry(Country country, Long countryId) {
        Country existingCountry = countryRepository.findById(countryId).orElseThrow();
        return countryRepository.save(existingCountry);
    }

    /**
     * Counts the total number of countries.
     * 
     * @return the total number of countries
     */
    public long countCountries() {
        return countryRepository.count();
    }
}
