package com.fyp.groot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fyp.groot.entity.ImageLibrary;

@Repository
public interface ImageLibraryRepository extends JpaRepository<ImageLibrary, Long>{
	
	List<ImageLibrary> findByPostId(Long postId);

}
