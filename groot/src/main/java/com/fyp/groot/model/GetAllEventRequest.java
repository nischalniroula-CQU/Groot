package com.fyp.groot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEventRequest {
	
	private String eventName;
	private String location;
	private Long eventId;
	private Long businessId;
	

}
