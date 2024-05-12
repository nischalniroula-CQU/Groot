package com.fyp.groot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    
    public long countCountries() {
        return countryRepository.count();
    }

}
