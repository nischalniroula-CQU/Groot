package com.fyp.groot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fyp.groot.entity.Culture;
import com.fyp.groot.entity.Tag;
import com.fyp.groot.model.GetAllTagsResponse;
import com.fyp.groot.model.ViewMultipleBusinessRequest;
import com.fyp.groot.model.ViewMultipleBusinessResponse;
import com.fyp.groot.service.TagService;

@RestController
@RequestMapping("/api/tags")
public class TagController {
	
	@Autowired
    private TagService tagService;
	
	
	@GetMapping("/getAll")
    public ResponseEntity<GetAllTagsResponse> getAllTags() {
        List<Tag> tags = tagService.getAllTags();
        GetAllTagsResponse response = new GetAllTagsResponse();
        response.setTags(tags);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
	
	@PostMapping("/add")
    public ResponseEntity<Tag> addGet(@RequestBody Tag tag) {
		Tag addedTag = tagService.addTag(tag);
        return new ResponseEntity<>(addedTag, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Tag> updateTag(@PathVariable("id") Long tagId, @RequestBody Tag tag) {
		Tag updatedTag = tagService.updateTag(tag, tagId);
		return new ResponseEntity<>(updatedTag, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteTag(@PathVariable("id") Long tagId) {
		tagService.deleteTag(tagId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
//	@PostMapping("/addCulture")
//    public ResponseEntity<AddCultureResponse> addCulture(@RequestBody AddCultureRequest request) {
//        Culture culture = new Culture();
//        culture.setCultureName(request.getCultureName());
//        culture.setStatus(request.getStatus());
//
//        Culture addedCulture = cultureService.addCulture(culture);
//
//        AddCultureResponse response = new AddCultureResponse();
//        response.setCulture(addedCulture);
//
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }

}
