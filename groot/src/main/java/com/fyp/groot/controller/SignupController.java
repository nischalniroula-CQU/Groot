package com.fyp.groot.controller;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fyp.groot.commons.utility.Constant;
import com.fyp.groot.entity.User;
import com.fyp.groot.model.SignupRequest;
import com.fyp.groot.model.SignupResponse;
import com.fyp.groot.service.UserService;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

@RestController
public class SignupController {

	@Autowired
	UserService userService;

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
		
		// Add password validation
	   // if (!signupRequest.getPassword().equals(signupRequest.getConfrimPassword())) {
	     //   return ResponseEntity.badRequest().body("Passwords do not match");
	    //}else {
		
		User login = new User();
		
		login.setFirstName(signupRequest.getFirstName());
		login.setLastName(signupRequest.getLastName());
		login.setEmailId(signupRequest.getEmail());
		login.setCity(signupRequest.getCity());
		login.setCountry(signupRequest.getCountry());
		login.setPhoneNumber(signupRequest.getPhoneNumber());
		//login.setPassword(signupRequest.getPassword());
		
		login.setUserType(signupRequest.getUserType());
		login.setAddress(signupRequest.getAddress());
		login.setCultureId(signupRequest.getCulture());
		login.setUniversityId(signupRequest.getUniversity());
		login.setUserSince(OffsetDateTime.now());
		
		try {

			SignupResponse response = new SignupResponse();

			UserRecord userRecord = userService.createUserAndLinkFirebaseUser(signupRequest);
			response.setResponseCode(Constant.SUCCESS_RESPONSE_CODE);
			response.setResponseDesc(Constant.SUCCESS_RESPONSE_DESC);
			response.setEmail(userRecord.getEmail());
			response.setUid(userRecord.getUid());

			return ResponseEntity.ok().body(response);
			
		} catch (FirebaseAuthException e) {
			// Handle errors (e.g., email already exists, weak password, etc.)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Signup failed: " + e.getMessage());
		}
	    }
	//}

}
