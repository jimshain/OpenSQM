package com.opensqm.json;

/**
 * Response message base object.
 *
 */
public class ResponseMessage {

	/**
	 * Response header
	 */
	private ResponseHeader responseHeader;

	/**
	 * Status
	 */
	private Status status;

	/**
	 * Default constructor
	 */
	public ResponseMessage() {
	}

	/**
	 * Gets the response header.
	 * 
	 * @return Response header
	 */
	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	/**
	 * Sets the response header.
	 * 
	 * @param responseHeader
	 *            Response header
	 */
	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
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
	 * Sets the status.
	 * 
	 * @param status
	 *            Status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

} // Class end