package com.fyp.groot.service;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyp.groot.commons.BaseResponse;
import com.fyp.groot.commons.utility.Constant;
import com.fyp.groot.entity.User;
import com.fyp.groot.model.userlogin.UserLoginRequest;
//import com.fyp.groot.repository.UserRepository;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class UserService {
	
	private static final String COLLECTION_NAME = "users";
	
	public String saveUser(User user) throws InterruptedException, ExecutionException {
		
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(user.getId()).set(user);
		
		return collectionApiFuture.get().getUpdateTime().toString();
		
	}
	
	public User getUserDetails(String id) throws InterruptedException, ExecutionException {
		
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(id);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();
		
		User user = null;
		if(document.exists()) {
			 user = document.toObject(User.class);
			return user;
		}else {
			return null;
		}
	}

	/*
	 * @Autowired private UserRepository userRepository;
	 * 
	 * public User save(User user) { return userRepository.save(user); }
	 * 
	 * public Optional<User> findByFirebaseId(String firebaseId) { return
	 * userRepository.findByFirebaseId(firebaseId); }
	 * 
	 * public UserRecord createUser(String email, String password) throws
	 * FirebaseAuthException { UserRecord.CreateRequest request = new
	 * UserRecord.CreateRequest() .setEmail(email) .setPassword(password);
	 * 
	 * 
	 * UserRecord firebaseUser = firebaseUserService.createUser(email, password);
	 * LocalUser localUser = new LocalUser();
	 * localUser.setFirebaseId(firebaseUser.getUid()); // Set other properties
	 * userRepository.save(localUser);
	 * 
	 * 
	 * return FirebaseAuth.getInstance().createUser(request); }
	 * 
	 * public void updateUser(String uid, String email, String password) throws
	 * FirebaseAuthException { UserRecord.UpdateRequest request = new
	 * UserRecord.UpdateRequest(uid) .setEmail(email) .setPassword(password);
	 * 
	 * FirebaseAuth.getInstance().updateUser(request); }
	 */
	
	
	

	// @Override
	/*
	 * public User login(String username, String password) { return
	 * userRepository.findByUsernameAndPassword(username, password); }
	 */

	/*
	 * public BaseResponse userLogin(UserLoginRequest request, BaseResponse
	 * response, String apiName) {
	 * 
	 * response.setResponseCode(Constant.SUCCESS_RESPONSE_CODE);
	 * response.setResponseDesc(Constant.SUCCESS_RESPONSE_DESC);
	 * 
	 * return response; }
	 */

}
