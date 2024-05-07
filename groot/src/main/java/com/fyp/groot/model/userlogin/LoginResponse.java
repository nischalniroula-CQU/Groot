package com.fyp.groot.model.userlogin;

public class LoginResponse {
	
	private String customToken;
    private String errorMessage;

 // Constructors
    public LoginResponse(String customToken, String errorMessage) {
        this.customToken = customToken;
        this.errorMessage = errorMessage;
    }
    
    // Getters and setters
    public String getCustomToken() {
        return customToken;
    }

    public void setCustomToken(String customToken) {
        this.customToken = customToken;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


}
