package com.opensqm.web.json;

public class QuestionAddForm {
	
	private String text;
	private String categoryId;
	private String choices[];
	private String active;
	
	public QuestionAddForm() {}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String[] getChoices() {
		return choices;
	}

	public void setChoices(String[] choices) {
		this.choices = choices;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
} // Class end
