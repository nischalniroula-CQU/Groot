package com.fyp.groot.entity;

import com.google.cloud.firestore.annotation.DocumentId;

public class ApplicationUser {
	@DocumentId
    private String id;
    private String username;
    private String password;
    private String imageUrl;
    private String bio;

}
