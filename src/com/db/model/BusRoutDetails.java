package com.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BusRoutDetails extends BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private String routId;
	private String travelsName;
	private String busNumber;
	private double avalableSeats;
	private double totalSeats;
	private String busType;
	private String direction;
	private Date traveldate;
	private String tripId;
	private double basefare;
	private double servicetax;
	private double totalfare;
	private String srcCityName;
	private String source;
	private String destination;
	private String destCityName;
	private int travelDurationDays;
	private Date arrivalDate;
	private Date departureDate;
	private String departureTime;
	private String boardingTime;
	private String reportingTime;
	private double distance;
	private String duration;
	private String busTypeTags;
	private String sourceId;
	private String destinationId;
	private List<BusStopLocationDetails> boardingPoints;
	private List<BusStopLocationDetails> droppingPoints;
	private List<BusCancellationPolicies> cancellationPolicy;
	private List<String> amenities;
	private List<BusType> busTypes;
	
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
	 * @return the busTypeTags
	 */
	public String getBusTypeTags() {
		return busTypeTags;
	}
	/**
	 * @param busTypeTags the busTypeTags to set
	 */
	public void setBusTypeTags(String busTypeTags) {
		this.busTypeTags = busTypeTags;
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
	 * @return the boardingPoints
	 */
	public List<BusStopLocationDetails> getBoardingPoints() {
		return boardingPoints;
	}
	/**
	 * @param boardingPoints the boardingPoints to set
	 */
	public void setBoardingPoints(List<BusStopLocationDetails> boardingPoints) {
		this.boardingPoints = boardingPoints;
	}
	/**
	 * @return the droppingPoints
	 */
	public List<BusStopLocationDetails> getDroppingPoints() {
		return droppingPoints;
	}
	/**
	 * @param droppingPoints the droppingPoints to set
	 */
	public void setDroppingPoints(List<BusStopLocationDetails> droppingPoints) {
		this.droppingPoints = droppingPoints;
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
	
}
