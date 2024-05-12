package com.fyp.groot.model;

import com.fyp.groot.entity.Business;
import com.fyp.groot.entity.Event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddEventResponse {
	
	//private Integer eventID;
    //private String message;
    private Event event;
    

}
