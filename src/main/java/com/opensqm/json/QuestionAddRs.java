package com.opensqm.json;

/**
 * Question add response message.
 *
 */
public class QuestionAddRs extends ResponseMessage {

	/**
	 * Question ID
	 */
	private String questionId;

	/**
	 * Default constructor.
	 */
	public QuestionAddRs() {
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

} // Class end