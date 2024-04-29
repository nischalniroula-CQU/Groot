package com.fyp.groot.controller;


import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fyp.groot.entity.User;
import com.fyp.groot.model.userlogin.UserLoginRequest;
import com.fyp.groot.model.userlogin.UserLoginResponse;
import com.fyp.groot.service.UserService;
import com.google.cloud.Role;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/user")
    public String saveUser(@RequestBody User user) throws InterruptedException, ExecutionException {
    	
    	return userService.saveUser(user);
    }
    
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) throws InterruptedException, ExecutionException {
    	
    	return userService.getUserDetails(id);
    }

    
    
    
    
	/*
	 * @PostMapping("/login") public ResponseEntity<UserLoginResponse>
	 * login(@RequestBody UserLoginRequest loginRequest) throws Exception { try { //
	 * Attempt to retrieve the user by email from Firebase UserRecord userRecord =
	 * FirebaseAuth.getInstance().getUserByEmail(loginRequest.getEmail());
	 * 
	 * //User user = userService.login();
	 * 
	 * // Retrieve or create local user based on Firebase UID
	 * 
	 * 
	 * User localUser = userService.findByFirebaseId(userRecord.getUid())
	 * .orElseGet(() -> { User newUser = new User();
	 * newUser.setFirebaseId(userRecord.getUid()); newUser.setIsActive(true); // Set
	 * user as active by default // Set other properties as needed return
	 * userService.save(newUser); });
	 * 
	 * // Validate user status and role if (localUser.getIsActive() &&
	 * (localUser.getRole() == Role.owner() || userRecord.isEmailVerified())) { //
	 * Generate custom token for user String customToken =
	 * FirebaseAuth.getInstance().createCustomToken(userRecord.getUid());
	 * 
	 * // Prepare login response UserLoginResponse response = new
	 * UserLoginResponse(null, null, customToken, userRecord.getEmail(),
	 * userRecord.getUid()); response.setMessage(response.getMessage());
	 * response.setStatus(response.getStatus()); response.setIdToken(customToken);
	 * response.setEmail(userRecord.getEmail());
	 * //response.setRefreshToken(userRecord.getRefreshToken());
	 * //response.setExpiresIn(userRecord.getExpiresIn());
	 * response.setLocalId(userRecord.getUid());
	 * 
	 * return ResponseEntity.ok(response); } else { throw new
	 * Exception("User is not authorized to log in."); } } catch
	 * (FirebaseAuthException e) { return
	 * ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); // Handle login
	 * failure } }
	 */
    
    
    
    
    
    
    
    
    /*public UserLoginResponse login(@RequestBody UserLoginRequest request, UserLoginResponse response) {
        try {
    	User user = userService.login(request.getUsername(), request.getPassword());
        //UserLoginResponse 
        response = new UserLoginResponse(response.getMessage(), response.getStatus());
        
     // Attempt to retrieve the user by email
        UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail(request.getEmail());
        
        // After successful retrieval, generate a custom token for the user
        String customToken = FirebaseAuth.getInstance().createCustomToken(userRecord.getUid());
        
        // Return the custom token to be used by the client for Firebase Auth
        //return ResponseEntity.ok().body(customToken);

        if (user != null) {
            response.setMessage("Login successful");
        } else {
            response.setMessage("Invalid username or password");
        }

        return response;
        
        
    } catch (FirebaseAuthException e) {
        // Handle exceptions such as user not found or token generation failure
        return UserLoginResponse.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
    }
    }*/
    
}



























/*
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.MediaType; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.fyp.groot.commons.BaseResponse; import
 * com.fyp.groot.model.userlogin.UserLoginRequest; import
 * com.fyp.groot.service.UserService;
 * 
 * @RestController
 * 
 * @RequestMapping("/user") public class UserController {
 * 
 * @Autowired UserService userService;
 * 
 * String apiName;
 * 
 * @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE +
 * ";charset=UTF-8", produces = MediaType.APPLICATION_JSON_VALUE +
 * ";charset=UTF-8") BaseResponse userLogin(@RequestBody UserLoginRequest
 * request) { BaseResponse response = new BaseResponse();
 * 
 * response = userService.userLogin(request,response, apiName);
 * 
 * return response;
 * 
 * }
 * 
 * }
 */