package com.fyp.groot.model;

import java.util.List;

import com.fyp.groot.entity.BusinessTiming;
import com.fyp.groot.entity.Event;
import com.fyp.groot.entity.Imagelibrary;
import com.fyp.groot.entity.Review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViewMultipleBusinessRequest {
	
	private String country;
    private Long categoryID;
    private Long cultureID;
    private String city;
    

}
