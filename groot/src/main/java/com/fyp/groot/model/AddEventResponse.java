package com.fyp.groot.model;

public class AddEventResponse {
	
	private Long eventID;
    private String message;
    
	public Long getEventID() {
		return eventID;
	}
	public void setEventID(Long eventID) {
		this.eventID = eventID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
