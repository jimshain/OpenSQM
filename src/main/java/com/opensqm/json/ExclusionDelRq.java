package com.opensqm.json;

/**
 * Exclusion delete request message.
 * 
 * @author Jim Shain
 *
 */
public class ExclusionDelRq extends RequestMessage {

	/**
	 * Exclusion ID
	 */
	private String exclusionId;

	/**
	 * Default constructor
	 */
	public ExclusionDelRq() {
	}

	/**
	 * Gets the exclusion ID.
	 * 
	 * @return Exclusion ID
	 */
	public String getExclusionId() {
		return exclusionId;
	}

	/**
	 * Sets the exclusion ID.
	 * 
	 * @param exclusionId
	 *            Exclusion ID
	 */
	public void setExclusionId(String exclusionId) {
		this.exclusionId = exclusionId;
	}

} // Class end