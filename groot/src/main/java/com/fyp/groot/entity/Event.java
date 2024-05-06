package com.fyp.groot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "events")
public class Event {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventID;

    @Column(name = "event_name")
    private String eventName;

    private String location;

    @Column(name = "price_range")
    private String priceRange;

    @Column(name = "max_seat")
    private Integer maxSeat;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;

	public Long getEventID() {
		return eventID;
	}

	public void setEventID(Long eventID) {
		this.eventID = eventID;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}

	public Integer getMaxSeat() {
		return maxSeat;
	}

	public void setMaxSeat(Integer maxSeat) {
		this.maxSeat = maxSeat;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

}
