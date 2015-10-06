package com.opensqm.json;

public class QuestionAddRq extends RequestMessage {

	/**
	 * Question
	 */
	private Question question;

	/**
	 * Default constructor
	 */
	public QuestionAddRq() {
	}

	/**
	 * Gets the question
	 * 
	 * @return Question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * Sets the question
	 * 
	 * @param question
	 *            Question
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

} // Class end