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
public class GetAllProductsRequest {
	
	private Long promoId;
	private Long linkedId;
	private String productTitle;
	private String productDescription;
	private Double price;
	private String status;
	

}
