package com.opensqm.json;

public class ResponseHeader {

	/**
	 * Unique identifier
	 */
	private String rquid;

	/**
	 * Default constructor.
	 */
	public ResponseHeader() {
	}

	/**
	 * Gets the rquid.
	 * 
	 * @return RQUID
	 */
	public String getRquid() {
		return rquid;
	}

	/**
	 * Sets the rquid
	 * 
	 * @param rquid
	 *            RQUID.
	 */
	public void setRquid(String rquid) {
		this.rquid = rquid;
	}

} // Class end