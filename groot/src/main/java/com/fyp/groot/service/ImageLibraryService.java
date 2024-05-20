package com.fyp.groot.service;

import java.util.List;
import java.util.Optional;
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
	
	
	public List<ImageLibraryResponse> addImage(ImageLibrary imageLibrary) {
//        ImageLibrary imageLibrary = new ImageLibrary();
//        imageLibrary.setType(request.getType());
//        imageLibrary.setImageName(request.getImageName());
//        imageLibrary.setPostId(request.getPostId());
        imageLibrary = imageLibraryRepository.save(imageLibrary);

//        List<ImageLibrary> images = imageLibraryRepository.findByPostId(request.getPostId());
        
        Optional<ImageLibrary> firstImageOptional = imageLibraryRepository.findFirstByBusinessId(imageLibrary.getBusinessId());
        ImageLibrary firstImage = firstImageOptional.orElse(null);
        // Fetch images by businessId to determine the cover image (if applicable)
        List<ImageLibrary> images = imageLibraryRepository.findByBusinessId(imageLibrary.getBusinessId()); 
        boolean isCoverImage = images.size() == 1;

        return images.stream()
                .map(image -> {
                    boolean isCurrentImageCover = (firstImage != null && firstImage.getImageId().equals(image.getImageId()));
                    return convertToResponse(image, isCoverImage); // Explicitly return the response object
                })
                .collect(Collectors.toList());
        		//images.stream().map(image -> convertToResponse(image, images.indexOf(image) == 0)).collect(Collectors.toList());
        		//convertToResponse(imageLibrary, isCoverImage);
    }

    public List<ImageLibraryResponse> getImagesByPostId(Long postId) {
        List<ImageLibrary> images = imageLibraryRepository.findByPostId(postId);
        return images.stream().map(image -> convertToResponse(image, images.indexOf(image) == 0)).collect(Collectors.toList());
    }
    
    public List<ImageLibraryResponse> getImagesByBusinessId(Long businessId) {
        Optional<ImageLibrary> firstImageOptional = imageLibraryRepository.findFirstByBusinessId(businessId);
        ImageLibrary firstImage = firstImageOptional.orElse(null);

        List<ImageLibrary> images = imageLibraryRepository.findByBusinessId(businessId);

        return images.stream()
                .map(image -> {
                    boolean isCoverImage = (firstImage != null && firstImage.getImageId().equals(image.getImageId()));
                    return convertToResponse(image, isCoverImage); // Explicitly return the response object
                })
                .collect(Collectors.toList());
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
