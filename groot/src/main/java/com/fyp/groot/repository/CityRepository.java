package com.fyp.groot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.fyp.groot.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

}
