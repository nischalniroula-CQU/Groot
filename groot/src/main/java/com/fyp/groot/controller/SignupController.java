package com.fyp.groot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fyp.groot.model.userlogin.SignupRequest;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

@RestController
public class SignupController {
	
	@PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest signupRequest) {
        try {
            // Create the user in Firebase Authentication
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(signupRequest.getEmail())
                    .setPassword(signupRequest.getPassword());
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);

            // You can also set additional properties of the user here if needed

            return ResponseEntity.ok().body("User created successfully. UID: " + userRecord.getUid());
        } catch (FirebaseAuthException e) {
            // Handle errors (e.g., email already exists, weak password, etc.)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Signup failed: " + e.getMessage());
        }
    }

}
