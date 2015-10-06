package com.opensqm.json;

/**
 * Category delete request message.
 *
 */
public class CategoryDelRq extends RequestMessage {

	/**
	 * Category ID
	 */
	private String categoryId;

	/**
	 * Default constructor
	 */
	public CategoryDelRq() {
	}

	/**
	 * Gets the category ID.
	 * 
	 * @return category ID
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