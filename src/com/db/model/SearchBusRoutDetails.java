package com.db.model;

import java.util.List;

import com.db.utils.DataUtils;

public class SearchBusRoutDetails {

	private List<BusRoutDetails> searchResult;
	private List<BusStopLocationDetails> boardingLocations;
	private List<BusStopLocationDetails> droppingLocations;
	private List<String> busType = DataUtils.getBusType();
	/**
	 * @return the searchResult
	 */
	public List<BusRoutDetails> getSearchResult() {
		return searchResult;
	}
	/**
	 * @param searchResult the searchResult to set
	 */
	public void setSearchResult(List<BusRoutDetails> searchResult) {
		this.searchResult = searchResult;
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
	/**
	 * @return the busType
	 */
	public List<String> getBusType() {
		return busType;
	}
	/**
	 * @param busType the busType to set
	 */
	public void setBusType(List<String> busType) {
		this.busType = busType;
	}
	
}
