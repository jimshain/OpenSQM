package com.opensqm.json;

/**
 * Category inquiry response.
 *
 */
public class CategoryInqRs extends ResponseMessage {

	/**
	 * Categories
	 */
	private Category[] categories;

	/**
	 * Default constructor
	 */
	public CategoryInqRs() {
	}

	/**
	 * Gets the categories.
	 * 
	 * @return Categories
	 */
	public Category[] getCategories() {
		return categories;
	}

	/**
	 * Sets the categories.
	 * 
	 * @param categories
	 *            Categories
	 */
	public void setCategories(Category[] categories) {
		this.categories = categories;
	}

} // Class end