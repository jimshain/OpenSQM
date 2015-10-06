package com.opensqm.ws.controller;

import com.opensqm.json.Status;

public class StatusException extends Exception {

	/**
	 * Serial version ID
	 */
	private static final long serialVersionUID = 1215645557342225616L;

	/**
	 * Status
	 */
	private Status status;

	public StatusException(String code, String description) {
		status = new Status();
		status.setCode(code);
		status.setDescription(description);
	}

	/**
	 * Gets the status.
	 * 
	 * @return Status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Sets the status
	 * 
	 * @param status
	 *            Status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

} // Class end
