package com.opensqm.json;

public class Choice {

	private String id;
	private String text;
	private boolean correctAnswer;
	
	/**
	 * Default constructor
	 */
	public Choice() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
} // Class end
