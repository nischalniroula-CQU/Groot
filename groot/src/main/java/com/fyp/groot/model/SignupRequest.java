package com.fyp.groot.model;

import java.util.Set;

import com.fyp.groot.entity.Business;
import com.fyp.groot.entity.Event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

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
    private String userType;
    private String address;
    private String culture;
    private String university;
    private OffsetDateTime userSince;
    

}
