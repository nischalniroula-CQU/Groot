package com.fyp.groot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.Culture;
import com.fyp.groot.entity.InterestLibrary;
import com.fyp.groot.repository.InterestRepository;

@Service
public class InterestService {
	
	@Autowired
    private InterestRepository interestRepository;

    public InterestLibrary addInterest(InterestLibrary interest) {
        // Add business logic as required (validation, etc.)
        return interestRepository.save(interest);
    }
    
    public List<InterestLibrary> getAllInterests() {
        return interestRepository.findAll();
    }
    
    public InterestLibrary updateInterest(InterestLibrary interest, Long interestId) {

    	InterestLibrary existingInterest = interestRepository.findById(interestId).orElseThrow();
		return interestRepository.save(existingInterest);
	}
    
    public void deleteInterest(Long interestId) {
    	interestRepository.deleteById(interestId);
	}
    
    public long countInterests() {
        return interestRepository.count();
    }

}
