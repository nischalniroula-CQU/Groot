package com.fyp.groot.model.userlogin;

import org.springframework.http.HttpStatus;

import com.fyp.groot.commons.BaseResponse;

public class UserLoginResponse extends BaseResponse {
	private String message;
	private String status;
	private String idToken;
    private String email;
    //private String refreshToken;
    //private String expiresIn;
    private String localId;

	public UserLoginResponse(String message, String status, String idToken, String email, String localId) {
		super();
		this.message = message;
		this.status = status;
		this.idToken = idToken;
		this.email = email;
		//this.refreshToken = refreshToken;
		//this.expiresIn = expiresIn;
		this.localId = localId;
	}


	public String getIdToken() {
		return idToken;
	}


	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	/*
	 * public String getRefreshToken() { return refreshToken; }
	 * 
	 * 
	 * public void setRefreshToken(String refreshToken) { this.refreshToken =
	 * refreshToken; }
	 * 
	 * 
	 * public String getExpiresIn() { return expiresIn; }
	 * 
	 * 
	 * public void setExpiresIn(String expiresIn) { this.expiresIn = expiresIn; }
	 */


	public String getLocalId() {
		return localId;
	}


	public void setLocalId(String localId) {
		this.localId = localId;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static Object status(HttpStatus unauthorized) {
		// TODO Auto-generated method stub
		return null;
	}
	

    // Constructors, getters, and setters
    // Omitted for brevity

}
