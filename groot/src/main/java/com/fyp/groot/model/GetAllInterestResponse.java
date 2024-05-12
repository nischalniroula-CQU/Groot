package com.fyp.groot.model;

import java.util.List;
import java.util.Set;

import com.fyp.groot.entity.Business;
import com.fyp.groot.entity.InterestLibrary;
import com.fyp.groot.entity.Event;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllInterestResponse {
	
	private List<InterestLibrary> interest;

}
