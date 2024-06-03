package com.fyp.groot.model;

import java.util.List;
import com.fyp.groot.entity.BusinessTiming;
import com.fyp.groot.entity.ImageLibrary;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViewBusinessResponse {
	private Long businessId;
	private String name;
	private String subtitle;
	private Long categoryId;
	private Long cultureId;
	private String basicDetail;
	private String contactMethod;
	private String phoneNumber;
	private String email;
	private Long ownerId;
	private String latitude;
	private String longitude;
	private String address;
	private String city;
	private String country;
	private String priceRange;
	private String addedOn;
	private String status;
	private BusinessTiming businessTiming;
	private List<ImageLibrary> images;
}
