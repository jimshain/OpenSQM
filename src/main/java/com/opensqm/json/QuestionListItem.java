package com.opensqm.json;

/**
 * Question list item.
 * 
 * @author Jim Shain
 *
 */
public class QuestionListItem {

	/**
	 * ID
	 */
	private String id;

	/**
	 * Text
	 */
	private String text;

	/**
	 * Category
	 */
	private String category;

	/**
	 * Active
	 */
	private boolean active;

	/**
	 * Default constructor
	 */
	public QuestionListItem() {
	}

	/**
	 * Gets the ID.
	 * 
	 * @return ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the ID.
	 * 
	 * @param id
	 *            ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the text.
	 * 
	 * @return Text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 * 
	 * @param text
	 *            Text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the category.
	 * 
	 * @return Category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 * 
	 * @param category
	 *            Category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Gets if active.
	 * 
	 * @return Active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets active.
	 * 
	 * @param active
	 *            Active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

} // Class end