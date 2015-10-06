package com.opensqm.json;

/**
 * Category add response message.
 *
 */
public class CategoryAddRs extends ResponseMessage {

	/**
	 * Category ID
	 */
	private String categoryId;

	/**
	 * Default constructor
	 */
	public CategoryAddRs() {
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
	 * Sets the category ID.
	 * 
	 * @param categoryId
	 *            Category ID
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

} // Class end