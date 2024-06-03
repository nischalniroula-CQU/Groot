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
public class Plan {

	@Id
	@Column(name = "plan_id", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long planId;

	@Column(name = "plan_name")
	private String planName;

	@Column(name = "price")
	private String price;
}