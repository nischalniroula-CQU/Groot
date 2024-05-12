package com.fyp.groot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fyp.groot.entity.University;
import com.fyp.groot.model.GetUniversitiesResponse;
import com.fyp.groot.model.GetUniversityByIdResponse;
import com.fyp.groot.service.UniversityService;

@RestController
@RequestMapping("/api/university")
public class UniversityController {
	
	@Autowired
    private UniversityService universityService;
		
	@GetMapping("/getAll")
    public ResponseEntity<GetUniversitiesResponse> viewUniversities() {
        List<University> universities = universityService.getAllUniversities();
        GetUniversitiesResponse response = new GetUniversitiesResponse();
        response.setUniversities(universities);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

	@GetMapping("/getOne")
	public ResponseEntity<GetUniversityByIdResponse> viewUniversities(@RequestParam String id) {
		University university = universityService.getUniversityById(Long.parseLong(id));
		GetUniversityByIdResponse response = new GetUniversityByIdResponse(university);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	//Example for getting on foreign key
//	@GetMapping("/by-student/{studentId}") // Fetch universities by student ID (foreign key)
//	public ResponseEntity<List<UniversityResponse>> getUniversitiesByStudentId(@PathVariable Long studentId) {
//	    List<UniversityResponse> responses = universityService.getUniversitiesByStudentId(studentId);
//	    return ResponseEntity.ok(responses);
//	}
	
	
	
	

//	@PostMapping("/addUniversity")
//    public ResponseEntity<AddUniversityResponse> addUniversity(@RequestBody AddUniversityRequest request) {
//        University university = new University();
//        university.setUniversityName(request.getUniversityName());
//        university.setCity(request.getCity());
//        university.setLocation(request.getLocation());
//        university.setAddress(request.getAddress());
//
//        University addedUniversity = universityService.addUniversity(university);
//
//        AddUniversityResponse response = new AddUniversityResponse();
//        response.setUniversityId(addedUniversity.getUniversityId());
//        response.setMessage("University added successfully");
//
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
	
}
