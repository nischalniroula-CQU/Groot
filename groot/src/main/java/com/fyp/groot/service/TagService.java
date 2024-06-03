package com.fyp.groot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.Tag;
import com.fyp.groot.repository.TagRepository;

/**
 * TagService handles the business logic for tag-related operations.
 */
@Service
public class TagService {
	
    @Autowired
    private TagRepository tagRepository;

    /**
     * Adds a new tag.
     * 
     * @param tag the tag to add
     * @return the added tag
     */
    public Tag addTag(Tag tag) {
        // Add business logic as required (validation, etc.)
        return tagRepository.save(tag);
    }

    /**
     * Retrieves all tags.
     * 
     * @return a list of all tags
     */
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    /**
     * Updates an existing tag.
     * 
     * @param tag the tag details to update
     * @param tagId the ID of the tag to update
     * @return the updated tag
     */
    public Tag updateTag(Tag tag, Long tagId) {
        Tag existingTag = tagRepository.findById(tagId).orElseThrow();
        return tagRepository.save(existingTag);
    }

    /**
     * Deletes a tag by its ID.
     * 
     * @param tagId the ID of the tag to delete
     */
    public void deleteTag(Long tagId) {
        tagRepository.deleteById(tagId);
    }

    /**
     * Counts the total number of tags.
     * 
     * @return the total number of tags
     */
    public long countTags() {
        return tagRepository.count();
    }
}
