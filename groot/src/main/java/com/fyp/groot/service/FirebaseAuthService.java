package com.fyp.groot.service;

import org.springframework.stereotype.Service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

@Service
public class FirebaseAuthService {

    public String generateEmailVerificationLink(String email) throws FirebaseAuthException {
        return FirebaseAuth.getInstance().generateEmailVerificationLink(email);
    }

    public String generatePasswordResetLink(String email) throws FirebaseAuthException {
        return FirebaseAuth.getInstance().generatePasswordResetLink(email);
    }
}
