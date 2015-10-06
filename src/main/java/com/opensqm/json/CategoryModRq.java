package com.opensqm.json;

/**
 * Category modify request message.
 *
 */
public class CategoryModRq extends RequestMessage {

	/**
	 * Category
	 */
	private Category category;

	/**
	 * Default constructor
	 */
	public CategoryModRq() {
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