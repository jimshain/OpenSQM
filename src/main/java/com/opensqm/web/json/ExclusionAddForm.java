package com.opensqm.web.json;

/**
 * Exclusion add form.
 * 
 * @author Jim Shain
 *
 */
public class ExclusionAddForm {

	/**
	 * Exclusion type
	 */
	private String exclusionType;

	/**
	 * Exclusion value
	 */
	private String exclusionValue;

	/**
	 * Start time
	 */
	private String startTime;

	/**
	 * End time
	 */
	private String endTime;

	/**
	 * Default constructor.
	 */
	public ExclusionAddForm() {
	}

	/**
	 * Gets the exclusion type.
	 * 
	 * @return Exclusion type
	 */
	public String getExclusionType() {
		return exclusionType;
	}

	/**
	 * Sets the exclusion type.
	 * 
	 * @param exclusionType
	 *            Exclusion type
	 */
	public void setExclusionType(String exclusionType) {
		this.exclusionType = exclusionType;
	}

	/**
	 * Gets the exclusion value.
	 * 
	 * @return Exclusion value
	 */
	public String getExclusionValue() {
		return exclusionValue;
	}

	/**
	 * Sets the exclusion value.
	 * 
	 * @param exclusionValue
	 *            Exclusion value
	 */
	public void setExclusionValue(String exclusionValue) {
		this.exclusionValue = exclusionValue;
	}

	/**
	 * Gets the start time.
	 * 
	 * @return Start time.
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * Sets the start time.
	 * 
	 * @param startTime
	 *            Start time
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * Gets the end time.
	 * 
	 * @return End time
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * Sets the end time.
	 * 
	 * @param endTime
	 *            End time
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

} // Class end