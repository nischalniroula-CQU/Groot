package com.fyp.groot.service;

import org.springframework.stereotype.Service;

import com.fyp.groot.model.SignupRequest;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

/**
 * FirebaseUserService handles Firebase user-related operations.
 */
@Service
public class FirebaseUserService {

    /**
     * Creates a new user in Firebase with the given signup request details.
     * 
     * @param signupRequest the signup request containing user details
     * @return the created UserRecord
     * @throws FirebaseAuthException if an error occurs while creating the user
     */
    public UserRecord createUser(SignupRequest signupRequest) throws FirebaseAuthException {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(signupRequest.getEmail())
                .setPassword(signupRequest.getPassword());

        return FirebaseAuth.getInstance().createUser(request);
    }

    /**
     * Updates an existing user's email and password in Firebase.
     * 
     * @param uid the UID of the user to update
     * @param email the new email address
     * @param password the new password
     * @throws FirebaseAuthException if an error occurs while updating the user
     */
    public void updateUser(String uid, String email, String password) throws FirebaseAuthException {
        UserRecord.UpdateRequest request = new UserRecord.UpdateRequest(uid)
                .setEmail(email)
                .setPassword(password);

        FirebaseAuth.getInstance().updateUser(request);
    }
}
