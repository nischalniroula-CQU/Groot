package com.fyp.groot.model;

import java.util.List;

import com.fyp.groot.entity.University;

public class ViewUniversitiesResponse {
	private List<University> universities;

	public List<University> getUniversities() {
		return universities;
	}

	public void setUniversities(List<University> universities) {
		this.universities = universities;
	}

}
