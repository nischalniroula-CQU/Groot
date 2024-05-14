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
import com.fyp.groot.entity.InterestLibrary;
import com.fyp.groot.model.GetAllInterestResponse;
import com.fyp.groot.service.InterestService;

@RestController
@RequestMapping("/api/interests")
public class InterestsController {
	
	@Autowired
    private InterestService interestService;
	
	
	@GetMapping("/getAll")
    public ResponseEntity<GetAllInterestResponse> getAllInterests() {
        List<InterestLibrary> interests = interestService.getAllInterests();
        GetAllInterestResponse response = new GetAllInterestResponse();
        response.setInterest(interests);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	@PostMapping("/add")
    public ResponseEntity<InterestLibrary> addInterest(@RequestBody InterestLibrary interest) {
		InterestLibrary addedInterest = interestService.addInterest(interest);
        return new ResponseEntity<>(addedInterest, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<InterestLibrary> updateInterest(@PathVariable("id") Long interestId, @RequestBody InterestLibrary interest) {
		InterestLibrary updatedCulture = interestService.updateInterest(interest, interestId);
		return new ResponseEntity<>(updatedCulture, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteInterest(@PathVariable("id") Long interestId) {
		interestService.deleteInterest(interestId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
