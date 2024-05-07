package com.fyp.groot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import com.fyp.groot.model.userlogin.LoginRequest;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, Model model) {
	    try {
	        System.out.println("Attempting to retrieve user: " + loginRequest.getEmail());
	        UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail(loginRequest.getEmail());
	        System.out.println("User found: " + userRecord.getEmail());

	        String customToken = FirebaseAuth.getInstance().createCustomToken(userRecord.getUid());
	        System.out.println("Token generated: " + customToken);
	        
	        model.addAttribute("isLoggedIn", true);
            model.addAttribute("username", userRecord.getEmail());

	        return ResponseEntity.ok().body(customToken);
	    } catch (FirebaseAuthException e) {
	        System.err.println("Error during login: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
	    }
	}

}
