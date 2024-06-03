package com.fyp.groot.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEventRequest {

	private String eventName;
	private String location;
	private Long businessId;

}
