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
public class BusinessTiming {

	@Id
	@Column(nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long timingId;

	@Column
	private String monday;

	@Column
	private String tuesday;

	@Column
	private String wednesday;

	@Column
	private String thursday;

	@Column
	private String friday;

	@Column
	private String saturday;

	@Column
	private String sunday;

	@Column(name = "business_id")
	private Long businessId;

}
