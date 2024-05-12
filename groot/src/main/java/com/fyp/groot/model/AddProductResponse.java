package com.fyp.groot.model;

import com.fyp.groot.entity.Business;
import com.fyp.groot.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductResponse {
	private Product product;

}
