package com.fyp.groot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.Culture;
import com.fyp.groot.repository.CultureRepository;

/**
 * CultureService handles the business logic for culture-related operations.
 */
@Service
public class CultureService {

    @Autowired
    private CultureRepository cultureRepository;

    /**
     * Adds a new culture.
     * 
     * @param culture the culture to add
     * @return the added culture
     */
    public Culture addCulture(Culture culture) {
        // Add business logic as required (validation, etc.)
        return cultureRepository.save(culture);
    }

    /**
     * Retrieves all cultures.
     * 
     * @return a list of all cultures
     */
    public List<Culture> getAllCultures() {
        return cultureRepository.findAll();
    }

    /**
     * Retrieves a culture by its ID.
     * 
     * @param id the ID of the culture to retrieve
     * @return the culture if found, otherwise null
     */
    public Culture getCultureById(Long id) {
        Optional<Culture> culture = cultureRepository.findById(id);
        return culture.orElse(null);
    }

    /**
     * Updates an existing culture.
     * 
     * @param culture the culture details to update
     * @param cultureId the ID of the culture to update
     * @return the updated culture
     */
    public Culture updateCulture(Culture culture, Long cultureId) {
        Culture existingCulture = cultureRepository.findById(cultureId).orElseThrow();
        existingCulture.setCultureName(culture.getCultureName());
        return cultureRepository.save(existingCulture);
    }

    /**
     * Deletes a culture by its ID.
     * 
     * @param cultureId the ID of the culture to delete
     */
    public void deleteCulture(Long cultureId) {
        cultureRepository.deleteById(cultureId);
    }

    /**
     * Counts the total number of cultures.
     * 
     * @return the total number of cultures
     */
    public long countCultures() {
        return cultureRepository.count();
    }
}
