package com.opensqm.json;

/**
 * Exclusion
 * 
 * @author Jim Shain
 *
 */
public class Exclusion {

	/**
	 * ID
	 */
	private String id;

	/**
	 * Exclusion type 01 - Day, 02 - Date, 03 - Time Only
	 */
	private String type;

	/**
	 * Exclusion value For type 01: SUN, MON, TUE, WED, THU, FRI, SAT; For type
	 * 02: MM/DD/YYYY; For type 03: null
	 */
	private String value;

	/**
	 * Exclusion start time. HH:MM
	 */
	private String startTime;

	/**
	 * Exclusion end time. HH:MM
	 */
	private String endTime;

	/**
	 * Default constructor.
	 */
	public Exclusion() {
	}

	/**
	 * Gets the ID.
	 * 
	 * @return ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the ID.
	 * 
	 * @param id
	 *            ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the type.
	 * 
	 * @return Type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 * 
	 * @param type
	 *            Type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the value.
	 * 
	 * @return Value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 * 
	 * @param value
	 *            Value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets the start time.
	 * 
	 * @return Start time
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