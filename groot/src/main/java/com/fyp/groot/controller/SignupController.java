package com.fyp.groot.controller;

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
import java.time.OffsetDateTime;

/**
 * SignupController handles HTTP requests for user signup operations.
 */
@RestController
public class SignupController {

    @Autowired
    UserService userService;

    /**
     * Handles POST requests for user signup.
     * 
     * @param signupRequest the request body containing the user's signup details
     * @return a ResponseEntity containing the signup response or an error status
     */
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        User login = new User();
        OffsetDateTime currentDateTime = OffsetDateTime.now();
        
        login.setFirstName(signupRequest.getFirstName());
        login.setLastName(signupRequest.getLastName());
        login.setEmailId(signupRequest.getEmail());
        login.setCity(signupRequest.getCity());
        login.setCountry(signupRequest.getCountry());
        login.setPhoneNumber(signupRequest.getPhoneNumber());
        login.setUserType(signupRequest.getUserType());
        login.setAddress(signupRequest.getAddress());
        login.setCultureId(signupRequest.getCulture());
        login.setUniversityId(signupRequest.getUniversity());
        login.setUserSince(currentDateTime);
        
        try {
            SignupResponse response = new SignupResponse();

            // Create the user in Firebase and link to the user record
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
}
