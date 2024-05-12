package com.fyp.groot.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViewBusinessResponse {
	private String name;
	private String subtitle;
	private String categoryName;
	private Long cultureId;
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
}
