package com.fyp.groot.model;

import java.util.List;

import com.fyp.groot.entity.Category;

public class ViewCategoryResponse {
	private List<Category> categories;

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
