package com.fyp.groot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fyp.groot.entity.Tag;
import com.fyp.groot.model.GetAllTagsResponse;
import com.fyp.groot.service.TagService;

/**
 * TagController handles HTTP requests for tag-related operations.
 */
@RestController
@RequestMapping("/api/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    /**
     * Handles GET requests to get all tags.
     * 
     * @return a ResponseEntity containing the response with the list of all tags
     */
    @GetMapping("/getAll")
    public ResponseEntity<GetAllTagsResponse> getAllTags() {
        List<Tag> tags = tagService.getAllTags();
        GetAllTagsResponse response = new GetAllTagsResponse();
        response.setTags(tags);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles POST requests to add a new tag.
     * 
     * @param tag the request body containing the new tag details
     * @return a ResponseEntity containing the added tag
     */
    @PostMapping("/add")
    public ResponseEntity<Tag> addTag(@RequestBody Tag tag) {
        Tag addedTag = tagService.addTag(tag);
        return new ResponseEntity<>(addedTag, HttpStatus.CREATED);
    }

    /**
     * Handles PUT requests to update a tag.
     * 
     * @param tagId the ID of the tag to update
     * @param tag the request body containing the updated tag details
     * @return a ResponseEntity containing the updated tag
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Tag> updateTag(@PathVariable("id") Long tagId, @RequestBody Tag tag) {
        Tag updatedTag = tagService.updateTag(tag, tagId);
        return new ResponseEntity<>(updatedTag, HttpStatus.OK);
    }

    /**
     * Handles DELETE requests to delete a tag by its ID.
     * 
     * @param tagId the ID of the tag to delete
     * @return a ResponseEntity with HTTP status OK
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable("id") Long tagId) {
        tagService.deleteTag(tagId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
