package com.fyp.groot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "universities")
public class University {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long universityID;

    @Column(name = "university_name")
    private String universityName;

    private String city;
    private String location;
    private String address;
    
	public Long getUniversityID() {
		return universityID;
	}
	public void setUniversityID(Long universityID) {
		this.universityID = universityID;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
