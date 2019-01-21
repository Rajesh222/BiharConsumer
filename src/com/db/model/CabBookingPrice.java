package com.db.model;

public class CabBookingPrice {
	private String id;
	private String kilometer;
	private double farerate;
	private String city;
	private String state;
	private String country;
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
	 * @return the kilometer
	 */
	public String getKilometer() {
		return kilometer;
	}
	/**
	 * @param kilometer the kilometer to set
	 */
	public void setKilometer(String kilometer) {
		this.kilometer = kilometer;
	}
	/**
	 * @return the farerate
	 */
	public double getFarerate() {
		return farerate;
	}
	/**
	 * @param farerate the farerate to set
	 */
	public void setFarerate(double farerate) {
		this.farerate = farerate;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
}
