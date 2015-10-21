package com.opensqm.json;

/**
 * Exclusion add response message.
 * 
 * @author Jim Shain
 *
 */
public class ExclusionAddRs extends ResponseMessage {

	/**
	 * Exclusion ID
	 */
	private String exclusionId;

	/**
	 * Default constructor
	 */
	public ExclusionAddRs() {
	}

	public String getExclusionId() {
		return exclusionId;
	}

	public void setExclusionId(String exclusionId) {
		this.exclusionId = exclusionId;
	}

} // Class end