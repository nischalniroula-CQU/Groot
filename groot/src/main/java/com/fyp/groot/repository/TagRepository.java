package com.fyp.groot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fyp.groot.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{

}
