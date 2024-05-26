package com.fyp.groot.model;

import java.util.List;

import com.fyp.groot.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductsResponse {
	
//	private Long promoId;
//	private Long linkedId;
//	private String productTitle;
//	private String productDescription;
//	private Double price;
//	private String status;
	private List<Product> products;

}
