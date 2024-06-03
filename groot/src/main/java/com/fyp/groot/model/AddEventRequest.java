package com.fyp.groot.model;

public class AddEventRequest {
	
	private String eventName;
    private String location;
    private String priceRange;
    private Integer maxSeat;
    private Long businessID;
    
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
	public Long getBusinessID() {
		return businessID;
	}
	public void setBusinessID(Long businessID) {
		this.businessID = businessID;
	}
    

}
