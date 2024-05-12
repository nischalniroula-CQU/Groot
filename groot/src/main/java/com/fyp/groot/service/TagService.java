package com.fyp.groot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.Tag;
import com.fyp.groot.repository.TagRepository;

@Service
public class TagService {
	
	@Autowired
    private TagRepository tagRepository;

    public Tag addTag(Tag tag) {
        // Add business logic as required (validation, etc.)
        return tagRepository.save(tag);
    }
    
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }
    
    public long countTags() {
        return tagRepository.count();
    }

}
