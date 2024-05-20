package com.fyp.groot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fyp.groot.entity.Favourite;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Long>{

}
