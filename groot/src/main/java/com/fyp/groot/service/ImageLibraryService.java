package com.fyp.groot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.entity.ImageLibrary;
import com.fyp.groot.model.ImageLibraryRequest;
import com.fyp.groot.model.ImageLibraryResponse;
import com.fyp.groot.repository.ImageLibraryRepository;

@Service
public class ImageLibraryService {
	
	@Autowired
    private ImageLibraryRepository imageLibraryRepository;
	
	
	public ImageLibraryResponse addImage(ImageLibraryRequest request) {
        ImageLibrary imageLibrary = new ImageLibrary();
        imageLibrary.setType(request.getType());
        imageLibrary.setImageName(request.getImageName());
        imageLibrary.setPostId(request.getPostId());
        imageLibrary = imageLibraryRepository.save(imageLibrary);

        List<ImageLibrary> images = imageLibraryRepository.findByPostId(request.getPostId());
        boolean isCoverImage = images.size() == 1;

        return convertToResponse(imageLibrary, isCoverImage);
    }

    public List<ImageLibraryResponse> getImagesByPostId(Long postId) {
        List<ImageLibrary> images = imageLibraryRepository.findByPostId(postId);
        return images.stream().map(image -> convertToResponse(image, images.indexOf(image) == 0)).collect(Collectors.toList());
    }

    private ImageLibraryResponse convertToResponse(ImageLibrary imageLibrary, boolean isCoverImage) {
        ImageLibraryResponse response = new ImageLibraryResponse();
        response.setImageId(imageLibrary.getImageId());
        response.setType(imageLibrary.getType());
        response.setImageName(imageLibrary.getImageName());
        response.setPostId(imageLibrary.getPostId());
        response.setCoverImage(isCoverImage);
        return response;
    }

}
