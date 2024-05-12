package com.fyp.groot.model;

import java.util.List;
import com.fyp.groot.entity.Business;
import com.fyp.groot.entity.Category;
import com.fyp.groot.entity.Product;
import com.fyp.groot.entity.User;

import jakarta.persistence.Entity;
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
public class GetAllProductResponse {
	
	private List<Product> product;


}
