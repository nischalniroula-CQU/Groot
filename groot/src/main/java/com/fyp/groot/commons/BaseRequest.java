package com.fyp.groot.commons;

/**
 * BaseRequest class represents a base request structure with common fields like email, channel, and IP.
 */
public class BaseRequest {
    private String email;
    private String channel; // web, ios
    private String ip;

    /**
     * Gets the email associated with the request.
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email associated with the request.
     * 
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the channel of the request (e.g., web, ios).
     * 
     * @return the channel
     */
    public String getChannel() {
        return channel;
    }

    /**
     * Sets the channel of the request (e.g., web, ios).
     * 
     * @param channel the channel to set
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * Gets the IP address from where the request originated.
     * 
     * @return the IP address
     */
    public String getIp() {
        return ip;
    }

    /**
     * Sets the IP address from where the request originated.
     * 
     * @param ip the IP address to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }
}
