package com.opensqm.json;

/**
 * Request message base object.
 *
 */
public class RequestMessage {
	
	/**
	 * Request header
	 */
	private RequestHeader requestHeader;
	
	/**
	 * Default constructor
	 */
	public RequestMessage() {}

	/**
	 * Gets the request header.
	 * @return Request header
	 */
	public RequestHeader getRequestHeader() {
		return requestHeader;
	}

	/**
	 * Sets the request header.
	 * @param requestHeader Request header
	 */
	public void setRequestHeader(RequestHeader requestHeader) {
		this.requestHeader = requestHeader;
	}
	
} // Class end