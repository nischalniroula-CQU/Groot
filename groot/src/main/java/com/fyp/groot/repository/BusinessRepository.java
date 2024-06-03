package com.fyp.groot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fyp.groot.entity.Business;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long>{
	@Query("SELECT COUNT(p) FROM Business p WHERE p.ownerId = :userId")
    long countByUserId(@Param("userId") Long userId);
}
