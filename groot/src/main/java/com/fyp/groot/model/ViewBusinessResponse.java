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
public class ViewBusinessResponse {
	private String name;
	private String subtitle;
	private String categoryName;
	private String culture;
	private String basicDetail;
	private String contactMethod;
	private String phoneNumber;
	private String email;
	private String ownerName;
	private String latitude;
	private String longitude;
	private String address;
	private String city;
	private String country;
	private String priceRange;
	private String addedOn;
	private String status;
	private List<BusinessTiming> businessTiming;
	private List<Review> businessReview;
	private List<Imagelibrary> images;
	private List<String> tags;
	private List<Event> events;
}
