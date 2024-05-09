package com.fyp.groot.model;

import java.util.List;

import com.fyp.groot.entity.Culture;

public class GetAllCulturesResponse {
	
	private List<Culture> cultures;

	public List<Culture> getCultures() {
		return cultures;
	}

	public void setCultures(List<Culture> cultures) {
		this.cultures = cultures;
	}

}
