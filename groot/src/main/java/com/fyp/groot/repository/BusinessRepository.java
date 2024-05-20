package com.fyp.groot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fyp.groot.entity.Business;
import com.fyp.groot.entity.BusinessTiming;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long>{

	public Business findByName(String string);

}
