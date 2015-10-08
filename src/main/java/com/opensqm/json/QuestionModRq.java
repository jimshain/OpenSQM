package com.opensqm.json;

/**
 * Question modify request message.
 * 
 * @author Jim Shain
 *
 */
public class QuestionModRq extends RequestMessage {

	/**
	 * Question
	 */
	private Question question;

	/**
	 * Default constructor
	 */
	public QuestionModRq() {
	}

	/**
	 * Gets the question.
	 * 
	 * @return Question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * Sets the question.
	 * 
	 * @param question
	 *            Question
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

} // Class end
