package com.fyp.groot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBusinessRequest {
	private String name;
	private String subtitle;
	private String basicDetails;
	private String contactMethod;
	private String phoneNumber;
	private String emailId;
	private String location;
	private String address;
	private String city;
	private String country;
	private String priceRange;
	private String status;
	private String addOn;
	private String latitude;
	private String longitude;
	private Long categoryId;
	private Long cultureId;
	private Long ownerId;
}
