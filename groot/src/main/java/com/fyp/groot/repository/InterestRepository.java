package com.fyp.groot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fyp.groot.entity.InterestLibrary;

@Repository
public interface InterestRepository extends JpaRepository<InterestLibrary, Long>{

}
