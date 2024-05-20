//package com.fyp.groot.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fyp.groot.model.ImageLibraryRequest;
//import com.fyp.groot.model.ImageLibraryResponse;
//import com.fyp.groot.service.ImageLibraryService;
//
//@RestController
//@RequestMapping("/api/images")
//public class ImageLibraryController {
//	
//	@Autowired
//    private ImageLibraryService imageLibraryService;
//	
//	@PostMapping("/add")
//    public ResponseEntity<ImageLibraryResponse> addImage(@RequestBody ImageLibraryRequest request) {
//        ImageLibraryResponse response = imageLibraryService.addImage(request);
//        return ResponseEntity.ok(response);
//    }
//	
//	@GetMapping("/{postId}")
//    public ResponseEntity<List<ImageLibraryResponse>> getImagesByPostId(@PathVariable Long postId) {
//        List<ImageLibraryResponse> responses = imageLibraryService.getImagesByPostId(postId);
//        return ResponseEntity.ok(responses);
//    }
//
//}
