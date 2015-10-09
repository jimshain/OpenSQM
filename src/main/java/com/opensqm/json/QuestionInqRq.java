package com.opensqm.json;

/**
 * Question inquiry request message.
 * 
 * @author Jim Shain
 *
 */
public class QuestionInqRq extends RequestMessage {

	/**
	 * Question ID
	 */
	private String questionId;

	/**
	 * Default constructor.
	 */
	public QuestionInqRq() {
	}

	/**
	 * Gets the question ID.
	 * 
	 * @return Question ID
	 */
	public String getQuestionId() {
		return questionId;
	}

	/**
	 * Sets the question ID.
	 * 
	 * @param questionId
	 *            Question ID
	 */
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

} // Class end