package com.db.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BusRouteDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<BusBoadingStopingDetails> boardingLocations = new ArrayList<>();
	private List<BusBoadingStopingDetails> droppingLocations = new ArrayList<>();
	private List<BusDetails> busInfo = new ArrayList<>();
	private List<BusCancellationPolicies> cancellationPolicy = new ArrayList<>();
	private List<String> routeAmenitiesList = new ArrayList<>();
	private List<BusType> bustypes = new ArrayList<>();
	private List<Double> fare = new ArrayList<>();
	private boolean inclTaxes = true;
	private String classType;
	private String busId;  //
	private String travelsName;//
	private String busType;//
	private double duration;//
	private boolean idProofRequired = false;
	private boolean isAc = false;//
	private boolean isSleaper = false;//
	private boolean isSeater = true;
	private boolean isRefundable= false;//
	private double rating;//
	private String routId;
	private double totalSeats;//
	private double avalableSeats;
	private double distance; //
	private String arrivalDate;//
	private String arrivalTime;//
	private String departureDate;//
	private String departureTime;//
	private String seatType; 
	private String source; //
	private String destination; //
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
	 * @return the routeAmenitiesList
	 */
	public List<String> getRouteAmenitiesList() {
		return routeAmenitiesList;
	}
	/**
	 * @param routeAmenitiesList the routeAmenitiesList to set
	 */
	public void setRouteAmenitiesList(List<String> routeAmenitiesList) {
		this.routeAmenitiesList = routeAmenitiesList;
	}
	/**
	 * @return the busTypes
	 */
	public List<BusType> getBusTypes() {
		return bustypes;
	}
	/**
	 * @param busTypes the busTypes to set
	 */
	public void setBusTypes(List<BusType> busTypes) {
		this.bustypes = busTypes;
	}
	/**
	 * @return the fare
	 */
	public List<Double> getFare() {
		return fare;
	}
	/**
	 * @param fare the fare to set
	 */
	public void setFare(List<Double> fare) {
		this.fare = fare;
	}
	/**
	 * @return the inclTaxes
	 */
	public boolean isInclTaxes() {
		return inclTaxes;
	}
	/**
	 * @param inclTaxes the inclTaxes to set
	 */
	public void setInclTaxes(boolean inclTaxes) {
		this.inclTaxes = inclTaxes;
	}
	/**
	 * @return the classType
	 */
	public String getClassType() {
		return classType;
	}
	/**
	 * @param classType the classType to set
	 */
	public void setClassType(String classType) {
		this.classType = classType;
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
	public double getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(double duration) {
		this.duration = duration;
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
	 * @return the isSeater
	 */
	public boolean isSeater() {
		return isSeater;
	}
	/**
	 * @param isSeater the isSeater to set
	 */
	public void setSeater(boolean isSeater) {
		this.isSeater = isSeater;
	}
	/**
	 * @return the isRefundable
	 */
	public boolean isRefundable() {
		return isRefundable;
	}
	/**
	 * @param isRefundable the isRefundable to set
	 */
	public void setRefundable(boolean isRefundable) {
		this.isRefundable = isRefundable;
	}
	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
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
}