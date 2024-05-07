package com.fyp.groot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fyp.groot.entity.Culture;

@Repository
public interface CultureRepository extends JpaRepository<Culture, Long>{

}
