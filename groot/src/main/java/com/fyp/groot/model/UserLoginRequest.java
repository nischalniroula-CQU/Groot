package com.fyp.groot.model;

import com.fyp.groot.commons.BaseRequest;

public class UserLoginRequest extends BaseRequest {
	private String username;
    private String password;
	public UserLoginRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
