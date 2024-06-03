package com.fyp.groot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fyp.groot.entity.University;
import com.fyp.groot.model.GetUniversitiesResponse;
import com.fyp.groot.model.GetUniversityByIdResponse;
import com.fyp.groot.service.UniversityService;

/**
 * UniversityController handles HTTP requests for university-related operations.
 */
@RestController
@RequestMapping("/api/university")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    /**
     * Handles GET requests to get all universities.
     * 
     * @return a ResponseEntity containing the response with the list of all universities
     */
    @GetMapping("/getAll")
    public ResponseEntity<GetUniversitiesResponse> viewUniversities() {
        List<University> universities = universityService.getAllUniversities();
        GetUniversitiesResponse response = new GetUniversitiesResponse();
        response.setUniversities(universities);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles GET requests to get a university by its ID.
     * 
     * @param id the ID of the university to retrieve
     * @return a ResponseEntity containing the university details
     */
    @GetMapping("/getOne")
    public ResponseEntity<GetUniversityByIdResponse> viewUniversity(@RequestParam String id) {
        University university = universityService.getUniversityById(Long.parseLong(id));
        GetUniversityByIdResponse response = new GetUniversityByIdResponse(university);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles POST requests to add a new university.
     * 
     * @param university the request body containing the new university details
     * @return a ResponseEntity containing the added university
     */
    @PostMapping("/add")
    public ResponseEntity<University> addUniversity(@RequestBody University university) {
        University addedUniversity = universityService.addUniversity(university);
        return new ResponseEntity<>(addedUniversity, HttpStatus.CREATED);
    }

    /**
     * Handles PUT requests to update a university.
     * 
     * @param universityId the ID of the university to update
     * @param university the request body containing the updated university details
     * @return a ResponseEntity containing the updated university
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<University> updateUniversity(@PathVariable("id") Long universityId, @RequestBody University university) {
        University updatedUniversity = universityService.updateUniversity(university, universityId);
        return new ResponseEntity<>(updatedUniversity, HttpStatus.OK);
    }

    /**
     * Handles DELETE requests to delete a university by its ID.
     * 
     * @param universityId the ID of the university to delete
     * @return a ResponseEntity with HTTP status OK
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUniversity(@PathVariable("id") Long universityId) {
        universityService.deleteUniversity(universityId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
