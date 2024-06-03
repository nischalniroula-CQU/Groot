package com.fyp.groot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageLibraryResponse {
	
	private Long imageId;
    private String type;
    private String imageName;
    private Long postId;
    private boolean isCoverImage;
    private Long businessId;

}
