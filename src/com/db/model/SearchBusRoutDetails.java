package com.db.model;

import java.util.List;

public class SearchBusRoutDetails {

	private List<BusRoutDetails> buses;
	private List<BusType> busType;
	private List<String> operatorNames;
	/**
	 * @return the buses
	 */
	public List<BusRoutDetails> getBuses() {
		return buses;
	}
	/**
	 * @param buses the buses to set
	 */
	public void setBuses(List<BusRoutDetails> buses) {
		this.buses = buses;
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
	/**
	 * @return the operatorNames
	 */
	public List<String> getOperatorNames() {
		return operatorNames;
	}
	/**
	 * @param operatorNames the operatorNames to set
	 */
	public void setOperatorNames(List<String> operatorNames) {
		this.operatorNames = operatorNames;
	}
}
