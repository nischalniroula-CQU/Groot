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
