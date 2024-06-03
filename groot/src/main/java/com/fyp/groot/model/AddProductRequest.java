package com.fyp.groot.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {
	
	private Long promoId;

	private Long linkedId;

	private String productTitle;

	private String productDescription;

	private Double price;

	private String status;

}
