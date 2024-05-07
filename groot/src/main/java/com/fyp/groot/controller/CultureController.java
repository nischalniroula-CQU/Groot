package com.fyp.groot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fyp.groot.entity.Culture;
import com.fyp.groot.model.AddCultureRequest;
import com.fyp.groot.model.AddCultureResponse;
import com.fyp.groot.service.CultureService;

@RestController
@RequestMapping("/api/cultures")
public class CultureController {
	
	@Autowired
    private CultureService cultureService;
	
	@PostMapping("/addCulture")
    public ResponseEntity<AddCultureResponse> addCulture(@RequestBody AddCultureRequest request) {
        Culture culture = new Culture();
        culture.setCultureName(request.getCultureName());
        culture.setStatus(request.getStatus());

        Culture addedCulture = cultureService.addCulture(culture);

        AddCultureResponse response = new AddCultureResponse();
        response.setCulture(addedCulture);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
