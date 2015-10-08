package com.opensqm.json;

/**
 * Question inquiry response message.
 * 
 * @author Jim Shain
 *
 */
public class QuestionInqRs extends ResponseMessage {

	/**
	 * Questions
	 */
	private Question[] questions;

	/**
	 * Default constructor.
	 */
	public QuestionInqRs() {
	}

	/**
	 * Gets the questions.
	 * 
	 * @return Questions
	 */
	public Question[] getQuestions() {
		return questions;
	}

	/**
	 * Sets the questions.
	 * 
	 * @param questions
	 *            Questions
	 */
	public void setQuestions(Question[] questions) {
		this.questions = questions;
	}

} // Class end
