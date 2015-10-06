package com.opensqm.json;

/**
 * Category add request message.
 *
 */
public class CategoryAddRq extends RequestMessage {

	/**
	 * Category
	 */
	private Category category;

	/**
	 * Default constructor
	 */
	public CategoryAddRq() {
	}

	/**
	 * Gets the category.
	 * 
	 * @return Category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 * 
	 * @param category
	 *            Category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

} // Class end