package com.fyp.groot.service;

import org.springframework.stereotype.Service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

/**
 * FirebaseAuthService handles Firebase authentication-related operations.
 */
@Service
public class FirebaseAuthService {

    /**
     * Generates an email verification link for the given email.
     * 
     * @param email the email address to generate the verification link for
     * @return the email verification link
     * @throws FirebaseAuthException if an error occurs while generating the link
     */
    public String generateEmailVerificationLink(String email) throws FirebaseAuthException {
        return FirebaseAuth.getInstance().generateEmailVerificationLink(email);
    }

    /**
     * Generates a password reset link for the given email.
     * 
     * @param email the email address to generate the password reset link for
     * @return the password reset link
     * @throws FirebaseAuthException if an error occurs while generating the link
     */
    public String generatePasswordResetLink(String email) throws FirebaseAuthException {
        return FirebaseAuth.getInstance().generatePasswordResetLink(email);
    }
}
