package com.fyp.groot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fyp.groot.model.userlogin.LoginRequest;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
	    try {
	        // Attempt to retrieve the user by email
	        UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail(loginRequest.getEmail());
	        
	        // After successful retrieval, generate a custom token for the user
	        String customToken = FirebaseAuth.getInstance().createCustomToken(userRecord.getUid());
	        
	        // Return the custom token to be used by the client for Firebase Auth
	        return ResponseEntity.ok().body(customToken);
	    } catch (FirebaseAuthException e) {
	        // Handle exceptions such as user not found or token generation failure
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
	    }
	}

}
