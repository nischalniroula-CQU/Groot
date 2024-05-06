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

import com.fyp.groot.entity.University;
import com.fyp.groot.entity.ViewUniversitiesResponse;
import com.fyp.groot.model.AddUniversityRequest;
import com.fyp.groot.model.AddUniversityResponse;
import com.fyp.groot.service.UniversityService;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {
	
	@Autowired
    private UniversityService universityService;
	
	@PostMapping("/addUniversity")
    public ResponseEntity<AddUniversityResponse> addUniversity(@RequestBody AddUniversityRequest request) {
        University university = new University();
        university.setUniversityName(request.getUniversityName());
        university.setCity(request.getCity());
        university.setLocation(request.getLocation());
        university.setAddress(request.getAddress());

        University addedUniversity = universityService.addUniversity(university);

        AddUniversityResponse response = new AddUniversityResponse();
        response.setUniversityID(addedUniversity.getUniversityID());
        response.setMessage("University added successfully");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
	
	
	@GetMapping("/viewUniversities")
    public ResponseEntity<ViewUniversitiesResponse> viewUniversities() {
        List<University> universities = universityService.getAllUniversities();
        ViewUniversitiesResponse response = new ViewUniversitiesResponse();
        response.setUniversities(universities);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
