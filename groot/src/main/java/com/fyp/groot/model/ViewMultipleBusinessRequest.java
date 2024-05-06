package com.fyp.groot.model;

public class ViewMultipleBusinessRequest {
	
	private String country;
    private Long categoryID;
    private Long cultureID;
    private String city;
    
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}
	public Long getCultureID() {
		return cultureID;
	}
	public void setCultureID(Long cultureID) {
		this.cultureID = cultureID;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
