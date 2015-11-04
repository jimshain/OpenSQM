package com.opensqm.web.json;

/**
 * Question inquiry form.
 * 
 * @author Jim Shain
 *
 */
public class QuestionInqForm {

	/**
	 * Question ID
	 */
	private String questionId;

	/**
	 * Default constructor
	 */
	public QuestionInqForm() {
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