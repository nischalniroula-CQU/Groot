package com.fyp.groot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.Category;
import com.fyp.groot.entity.Country;
import com.fyp.groot.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
    private CountryRepository countryRepository;

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }
    
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
    
    public void deleteCountry(Long countryId) {
    	countryRepository.deleteById(countryId);
	}
    
    public Country updateCountry(Country country, Long countryId) {

    	Country existingCountry = countryRepository.findById(countryId).orElseThrow();
		return countryRepository.save(existingCountry);
	}
    
    public long countCountries() {
        return countryRepository.count();
    }

}
