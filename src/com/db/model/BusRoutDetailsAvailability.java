package com.db.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BusRoutDetailsAvailability extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<BusBoadingStopingDetails> boardingLocations = new ArrayList<>();
	private List<BusBoadingStopingDetails> droppingLocations = new ArrayList<>();
	private List<BusDetails> busInfo = new ArrayList<>();
	private List<BusCancellationPolicies> cancellationPolicy = new ArrayList<>();
	private List<String> amenities = new ArrayList<>();
	private List<BusType> busTypes = new ArrayList<>();
	//private List<String> fares = new ArrayList<>();
	private String busId;
	private String travelsName;
	private String busType;
	private String duration;
	private double fare;
	private boolean idProofRequired;
	private boolean isAc = false;
	private String rating;
	private boolean isSleaper = false;
	private String sourceId;
	private String destinationId;
	private String routId;
	private double totalSeats;
	private double avalableSeats;
	private int travelDurationDays;
	private String arrivalDate;
	private String arrivalTime;
	private String departureDate;
	private String departureTime;
	private String travelDate;
	private String seatType;
	private String boardingTime;
	private String reportingTime;
	private String source;
	private String destination;
	private String busNumber;
	/**
	 * @return the boardingLocations
	 */
	public List<BusBoadingStopingDetails> getBoardingLocations() {
		return boardingLocations;
	}
	/**
	 * @param boardingLocations the boardingLocations to set
	 */
	public void setBoardingLocations(List<BusBoadingStopingDetails> boardingLocations) {
		this.boardingLocations = boardingLocations;
	}
	/**
	 * @return the droppingLocations
	 */
	public List<BusBoadingStopingDetails> getDroppingLocations() {
		return droppingLocations;
	}
	/**
	 * @param droppingLocations the droppingLocations to set
	 */
	public void setDroppingLocations(List<BusBoadingStopingDetails> droppingLocations) {
		this.droppingLocations = droppingLocations;
	}
	/**
	 * @return the busInfo
	 */
	public List<BusDetails> getBusInfo() {
		return busInfo;
	}
	/**
	 * @param busInfo the busInfo to set
	 */
	public void setBusInfo(List<BusDetails> busInfo) {
		this.busInfo = busInfo;
	}
	/**
	 * @return the cancellationPolicy
	 */
	public List<BusCancellationPolicies> getCancellationPolicy() {
		return cancellationPolicy;
	}
	/**
	 * @param cancellationPolicy the cancellationPolicy to set
	 */
	public void setCancellationPolicy(List<BusCancellationPolicies> cancellationPolicy) {
		this.cancellationPolicy = cancellationPolicy;
	}
	/**
	 * @return the amenities
	 */
	public List<String> getAmenities() {
		return amenities;
	}
	/**
	 * @param amenities the amenities to set
	 */
	public void setAmenities(List<String> amenities) {
		this.amenities = amenities;
	}
	/**
	 * @return the busTypes
	 */
	public List<BusType> getBusTypes() {
		return busTypes;
	}
	/**
	 * @param busTypes the busTypes to set
	 */
	public void setBusTypes(List<BusType> busTypes) {
		this.busTypes = busTypes;
	}
	/**
	 * @return the busId
	 */
	public String getBusId() {
		return busId;
	}
	/**
	 * @param busId the busId to set
	 */
	public void setBusId(String busId) {
		this.busId = busId;
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
	 * @return the fare
	 */
	public double getFare() {
		return fare;
	}
	/**
	 * @param fare the fare to set
	 */
	public void setFare(double fare) {
		this.fare = fare;
	}
	/**
	 * @return the idProofRequired
	 */
	public boolean isIdProofRequired() {
		return idProofRequired;
	}
	/**
	 * @param idProofRequired the idProofRequired to set
	 */
	public void setIdProofRequired(boolean idProofRequired) {
		this.idProofRequired = idProofRequired;
	}
	/**
	 * @return the isAc
	 */
	public boolean isAc() {
		return isAc;
	}
	/**
	 * @param isAc the isAc to set
	 */
	public void setAc(boolean isAc) {
		this.isAc = isAc;
	}
	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}
	/**
	 * @return the isSleaper
	 */
	public boolean isSleaper() {
		return isSleaper;
	}
	/**
	 * @param isSleaper the isSleaper to set
	 */
	public void setSleaper(boolean isSleaper) {
		this.isSleaper = isSleaper;
	}
	/**
	 * @return the sourceId
	 */
	public String getSourceId() {
		return sourceId;
	}
	/**
	 * @param sourceId the sourceId to set
	 */
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	/**
	 * @return the destinationId
	 */
	public String getDestinationId() {
		return destinationId;
	}
	/**
	 * @param destinationId the destinationId to set
	 */
	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}
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
	 * @return the avalableSeats
	 */
	public double getAvalableSeats() {
		return avalableSeats;
	}
	/**
	 * @param avalableSeats the avalableSeats to set
	 */
	public void setAvalableSeats(double avalableSeats) {
		this.avalableSeats = avalableSeats;
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
	public String getArrivalDate() {
		return arrivalDate;
	}
	/**
	 * @param arrivalDate the arrivalDate to set
	 */
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	/**
	 * @return the arrivalTime
	 */
	public String getArrivalTime() {
		return arrivalTime;
	}
	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	/**
	 * @return the departureDate
	 */
	public String getDepartureDate() {
		return departureDate;
	}
	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	/**
	 * @return the departureTime
	 */
	public String getDepartureTime() {
		return departureTime;
	}
	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	/**
	 * @return the travelDate
	 */
	public String getTravelDate() {
		return travelDate;
	}
	/**
	 * @param travelDate the travelDate to set
	 */
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}
	/**
	 * @return the seatType
	 */
	public String getSeatType() {
		return seatType;
	}
	/**
	 * @param seatType the seatType to set
	 */
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	/**
	 * @return the boardingTime
	 */
	public String getBoardingTime() {
		return boardingTime;
	}
	/**
	 * @param boardingTime the boardingTime to set
	 */
	public void setBoardingTime(String boardingTime) {
		this.boardingTime = boardingTime;
	}
	/**
	 * @return the reportingTime
	 */
	public String getReportingTime() {
		return reportingTime;
	}
	/**
	 * @param reportingTime the reportingTime to set
	 */
	public void setReportingTime(String reportingTime) {
		this.reportingTime = reportingTime;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
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
}
