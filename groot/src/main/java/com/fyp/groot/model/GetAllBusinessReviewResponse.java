package com.fyp.groot.model;

import java.util.List;

import com.fyp.groot.entity.BusinessReview;
import com.fyp.groot.entity.Tag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBusinessReviewResponse {
	private List<BusinessReview> businessReview;

}
