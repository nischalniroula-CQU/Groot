package com.fyp.groot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
//	@PostMapping("/addCulture")
//    public ResponseEntity<AddCultureResponse> addCulture(@RequestBody AddCultureRequest request) {
//        Culture culture = new Culture();
//        culture.setCultureName(request.getCultureName());
//        culture.setStatus(request.getStatus());
//
//        Culture addedCulture = cultureService.addCulture(culture);
//
//        AddCultureResponse response = new AddCultureResponse();
//        response.setCulture(addedCulture);
//
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }

}
