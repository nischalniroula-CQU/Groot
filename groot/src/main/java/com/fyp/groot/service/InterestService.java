package com.fyp.groot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.InterestLibrary;
import com.fyp.groot.repository.InterestRepository;

/**
 * InterestService handles the business logic for interest-related operations.
 */
@Service
public class InterestService {

    @Autowired
    private InterestRepository interestRepository;

    /**
     * Adds a new interest.
     * 
     * @param interest the interest to add
     * @return the added interest
     */
    public InterestLibrary addInterest(InterestLibrary interest) {
        // Add business logic as required (validation, etc.)
        return interestRepository.save(interest);
    }

    /**
     * Retrieves all interests.
     * 
     * @return a list of all interests
     */
    public List<InterestLibrary> getAllInterests() {
        return interestRepository.findAll();
    }

    /**
     * Updates an existing interest.
     * 
     * @param interest the interest details to update
     * @param interestId the ID of the interest to update
     * @return the updated interest
     */
    public InterestLibrary updateInterest(InterestLibrary interest, Long interestId) {
        InterestLibrary existingInterest = interestRepository.findById(interestId).orElseThrow();
        return interestRepository.save(existingInterest);
    }

    /**
     * Deletes an interest by its ID.
     * 
     * @param interestId the ID of the interest to delete
     */
    public void deleteInterest(Long interestId) {
        interestRepository.deleteById(interestId);
    }

    /**
     * Counts the total number of interests.
     * 
     * @return the total number of interests
     */
    public long countInterests() {
        return interestRepository.count();
    }
}
