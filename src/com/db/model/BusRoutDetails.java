package com.db.model;

import java.io.Serializable;
import java.util.List;

public class BusRoutDetails extends BaseModel implements Serializable{

	private static final long serialVersionUID = 1L;
	private String routId;
	private String userId;
	private String travelsName;
	private String sourceName;
	private String srcCityName;
	private String destCityName;
	private String destinationName;
	private String busNumber;
	private double availableSeats;
	private double totalSeats;
	private String busType;
	private String direction;
	private String journeyDate;
	private List<BusBoadStopDetails> boardingLocations;
	private List<BusBoadStopDetails> droppingLocations;
	/**
	 * @return the routId
	 */
	public String getRoutId() {
		return routId;
	}
	/**
	 * @param routId the routId to set
	 */
	public void setRoutId(String routId) {
		this.routId = routId;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the travelsName
	 */
	public String getTravelsName() {
		return travelsName;
	}
	/**
	 * @param travelsName the travelsName to set
	 */
	public void setTravelsName(String travelsName) {
		this.travelsName = travelsName;
	}
	/**
	 * @return the sourceName
	 */
	public String getSourceName() {
		return sourceName;
	}
	/**
	 * @param sourceName the sourceName to set
	 */
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	/**
	 * @return the srcCityName
	 */
	public String getSrcCityName() {
		return srcCityName;
	}
	/**
	 * @param srcCityName the srcCityName to set
	 */
	public void setSrcCityName(String srcCityName) {
		this.srcCityName = srcCityName;
	}
	/**
	 * @return the destCityName
	 */
	public String getDestCityName() {
		return destCityName;
	}
	/**
	 * @param destCityName the destCityName to set
	 */
	public void setDestCityName(String destCityName) {
		this.destCityName = destCityName;
	}
	/**
	 * @return the destinationName
	 */
	public String getDestinationName() {
		return destinationName;
	}
	/**
	 * @param destinationName the destinationName to set
	 */
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	/**
	 * @return the busNumber
	 */
	public String getBusNumber() {
		return busNumber;
	}
	/**
	 * @param busNumber the busNumber to set
	 */
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	/**
	 * @return the availableSeats
	 */
	public double getAvailableSeats() {
		return availableSeats;
	}
	/**
	 * @param availableSeats the availableSeats to set
	 */
	public void setAvailableSeats(double availableSeats) {
		this.availableSeats = availableSeats;
	}
	/**
	 * @return the totalSeats
	 */
	public double getTotalSeats() {
		return totalSeats;
	}
	/**
	 * @param totalSeats the totalSeats to set
	 */
	public void setTotalSeats(double totalSeats) {
		this.totalSeats = totalSeats;
	}
	/**
	 * @return the busType
	 */
	public String getBusType() {
		return busType;
	}
	/**
	 * @param busType the busType to set
	 */
	public void setBusType(String busType) {
		this.busType = busType;
	}
	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}
	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}
	/**
	 * @return the journeyDate
	 */
	public String getJourneyDate() {
		return journeyDate;
	}
	/**
	 * @param journeyDate the journeyDate to set
	 */
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	/**
	 * @return the boardingLocations
	 */
	public List<BusBoadStopDetails> getBoardingLocations() {
		return boardingLocations;
	}
	/**
	 * @param boardingLocations the boardingLocations to set
	 */
	public void setBoardingLocations(List<BusBoadStopDetails> boardingLocations) {
		this.boardingLocations = boardingLocations;
	}
	/**
	 * @return the droppingLocations
	 */
	public List<BusBoadStopDetails> getDroppingLocations() {
		return droppingLocations;
	}
	/**
	 * @param droppingLocations the droppingLocations to set
	 */
	public void setDroppingLocations(List<BusBoadStopDetails> droppingLocations) {
		this.droppingLocations = droppingLocations;
	}
}
