package com.opensqm.web.json;

/**
 * 
 * @author Jim Shain
 *
 */
public class QuestionModForm {
	
	/**
	 * Question ID
	 */
	private String questionId;
	
	/**
	 * Text
	 */
	private String text;
	
	/**
	 * Choices
	 */
	private String[] choices;
	
	/**
	 * Active
	 */
	private String activate;
	
	/**
	 * Category ID
	 */
	private String categoryId;

	/**
	 * Default constructor.
	 */
	public QuestionModForm() {
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String[] getChoices() {
		return choices;
	}

	public void setChoices(String[] choices) {
		this.choices = choices;
	}

	public String getActivate() {
		return activate;
	}

	public void setActivate(String activate) {
		this.activate = activate;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

} // Class end
