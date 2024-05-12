package com.fyp.groot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fyp.groot.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
