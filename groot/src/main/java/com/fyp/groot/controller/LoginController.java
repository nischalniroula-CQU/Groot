package com.fyp.groot.controller;

import java.sql.Date;
import java.time.LocalDateTime;
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
import com.fyp.groot.entity.User;
import com.fyp.groot.model.LoginRequest;
import com.fyp.groot.model.LoginResponse;
import com.fyp.groot.model.UserDetail;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api")
public class LoginController {

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Authenticate with email and password using Firebase Authentication REST API
            String email = loginRequest.getEmail();
            String password = loginRequest.getPassword();

            boolean authenticated = authenticateUser(email, password);
            if (!authenticated) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: Invalid email or password");
            }

            // Retrieve user details using Firebase Admin SDK
            UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail(email);

            if (!userRecord.isDisabled()) {
                User user = new User();
                user.setLastLogin(LocalDateTime.now());

                // Generate custom token
                String customToken = FirebaseAuth.getInstance().createCustomToken(userRecord.getUid());

                // Prepare response
                LoginResponse response = new LoginResponse();
                response.setToken(customToken);

                UserDetail userDetail = new UserDetail();
                userDetail.setEmail(userRecord.getEmail());
                userDetail.setUid(userRecord.getUid());

                response.setUserDetail(userDetail);
                response.setResponseCode(Constant.SUCCESS_RESPONSE_CODE);
                response.setResponseDesc(Constant.SUCCESS_RESPONSE_DESC);

                return ResponseEntity.ok().body(response);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: User is disabled");
            }

        } catch (FirebaseAuthException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
        }
    }

    // This method uses Firebase Authentication REST API to authenticate email and password
    private boolean authenticateUser(String email, String password) {
        try {
            String firebaseApiKey = "AIzaSyCswxis61vlw4Uhj-AJOF7F4WUuM2mkmrA"; // Replace with your Firebase API key
            String url = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=" + firebaseApiKey;

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, String> body = new HashMap<>();
            body.put("email", email);
            body.put("password", password);
            body.put("returnSecureToken", "true");

            HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);
            ResponseEntity<Map> response = restTemplate.postForEntity(url, entity, Map.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
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
