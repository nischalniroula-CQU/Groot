package com.fyp.groot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.University;
import com.fyp.groot.repository.UniversityRepository;

@Service
public class UniversityService {
	
	@Autowired
    private UniversityRepository universityRepository;

    public University addUniversity(University university) {
        // Add business logic as required (validation, etc.)
        return universityRepository.save(university);
    }
    
    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }
    
    public long countUniversities() {
        return universityRepository.count();
    }

	public University getUniversityById(Long id) {
		return universityRepository.findById(id).orElseThrow();
	}

}
