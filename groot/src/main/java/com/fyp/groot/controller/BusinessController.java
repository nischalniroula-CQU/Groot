package com.fyp.groot.controller;

import com.fyp.groot.model.GetBusinessesByForeignIdRequest;
import com.fyp.groot.model.ViewBusinessResponse;
import com.fyp.groot.model.ViewMultipleBusinessRequest;
import com.fyp.groot.model.ViewMultipleBusinessResponse;
import com.fyp.groot.model.AddBusinessRequest;
import com.fyp.groot.model.AddBusinessResponse;
import com.fyp.groot.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/business")
public class BusinessController {

	@Autowired
	BusinessService businessService;

	@PostMapping("/getall")
	public ResponseEntity<ViewMultipleBusinessResponse> getBusinesses(@RequestBody ViewMultipleBusinessRequest request) {
		ViewMultipleBusinessResponse response = businessService.viewMultipleBusinesses(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/getbyid")
	public ResponseEntity<ViewBusinessResponse> viewBusiness(@RequestParam Long businessId) {
		ViewBusinessResponse response = businessService.viewBusiness(businessId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<AddBusinessResponse> updateBusiness(@PathVariable("id") Long businessId, @RequestBody AddBusinessRequest request) {
		AddBusinessResponse response = businessService.updateBusiness(request, businessId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteBusiness(@PathVariable("id") Long businessId) {
		businessService.deleteBusiness(businessId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<AddBusinessResponse> addBusiness(@RequestBody AddBusinessRequest request) {
	    AddBusinessResponse response = businessService.addBusiness(request); // Get the response from the service
	    return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

//	@PostMapping("/add")
//	public ResponseEntity<AddBusinessResponse> addBusiness(@RequestBody AddBusinessRequest request) {
//		AddBusinessResponse response = new AddBusinessResponse();
//		response.setBusiness(businessService.addBusiness(request));
//		return new ResponseEntity<>(response, HttpStatus.CREATED);
//	}

	@PostMapping("/getbyfilter")
	public ResponseEntity<ViewMultipleBusinessResponse> getBusinessesByFilter(@RequestBody GetBusinessesByForeignIdRequest request) {
		ViewMultipleBusinessResponse response = businessService.getBusinessesByFilter(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
