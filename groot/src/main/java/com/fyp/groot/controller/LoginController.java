package com.fyp.groot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fyp.groot.commons.utility.Constant;
import com.fyp.groot.model.LoginRequest;
import com.fyp.groot.model.LoginResponse;
import com.fyp.groot.model.UserDetail;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;

@RestController
@RequestMapping("/api")
public class LoginController {

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
		try {
			LoginResponse response = new LoginResponse();
			// Attempt to retrieve the user by email
			UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail(loginRequest.getEmail());

			if (!userRecord.isDisabled()) {
				// After successful retrieval, generate a custom token for the user
				String customToken = FirebaseAuth.getInstance().createCustomToken(userRecord.getUid());
				
				response.setToken(customToken);

				UserDetail userDetail = new UserDetail();

				userDetail.setEmail(userRecord.getEmail());
				userDetail.setUid(userRecord.getUid());

				response.setUserDetail(userDetail);
				response.setResponseCode(Constant.SUCCESS_RESPONSE_CODE);
				response.setResponseDesc(Constant.SUCCESS_RESPONSE_DESC);
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed user is disabled");
			}

			// Return the custom token to be used by the client for Firebase Auth
			return ResponseEntity.ok().body(response);
		} catch (FirebaseAuthException e) {
			// Handle exceptions such as user not found or token generation failure
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
		}
	}

	@PostMapping("/verifytoken")
	public ResponseEntity<?> verifyToken(@RequestHeader String token) {
		try {
			Map<String, String> response = new HashMap<String, String>();
			
			FirebaseToken decodeToken = FirebaseAuth.getInstance().verifyIdToken(token);

//			response.put("email", decodeToken.getEmail());
//			response.put("uid", decodeToken.getUid());

			// Return the custom token to be used by the client for Firebase Auth
			return ResponseEntity.ok().body(response);
		} catch (FirebaseAuthException e) {
			// Handle exceptions such as user not found or token generation failure
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Verify failed: " + e);
		}
	}
	
	
	
	/*
	 * public ResponseEntity<?> verifyToken(@RequestHeader(value = "token", required
	 * = false) String token) { if (token == null || token.isEmpty()) { return
	 * ResponseEntity.badRequest().body("Token header is missing or empty"); }
	 * 
	 * try { FirebaseToken decodedToken =
	 * FirebaseAuth.getInstance().verifyIdToken(token, false); // You can access
	 * decoded token information here return ResponseEntity.ok().body(decodedToken);
	 * } catch (FirebaseAuthException e) { return
	 * ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Verify failed: " +
	 * e.getMessage()); } }
	 */

}
