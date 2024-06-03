package com.fyp.groot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.University;
import com.fyp.groot.repository.UniversityRepository;

/**
 * UniversityService handles the business logic for university-related operations.
 */
@Service
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    /**
     * Adds a new university.
     * 
     * @param university the university to add
     * @return the added university
     */
    public University addUniversity(University university) {
        // Add business logic as required (validation, etc.)
        return universityRepository.save(university);
    }

    /**
     * Retrieves all universities.
     * 
     * @return a list of all universities
     */
    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }

    /**
     * Counts the total number of universities.
     * 
     * @return the total number of universities
     */
    public long countUniversities() {
        return universityRepository.count();
    }

    /**
     * Retrieves a university by its ID.
     * 
     * @param id the ID of the university to retrieve
     * @return the university with the specified ID
     */
    public University getUniversityById(Long id) {
        return universityRepository.findById(id).orElseThrow();
    }

    /**
     * Updates an existing university.
     * 
     * @param university the university details to update
     * @param universityId the ID of the university to update
     * @return the updated university
     */
    public University updateUniversity(University university, Long universityId) {
        University existingUniversity = universityRepository.findById(universityId).orElseThrow();
        
        existingUniversity.setUniversityName(university.getUniversityName());
        existingUniversity.setAddress(university.getAddress());
        existingUniversity.setCity(university.getCity());
        existingUniversity.setLocation(university.getLocation());
        
        return universityRepository.save(existingUniversity);
    }

    /**
     * Deletes a university by its ID.
     * 
     * @param universityId the ID of the university to delete
     */
    public void deleteUniversity(Long universityId) {
        universityRepository.deleteById(universityId);
    }
}
