package com.fyp.groot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fyp.groot.entity.BusinessTiming;

@Repository
public interface BusinessTimingRepository extends JpaRepository<BusinessTiming, Long>{
	public BusinessTiming findByBusinessId(Long businessId);
	//public BusinessTiming findByName();

}
