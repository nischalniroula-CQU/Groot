package com.fyp.groot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fyp.groot.entity.BusinessReview;

@Repository
public interface BusinessReviewRepository extends JpaRepository<BusinessReview, Long>{
	
	List<BusinessReview> findByBusinessId(Long businessId);
	
	List<BusinessReview> findByUserId(Long userId);

}