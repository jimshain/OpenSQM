package com.opensqm.json;

public class Status {

	/**
	 * Code
	 */
	private String code;
	
	/**
	 * Description
	 */
	private String description;

	/**
	 * Default constructor.
	 */
	public Status() {
	}

	public Status(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

} // Class end
