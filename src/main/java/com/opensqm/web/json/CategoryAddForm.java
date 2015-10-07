package com.opensqm.web.json;

public class CategoryAddForm {
	
	/**
	 * Text
	 */
	private String text;
	
	/**
	 * Weight
	 */
	private String weight;
	
	/**
	 * Default constructor
	 */
	public CategoryAddForm() {}

	/**
	 * Gets the text.
	 * @return Text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 * @param text Text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the weight.
	 * @return Weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * Sets the weight.
	 * @param weight Weight
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
} // Class end