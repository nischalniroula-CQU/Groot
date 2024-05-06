package com.fyp.groot.entity;

import com.google.cloud.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
//@Data
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	

	private String email;
	private String phoneNumber;
	private String city;
	private String lastName;
	//private String id;
	private String country;
	private String firstName;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
	//private String username;
    //private String password;
    
    //private String firebaseId; // Firebase UID
    //private Boolean isActive;
    //private Role role; // Assuming Role is an Enum (e.g., ADMIN, USER)
    
	/*
	 * public User() {
	 * 
	 * }
	 * 
	 * public User(Long id, String username, String password, String firebaseId,
	 * Boolean isActive, Role role) { super(); this.id = id; this.username =
	 * username; this.password = password; this.firebaseId = firebaseId;
	 * this.isActive = isActive; this.role = role; }
	 * 
	 * 
	 * 
	 * public String getFirebaseId() { return firebaseId; }
	 * 
	 * 
	 * 
	 * public void setFirebaseId(String firebaseId) { this.firebaseId = firebaseId;
	 * }
	 * 
	 * 
	 * 
	 * public Boolean getIsActive() { return isActive; }
	 * 
	 * 
	 * 
	 * public void setIsActive(Boolean isActive) { this.isActive = isActive; }
	 * 
	 * 
	 * 
	 * public Role getRole() { return role; }
	 * 
	 * 
	 * 
	 * public void setRole(Role role) { this.role = role; }
	 * 
	 * 
	 * 
	 * public Long getId() { return id; } public void setId(Long id) { this.id = id;
	 * } public String getUsername() { return username; } public void
	 * setUsername(String username) { this.username = username; } public String
	 * getPassword() { return password; } public void setPassword(String password) {
	 * this.password = password; }
	 */
	

    // Constructors, getters, and setters
    // Omitted for brevity

}
