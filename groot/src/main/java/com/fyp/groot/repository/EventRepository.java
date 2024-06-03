package com.fyp.groot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fyp.groot.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	
	@Query("SELECT COUNT(e) FROM Event e WHERE e.businessId IN :businessIds")
    long countByBusinessIds(@Param("businessIds") List<Long> businessIds);
}
