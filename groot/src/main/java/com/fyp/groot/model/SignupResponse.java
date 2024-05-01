package com.fyp.groot.model;

import com.fyp.groot.commons.BaseResponse;

public class SignupResponse extends BaseResponse {
	private String email;
	private String uid;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
}
