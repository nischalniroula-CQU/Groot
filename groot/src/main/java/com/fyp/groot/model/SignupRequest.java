package com.fyp.groot.model;

import java.util.Set;

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
public class SignupRequest {
	
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String city;
	private String country;
    private String password;
    private String confrimPassword;
    


}
