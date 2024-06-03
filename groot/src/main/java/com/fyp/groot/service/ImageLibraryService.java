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

/**
 * ImageLibraryService handles the business logic for image library-related operations.
 */
@Service
public class ImageLibraryService {
	
    @Autowired
    private ImageLibraryRepository imageLibraryRepository;
	
    /**
     * Adds a new image to the image library.
     * 
     * @param imageLibrary the image library entity to add
     * @return a list of ImageLibraryResponse containing the images for the business
     */
    public List<ImageLibraryResponse> addImage(ImageLibrary imageLibrary) {
        imageLibrary = imageLibraryRepository.save(imageLibrary);
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
    }

    /**
     * Retrieves images by business ID.
     * 
     * @param businessId the ID of the business to retrieve images for
     * @return a list of ImageLibraryResponse containing the images for the business
     */
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

    /**
     * Converts an ImageLibrary entity to an ImageLibraryResponse object.
     * 
     * @param imageLibrary the ImageLibrary entity to convert
     * @param isCoverImage boolean indicating if the image is a cover image
     * @return the converted ImageLibraryResponse object
     */
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
