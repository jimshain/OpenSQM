package com.opensqm.json;

/**
 * Choice
 * 
 * @author Jim Shain
 *
 */
public class Choice {

	/**
	 * ID
	 */
	private String id;

	/**
	 * Text
	 */
	private String text;

	/**
	 * Correct answer
	 */
	private boolean correctAnswer;

	/**
	 * Default constructor
	 */
	public Choice() {
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
	 * Gets the correct answer.
	 * 
	 * @return Correct answer
	 */
	public boolean isCorrectAnswer() {
		return correctAnswer;
	}

	/**
	 * Sets the correct answer.
	 * 
	 * @param correctAnswer
	 *            Correct answer.
	 */
	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

} // Class end