package com.opensqm.json;

/**
 * Category inquiry request.
 *
 */
public class CategoryInqRq extends RequestMessage {

	/**
	 * Category ID
	 */
	private String categoryId;

	/**
	 * Default constructor
	 */
	public CategoryInqRq() {
	}

	/**
	 * Gets the category ID.
	 * 
	 * @return Category ID
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * Sets the category ID
	 * 
	 * @param categoryId
	 *            Category ID
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

} // Class end