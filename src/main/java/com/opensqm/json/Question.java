package com.opensqm.json;

/**
 * Question
 * 
 * @author Jim Shain
 *
 */
public class Question {

	/**
	 * ID
	 */
	private String id;

	/**
	 * Text
	 */
	private String text;

	/**
	 * Choices
	 */
	private Choice[] choices;

	/**
	 * Category ID
	 */
	private String categoryId;

	/**
	 * Category Text
	 */
	private String categoryText;

	/**
	 * Active
	 */
	private boolean active;

	/**
	 * Default constructor
	 */
	public Question() {
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
	 * Gets the choices.
	 * 
	 * @return Choices
	 */
	public Choice[] getChoices() {
		return choices;
	}

	/**
	 * Sets the choices.
	 * 
	 * @param choices
	 *            Choices
	 */
	public void setChoices(Choice[] choices) {
		this.choices = choices;
	}

	/**
	 * Gets the category ID
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

	/**
	 * Gets the category text.
	 * 
	 * @return Category text
	 */
	public String getCategoryText() {
		return categoryText;
	}

	/**
	 * Sets the category text.
	 * 
	 * @param categoryText
	 *            Category text.
	 */
	public void setCategoryText(String categoryText) {
		this.categoryText = categoryText;
	}

	/**
	 * Gets the active indicator.
	 * 
	 * @return active indicator
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets the active indicator.
	 * 
	 * @param active
	 *            Active indicator
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

} // Class end
