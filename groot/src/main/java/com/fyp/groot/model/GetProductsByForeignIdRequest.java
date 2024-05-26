package com.fyp.groot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetProductsByForeignIdRequest {
	
	private Long linkedId;
	private String productTitle;
	//private Long businessId;

}
