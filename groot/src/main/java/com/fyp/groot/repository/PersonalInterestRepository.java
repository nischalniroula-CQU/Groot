package com.fyp.groot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fyp.groot.entity.PersonalInterest;

@Repository
public interface PersonalInterestRepository extends JpaRepository<PersonalInterest, Long>{

}
