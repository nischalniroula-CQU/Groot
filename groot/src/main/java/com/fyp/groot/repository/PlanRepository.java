package com.fyp.groot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fyp.groot.entity.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long>{

}
