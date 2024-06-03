package com.fyp.groot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fyp.groot.entity.Product;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findByProductTitle(String String);

	@Query("SELECT COUNT(p) FROM Product p WHERE p.linkedId IN :businessIds")
    long countByBusinessIds(@Param("businessIds") List<Long> businessIds);
	
}
