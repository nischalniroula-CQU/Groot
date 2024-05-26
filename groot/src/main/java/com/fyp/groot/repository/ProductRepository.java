package com.fyp.groot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fyp.groot.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	Product findByProductTitle(String String);
	//public List<Product> findByBusinessId(Long businessId);

}
