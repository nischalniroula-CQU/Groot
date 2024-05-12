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
public class GetAllProductRequest {
	
	private String productTitle;
	private Long promoId;
	private Long linkedId;
	

}
