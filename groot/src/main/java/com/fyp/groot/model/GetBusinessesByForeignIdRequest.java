package com.fyp.groot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetBusinessesByForeignIdRequest {
	private Long categoryID;
	private Long cultureID;
	private Long ownerId;
}
