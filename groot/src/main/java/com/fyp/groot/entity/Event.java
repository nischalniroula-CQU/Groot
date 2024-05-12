package com.fyp.groot.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event {
	@Id
	@Column(name = "event_id", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eventId;
	@Column(name = "event_name")
	private String eventName;
	@Column(name = "location")
	private String location;
	@Column(name = "price_range")
	private String priceRange;
	@Column(name = "max_seat")
	private Integer maxSeat;
	@Column(name = "business_id")
	private Long businessId;
}
