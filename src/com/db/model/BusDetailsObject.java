package com.db.model;

import java.util.ArrayList;
import java.util.List;

public class BusDetailsObject {
	
	private List<BusRouteDetails> filterRouteList = new ArrayList<>();
	private List<String> departureTimeList = new ArrayList<>();
	private List<String> arrivalTimeList = new ArrayList<>();
	private List<BusAmenity> amenitiesList = new ArrayList<>();
	
	/**
	 * @return the filterRouteList
	 */
	public List<BusRouteDetails> getFilterRouteList() {
		return filterRouteList;
	}
	/**
	 * @param filterRouteList the filterRouteList to set
	 */
	public void setFilterRouteList(List<BusRouteDetails> filterRouteList) {
		this.filterRouteList = filterRouteList;
	}
	/**
	 * @return the departureTimeList
	 */
	public List<String> getDepartureTimeList() {
		return departureTimeList;
	}
	/**
	 * @param departureTimeList the departureTimeList to set
	 */
	public void setDepartureTimeList(List<String> departureTimeList) {
		this.departureTimeList = departureTimeList;
	}
	/**
	 * @return the arrivalTimeList
	 */
	public List<String> getArrivalTimeList() {
		return arrivalTimeList;
	}
	/**
	 * @param arrivalTimeList the arrivalTimeList to set
	 */
	public void setArrivalTimeList(List<String> arrivalTimeList) {
		this.arrivalTimeList = arrivalTimeList;
	}
	/**
	 * @return the amenitiesList
	 */
	public List<BusAmenity> getAmenitiesList() {
		return amenitiesList;
	}
	/**
	 * @param amenitiesList the amenitiesList to set
	 */
	public void setAmenityList(List<BusAmenity> amenitiesList) {
		this.amenitiesList = amenitiesList;
	}
	
}
