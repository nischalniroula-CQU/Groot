package com.fyp.groot.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Business {

	@Id
	@Column(nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "culture_id")
	private Culture culture;

	@OneToMany(mappedBy = "business")
	private List<BusinessTiming> businessTimings;

	@OneToMany(mappedBy = "business")
	private List<Event> businessEvents;

	@OneToMany(mappedBy = "post")
	private List<Imagelibrary> postImagelibraries;

	@OneToMany(mappedBy = "business")
	private List<Review> businessReviews;
}
