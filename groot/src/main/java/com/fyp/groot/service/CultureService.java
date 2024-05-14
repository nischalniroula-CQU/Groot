package com.fyp.groot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.Country;
import com.fyp.groot.entity.Culture;
import com.fyp.groot.repository.CultureRepository;

@Service
public class CultureService {
	
	@Autowired
    private CultureRepository cultureRepository;

    public Culture addCulture(Culture culture) {
        // Add business logic as required (validation, etc.)
        return cultureRepository.save(culture);
    }
    
    public List<Culture> getAllCultures() {
        return cultureRepository.findAll();
    }
    
    public Culture updateCulture(Culture culture, Long cultureId) {

    	Culture existingCulture = cultureRepository.findById(cultureId).orElseThrow();
		return cultureRepository.save(existingCulture);
	}
    
    public void deleteCulture(Long cultureId) {
    	cultureRepository.deleteById(cultureId);
	}
    
    public long countCultures() {
        return cultureRepository.count();
    }

}
