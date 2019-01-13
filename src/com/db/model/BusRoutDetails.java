package com.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BusRoutDetails extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private String routId;
	private String userId;
	private String travelsName;
	private String busNumber;
	private double availableSeats;
	private double totalSeats;
	private String busType;
	private String direction;
	private Date traveldate;
	private String tripId;
	private double basefare;
	private double servicetax;
	private double totalfare;
	private String srcCityName;
	private String destCityName;
	private int travelDurationDays;
	private Date arrivalDate;
	private Date departureDate;
	private double distance;
	private String duration;
	private List<BusStopLocationDetails> boardingLocations;
	private List<BusStopLocationDetails> droppingLocations;

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
	 * @return the traveldate
	 */
	public Date getTraveldate() {
		return traveldate;
	}

	/**
	 * @param traveldate the traveldate to set
	 */
	public void setTraveldate(Date traveldate) {
		this.traveldate = traveldate;
	}


	/**
	 * @return the tripId
	 */
	public String getTripId() {
		return tripId;
	}

	/**
	 * @param tripId the tripId to set
	 */
	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	/**
	 * @return the basefare
	 */
	public double getBasefare() {
		return basefare;
	}

	/**
	 * @param basefare the basefare to set
	 */
	public void setBasefare(double basefare) {
		this.basefare = basefare;
	}

	/**
	 * @return the servicetax
	 */
	public double getServicetax() {
		return servicetax;
	}

	/**
	 * @param servicetax the servicetax to set
	 */
	public void setServicetax(double servicetax) {
		this.servicetax = servicetax;
	}

	/**
	 * @return the totalfare
	 */
	public double getTotalfare() {
		return totalfare;
	}

	/**
	 * @param totalfare the totalfare to set
	 */
	public void setTotalfare(double totalfare) {
		this.totalfare = totalfare;
	}

	/**
	 * @return the travelDurationDays
	 */
	public int getTravelDurationDays() {
		return travelDurationDays;
	}

	/**
	 * @param travelDurationDays the travelDurationDays to set
	 */
	public void setTravelDurationDays(int travelDurationDays) {
		this.travelDurationDays = travelDurationDays;
	}

	/**
	 * @return the arrivalDate
	 */
	public Date getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * @param arrivalDate the arrivalDate to set
	 */
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * @return the departureDate
	 */
	public Date getDepartureDate() {
		return departureDate;
	}

	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * @return the boardingLocations
	 */
	public List<BusStopLocationDetails> getBoardingLocations() {
		return boardingLocations;
	}

	/**
	 * @param boardingLocations the boardingLocations to set
	 */
	public void setBoardingLocations(List<BusStopLocationDetails> boardingLocations) {
		this.boardingLocations = boardingLocations;
	}

	/**
	 * @return the droppingLocations
	 */
	public List<BusStopLocationDetails> getDroppingLocations() {
		return droppingLocations;
	}

	/**
	 * @param droppingLocations the droppingLocations to set
	 */
	public void setDroppingLocations(List<BusStopLocationDetails> droppingLocations) {
		this.droppingLocations = droppingLocations;
	}

}
