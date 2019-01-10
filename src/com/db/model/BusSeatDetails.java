package com.db.model;

import java.io.Serializable;
import java.util.List;

public class BusSeatDetails extends BaseModel implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String seatNumber;
	private String seatName;
	private String seatCode;
	private boolean isAvailable;
	private boolean isLadiesSeat;
	private boolean isLowerBerth;
	private double fare;
	private List droppingPoints;
	private List boardingPoints;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the seatNumber
	 */
	public String getSeatNumber() {
		return seatNumber;
	}
	/**
	 * @param seatNumber the seatNumber to set
	 */
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	/**
	 * @return the seatName
	 */
	public String getSeatName() {
		return seatName;
	}
	/**
	 * @param seatName the seatName to set
	 */
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	/**
	 * @return the seatCode
	 */
	public String getSeatCode() {
		return seatCode;
	}
	/**
	 * @param seatCode the seatCode to set
	 */
	public void setSeatCode(String seatCode) {
		this.seatCode = seatCode;
	}
	/**
	 * @return the isAvailable
	 */
	public boolean isAvailable() {
		return isAvailable;
	}
	/**
	 * @param isAvailable the isAvailable to set
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	/**
	 * @return the isLadiesSeat
	 */
	public boolean isLadiesSeat() {
		return isLadiesSeat;
	}
	/**
	 * @param isLadiesSeat the isLadiesSeat to set
	 */
	public void setLadiesSeat(boolean isLadiesSeat) {
		this.isLadiesSeat = isLadiesSeat;
	}
	/**
	 * @return the isLowerBerth
	 */
	public boolean isLowerBerth() {
		return isLowerBerth;
	}
	/**
	 * @param isLowerBerth the isLowerBerth to set
	 */
	public void setLowerBerth(boolean isLowerBerth) {
		this.isLowerBerth = isLowerBerth;
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
	
}
