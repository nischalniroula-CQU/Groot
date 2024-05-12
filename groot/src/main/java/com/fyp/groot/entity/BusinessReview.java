package com.fyp.groot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "business_review")
public class BusinessReview {

	@Id
	@Column(name = "review_id", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reviewId;

	@Column(name = "business_id")
	private Long businessId;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "rating")
	private String rating;

	@Column(name = "review")
	private String review;

	@Column(name = "status")
	private String status;

	@Column(name = "add_on")
	private String addOn;
}
