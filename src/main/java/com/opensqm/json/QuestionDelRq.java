package com.opensqm.json;

/**
 * Question delete request message.
 * 
 * @author Jim Shain
 *
 */
public class QuestionDelRq extends RequestMessage {

	/**
	 * Question ID
	 */
	private String questionId;

	/**
	 * Default constructor.
	 */
	public QuestionDelRq() {
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