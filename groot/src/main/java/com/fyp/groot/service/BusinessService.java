package com.fyp.groot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.Business;
import com.fyp.groot.repository.BusinessRepository;

@Service
public class BusinessService {
	
	@Autowired 
    private BusinessRepository businessRepository;

    public Business addBusiness(Business business) {
        // Add business logic here (validation, etc.)
        return businessRepository.save(business); 
    }

}
