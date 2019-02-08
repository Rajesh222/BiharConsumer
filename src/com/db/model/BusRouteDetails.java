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
	private List<Integer> amenities = new ArrayList<>();
	private List<BusType> bustypes = new ArrayList<>();
	private List<Double> fares = new ArrayList<>();
	private List<BusRating> rating = new ArrayList<>();
	private boolean inclTaxes = true;
	private String classType;
	private String operatorId;  
	private String providerId;  
	private String travelsName;
	private String busType;
	private double duration;
	private int travelDurationDays;
	private boolean idProofRequired = false;
	private boolean isAc = false;
	private boolean isSleeper = false;
	private String layoutType;
	private boolean isSeater = true;
	private boolean isRefundable= false;
	private String routId;
	private double totalSeats;
	private double avalableSeats;
	private double distance; 
	private String arrivalDate;
	private String arrivalTime;
	private String departureDate;
	private String departureTime;
	private String seatType; 
	private String source; 
	private String destination;
	public List<BusBoadingStopingDetails> getBoardingLocations() {
		return boardingLocations;
	}
	public void setBoardingLocations(List<BusBoadingStopingDetails> boardingLocations) {
		this.boardingLocations = boardingLocations;
	}
	public List<BusBoadingStopingDetails> getDroppingLocations() {
		return droppingLocations;
	}
	public void setDroppingLocations(List<BusBoadingStopingDetails> droppingLocations) {
		this.droppingLocations = droppingLocations;
	}
	public List<BusDetails> getBusInfo() {
		return busInfo;
	}
	public void setBusInfo(List<BusDetails> busInfo) {
		this.busInfo = busInfo;
	}
	public List<BusCancellationPolicies> getCancellationPolicy() {
		return cancellationPolicy;
	}
	public void setCancellationPolicy(List<BusCancellationPolicies> cancellationPolicy) {
		this.cancellationPolicy = cancellationPolicy;
	}
	public List<Integer> getAmenities() {
		return amenities;
	}
	public void setAmenities(List<Integer> amenities) {
		this.amenities = amenities;
	}
	public List<BusType> getBustypes() {
		return bustypes;
	}
	public void setBustypes(List<BusType> bustypes) {
		this.bustypes = bustypes;
	}
	public List<Double> getFares() {
		return fares;
	}
	public void setFares(List<Double> fares) {
		this.fares = fares;
	}
	public List<BusRating> getRating() {
		return rating;
	}
	public void setRating(List<BusRating> rating) {
		this.rating = rating;
	}
	public boolean isInclTaxes() {
		return inclTaxes;
	}
	public void setInclTaxes(boolean inclTaxes) {
		this.inclTaxes = inclTaxes;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public String getTravelsName() {
		return travelsName;
	}
	public void setTravelsName(String travelsName) {
		this.travelsName = travelsName;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public int getTravelDurationDays() {
		return travelDurationDays;
	}
	public void setTravelDurationDays(int travelDurationDays) {
		this.travelDurationDays = travelDurationDays;
	}
	public boolean isIdProofRequired() {
		return idProofRequired;
	}
	public void setIdProofRequired(boolean idProofRequired) {
		this.idProofRequired = idProofRequired;
	}
	public boolean isAc() {
		return isAc;
	}
	public void setAc(boolean isAc) {
		this.isAc = isAc;
	}
	public boolean isSleeper() {
		return isSleeper;
	}
	public void setSleeper(boolean isSleeper) {
		this.isSleeper = isSleeper;
	}
	public String getLayoutType() {
		return layoutType;
	}
	public void setLayoutType(String layoutType) {
		this.layoutType = layoutType;
	}
	public boolean isSeater() {
		return isSeater;
	}
	public void setSeater(boolean isSeater) {
		this.isSeater = isSeater;
	}
	public boolean isRefundable() {
		return isRefundable;
	}
	public void setRefundable(boolean isRefundable) {
		this.isRefundable = isRefundable;
	}
	public String getRoutId() {
		return routId;
	}
	public void setRoutId(String routId) {
		this.routId = routId;
	}
	public double getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(double totalSeats) {
		this.totalSeats = totalSeats;
	}
	public double getAvalableSeats() {
		return avalableSeats;
	}
	public void setAvalableSeats(double avalableSeats) {
		this.avalableSeats = avalableSeats;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getSeatType() {
		return seatType;
	}
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	} 
}
