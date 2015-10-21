package com.opensqm.json;

/**
 * Exclusion add request message.
 * 
 * @author Jim Shain
 *
 */
public class ExclusionAddRq extends RequestMessage {

	/**
	 * Exclusion
	 */
	private Exclusion exclusion;

	/**
	 * Default constructor
	 */
	public ExclusionAddRq() {
	}

	/**
	 * Gets the exclusion.
	 * 
	 * @return Exclusion
	 */
	public Exclusion getExclusion() {
		return exclusion;
	}

	/**
	 * Sets the exclusion.
	 * 
	 * @param exclusion
	 *            Exclusion
	 */
	public void setExclusion(Exclusion exclusion) {
		this.exclusion = exclusion;
	}

} // Class end