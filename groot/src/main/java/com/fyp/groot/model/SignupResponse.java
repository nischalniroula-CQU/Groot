package com.fyp.groot.model;

import java.util.Set;

import com.fyp.groot.commons.BaseResponse;
import com.fyp.groot.entity.Business;
import com.fyp.groot.entity.Event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupResponse extends BaseResponse {
	
	private String email;
	private String uid;

	
}
