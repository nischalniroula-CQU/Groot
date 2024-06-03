package com.fyp.groot.commons;

/**
 * BaseResponse class represents a base response structure with common fields like response code and description.
 */
public class BaseResponse {
    private String responseCode;
    private String responseDesc;

    /**
     * Gets the response code of the response.
     * 
     * @return the response code
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the response code of the response.
     * 
     * @param responseCode the response code to set
     */
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * Gets the response description of the response.
     * 
     * @return the response description
     */
    public String getResponseDesc() {
        return responseDesc;
    }

    /**
     * Sets the response description of the response.
     * 
     * @param responseDesc the response description to set
     */
    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }
}
