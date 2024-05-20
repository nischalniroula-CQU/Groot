package com.fyp.groot.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "business")
public class Business {

	@Id
	@Column(name = "business_id", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long businessId;

	@Column
	private String name;

	@Column
	private String subtitle;

	@Column(length = 5000)
	private String basicDetails;

	@Column
	private String contactMethod;

	@Column
	private String phoneNumber;

	@Column
	private String emailId;

	@Column
	private String location;

	@Column
	private String address;

	@Column
	private String city;

	@Column
	private String country;

	@Column
	private String priceRange;

	@Column
	private String status;

	@Column
	private String addOn;

	@Column
	private String latitude;

	@Column
	private String longitude;

	@Column(name = "category_id")
	private Long categoryId;

	@Column(name = "culture_id")
	private Long cultureId;

	@Column(name = "owner_id")
	private Long ownerId;
	
//	@Column(name = "business_timing")
//	private BusinessTiming businessTiming;
//	
//	@Column
//	private List<ImageLibrary> images;
	
}
