package com.fyp.groot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cultures")
public class Culture {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cultureID;

    @Column(name = "culture_name")
    private String cultureName;

    private String status; // Consider using an Enum for status if you have a predefined set (e.g., 'active', 'inactive') 

	public Long getCultureID() {
		return cultureID;
	}

	public void setCultureID(Long cultureID) {
		this.cultureID = cultureID;
	}

	public String getCultureName() {
		return cultureName;
	}

	public void setCultureName(String cultureName) {
		this.cultureName = cultureName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
