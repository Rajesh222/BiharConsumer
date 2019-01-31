package com.db.model;

import java.io.Serializable;
import java.util.Date;

public class BusBoadingStopingDetails extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private String locationId;
	private String cityId;
	private String displayName;
	private String locationName;
	private String locationAddress;
	private String landmark;
	private String dateTime;
	private double lat;
	private double lng;
	private String busid;
	private Date boardingDate;
	private Date reportingTime;
	private String contactNumber;
	
    	
	/**
	 * @return the busid
	 */
	public String getBusid() {
		return busid;
	}
	/**
	 * @param busid the busid to set
	 */
	public void setBusid(String busid) {
		this.busid = busid;
	}
	/**
	 * @return the cityId
	 */
	public String getCityId() {
		return cityId;
	}
	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	/**
	 * @return the locationId
	 */
	public String getLocationId() {
		return locationId;
	}
	/**
	 * @param locationId the locationId to set
	 */
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}
	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}
	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	/**
	 * @return the locationAddress
	 */
	public String getLocationAddress() {
		return locationAddress;
	}
	/**
	 * @param locationAddress the locationAddress to set
	 */
	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}
	/**
	 * @return the landmark
	 */
	public String getLandmark() {
		return landmark;
	}
	/**
	 * @param landmark the landmark to set
	 */
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	/**
	 * @return the dateTime
	 */
	public String getDateTime() {
		return dateTime;
	}
	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	/**
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}
	/**
	 * @param lat the lat to set
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}
	/**
	 * @return the lng
	 */
	public double getLng() {
		return lng;
	}
	/**
	 * @param lng the lng to set
	 */
	public void setLng(double lng) {
		this.lng = lng;
	}
	/**
	 * @return the boardingDate
	 */
	public Date getBoardingDate() {
		return boardingDate;
	}
	/**
	 * @param boardingDate the boardingDate to set
	 */
	public void setBoardingDate(Date boardingDate) {
		this.boardingDate = boardingDate;
	}
	/**
	 * @return the reportingTime
	 */
	public Date getReportingTime() {
		return reportingTime;
	}
	/**
	 * @param reportingTime the reportingTime to set
	 */
	public void setReportingTime(Date reportingTime) {
		this.reportingTime = reportingTime;
	}
	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}
	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
}
