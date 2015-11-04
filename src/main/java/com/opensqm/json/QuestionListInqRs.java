package com.opensqm.json;

/**
 * Question list inquiry response message.
 * 
 * @author Jim Shain
 *
 */
public class QuestionListInqRs extends ResponseMessage {

	/**
	 * Question list
	 */
	private QuestionListItem[] questionList;

	/**
	 * Default constructor
	 */
	public QuestionListInqRs() {
	}

	/**
	 * Gets the question list.
	 * 
	 * @return Question list
	 */
	public QuestionListItem[] getQuestionList() {
		return questionList;
	}

	/**
	 * Sets the question list.
	 * 
	 * @param questionList
	 *            Question list
	 */
	public void setQuestionList(QuestionListItem[] questionList) {
		this.questionList = questionList;
	}

} // Class end