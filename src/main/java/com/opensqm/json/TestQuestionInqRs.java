package com.opensqm.json;

public class TestQuestionInqRs extends ResponseMessage {
	
	/**
	 * Question
	 */
	private Question question;

	/**
	 * Default constructor
	 */
	public TestQuestionInqRs() {
	}

	/**
	 * Gets the question.
	 * @return Question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * Sets the question.
	 * @param question Question
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

} // Class end