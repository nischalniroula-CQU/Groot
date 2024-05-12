package com.fyp.groot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product {

	@Id
	@Column(name = "promo_id", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long promoId;

	@Column(name = "linked_id")
	private Long linkedId;

	@Column(name = "product_title")
	private String productTitle;

	@Column
	private String productDescription;

	@Column
	private Double price;

	@Column
	private String status;
}
