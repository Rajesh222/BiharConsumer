package com.db.model;

import java.util.List;

public class SearchBusRoutDetails {

	private List<BusRoutDetails> searchResult;
	private List<BusType> busType;
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
	 * @return the busType
	 */
	public List<BusType> getBusType() {
		return busType;
	}
	/**
	 * @param busType the busType to set
	 */
	public void setBusType(List<BusType> busType) {
		this.busType = busType;
	}
	

}
