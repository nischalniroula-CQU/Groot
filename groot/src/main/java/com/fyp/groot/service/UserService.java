package com.fyp.groot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.commons.BaseResponse;
import com.fyp.groot.commons.utility.Constant;
import com.fyp.groot.entity.User;
import com.fyp.groot.model.userlogin.UserLoginRequest;
import com.fyp.groot.repository.UserRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
	
	public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByFirebaseId(String firebaseId) {
        return userRepository.findByFirebaseId(firebaseId);
    }

	public UserRecord createUser(String email, String password) throws FirebaseAuthException {
		UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setPassword(password);
		
		/*
		 * UserRecord firebaseUser = firebaseUserService.createUser(email, password);
		 * LocalUser localUser = new LocalUser();
		 * localUser.setFirebaseId(firebaseUser.getUid()); // Set other properties
		 * userRepository.save(localUser);
		 */

        return FirebaseAuth.getInstance().createUser(request);
    }
	
	public void updateUser(String uid, String email, String password) throws FirebaseAuthException {
		UserRecord.UpdateRequest request = new UserRecord.UpdateRequest(uid)
	            .setEmail(email)
	            .setPassword(password);

	    FirebaseAuth.getInstance().updateUser(request);
	}
	
	//@Override
	/*
	 * public User login(String username, String password) { return
	 * userRepository.findByUsernameAndPassword(username, password); }
	 */

	/*public BaseResponse userLogin(UserLoginRequest request, BaseResponse response, String apiName) {
		
		response.setResponseCode(Constant.SUCCESS_RESPONSE_CODE);
		response.setResponseDesc(Constant.SUCCESS_RESPONSE_DESC);
		
		return response;
	}*/

}
