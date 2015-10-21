package com.opensqm.json;

/**
 * Category
 * 
 * @Jim Shain
 *
 */
public class Category {

	/**
	 * ID
	 */
	private String id;

	/**
	 * Text
	 */
	private String text;

	/**
	 * Weight
	 */
	private int weight;

	/**
	 * Default constructor
	 */
	public Category() {
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
	 * Gets the weight.
	 * 
	 * @return Weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Sets the weight.
	 * 
	 * @param weight
	 *            Weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

} // Class end