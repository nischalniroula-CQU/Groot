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

import com.fyp.groot.entity.InterestLibrary;
import com.fyp.groot.model.GetAllInterestResponse;
import com.fyp.groot.service.InterestService;

/**
 * InterestsController handles HTTP requests for interest-related operations.
 */
@RestController
@RequestMapping("/api/interests")
public class InterestsController {

    @Autowired
    private InterestService interestService;

    /**
     * Handles GET requests to get all interests.
     * 
     * @return a ResponseEntity containing the response with the list of all interests
     */
    @GetMapping("/getAll")
    public ResponseEntity<GetAllInterestResponse> getAllInterests() {
        List<InterestLibrary> interests = interestService.getAllInterests();
        GetAllInterestResponse response = new GetAllInterestResponse();
        response.setInterest(interests);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles POST requests to add a new interest.
     * 
     * @param interest the request body containing the new interest details
     * @return a ResponseEntity containing the added interest
     */
    @PostMapping("/add")
    public ResponseEntity<InterestLibrary> addInterest(@RequestBody InterestLibrary interest) {
        InterestLibrary addedInterest = interestService.addInterest(interest);
        return new ResponseEntity<>(addedInterest, HttpStatus.CREATED);
    }

    /**
     * Handles PUT requests to update an interest.
     * 
     * @param interestId the ID of the interest to update
     * @param interest the request body containing the updated interest details
     * @return a ResponseEntity containing the updated interest
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<InterestLibrary> updateInterest(@PathVariable("id") Long interestId, @RequestBody InterestLibrary interest) {
        InterestLibrary updatedInterest = interestService.updateInterest(interest, interestId);
        return new ResponseEntity<>(updatedInterest, HttpStatus.OK);
    }

    /**
     * Handles DELETE requests to delete an interest by its ID.
     * 
     * @param interestId the ID of the interest to delete
     * @return a ResponseEntity with HTTP status OK
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteInterest(@PathVariable("id") Long interestId) {
        interestService.deleteInterest(interestId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
