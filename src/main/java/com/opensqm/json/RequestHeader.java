package com.opensqm.json;

public class RequestHeader {

	/**
	 * Request ID
	 */
	private String rquid;

	/**
	 * Location
	 */
	private String location;
	
	/**
	 * User ID
	 */
	private String userId;

	/**
	 * Default constructor
	 */
	public RequestHeader() {
	}

	public String getRquid() {
		return rquid;
	}

	public void setRquid(String rquid) {
		this.rquid = rquid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

} // Class end
