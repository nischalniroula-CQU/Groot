package com.fyp.groot.model;

import java.util.List;

import com.fyp.groot.model.ViewBusinessResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViewMultipleBusinessResponse {
	
	private List<ViewBusinessResponse> businesses;

}
