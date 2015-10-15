package com.opensqm.web.json;

/**
 * Category modify form java object.
 * 
 * @author Jim Shain
 *
 */
public class CategoryModForm {

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
	private String weight;

	/**
	 * Default constructor
	 */
	public CategoryModForm() {
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
	public String getWeight() {
		return weight;
	}

	/**
	 * Sets the weight.
	 * 
	 * @param weight
	 *            Weight
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}

} // Class end