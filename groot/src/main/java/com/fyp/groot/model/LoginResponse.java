package com.fyp.groot.model;

import com.fyp.groot.commons.BaseResponse;

public class LoginResponse extends BaseResponse{
	
	private String token;
	private UserDetail userDetail;
	

    // Getters and setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
}
