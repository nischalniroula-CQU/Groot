package com.fyp.groot.entity;

import com.google.cloud.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    
    private String firebaseId; // Firebase UID
    private Boolean isActive;
    private Role role; // Assuming Role is an Enum (e.g., ADMIN, USER)
    
    public User() {
    	
    }
    
    public User(Long id, String username, String password, String firebaseId, Boolean isActive, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firebaseId = firebaseId;
		this.isActive = isActive;
		this.role = role;
	}

	
    
	public String getFirebaseId() {
		return firebaseId;
	}



	public void setFirebaseId(String firebaseId) {
		this.firebaseId = firebaseId;
	}



	public Boolean getIsActive() {
		return isActive;
	}



	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

    // Constructors, getters, and setters
    // Omitted for brevity

}
