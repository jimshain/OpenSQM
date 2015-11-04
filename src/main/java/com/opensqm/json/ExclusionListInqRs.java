package com.opensqm.json;

/**
 * Exclusion list inquiry response message.
 * 
 * @author Jim Shain
 *
 */
public class ExclusionListInqRs extends ResponseMessage {

	/**
	 * Exclusions
	 */
	private Exclusion[] exclusions;

	/**
	 * Default constructor.
	 */
	public ExclusionListInqRs() {
	}

	/**
	 * Gets the exclusion list.
	 * 
	 * @return Exclusion list
	 */
	public Exclusion[] getExclusions() {
		return exclusions;
	}

	/**
	 * Sets the exclusion list.
	 * 
	 * @param exclusions
	 *            Exclusion list
	 */
	public void setExclusions(Exclusion[] exclusions) {
		this.exclusions = exclusions;
	}

} // Class end