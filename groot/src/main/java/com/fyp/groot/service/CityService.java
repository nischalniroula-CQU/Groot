package com.fyp.groot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.City;
import com.fyp.groot.repository.CityRepository;

@Service
public class CityService {
	
	@Autowired
    private CityRepository cityRepository;

    public City addCity(City city) {
        return cityRepository.save(city);
    }
    
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
    
    public long countCities() {
        return cityRepository.count();
    }

}
