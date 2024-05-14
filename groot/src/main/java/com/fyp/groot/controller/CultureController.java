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

import com.fyp.groot.entity.Country;
import com.fyp.groot.entity.Culture;
import com.fyp.groot.model.GetAllCulturesResponse;
import com.fyp.groot.model.ViewMultipleBusinessRequest;
import com.fyp.groot.model.ViewMultipleBusinessResponse;
import com.fyp.groot.service.CultureService;

@RestController
@RequestMapping("/api/cultures")
public class CultureController {
	
	@Autowired
    private CultureService cultureService;
	
	
	@GetMapping("/getAll")
    public ResponseEntity<GetAllCulturesResponse> getAllCultures() {
        List<Culture> cultures = cultureService.getAllCultures();
        GetAllCulturesResponse response = new GetAllCulturesResponse();
        response.setCultures(cultures);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	
	@PostMapping("/add")
    public ResponseEntity<Culture> addCountry(@RequestBody Culture culture) {
		Culture addedCulture = cultureService.addCulture(culture);
        return new ResponseEntity<>(addedCulture, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Culture> updateCulture(@PathVariable("id") Long cultureId, @RequestBody Culture culture) {
		Culture updatedCulture = cultureService.updateCulture(culture, cultureId);
		return new ResponseEntity<>(updatedCulture, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCulture(@PathVariable("id") Long cultureId) {
		cultureService.deleteCulture(cultureId);
		return new ResponseEntity<>(HttpStatus.OK);
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
