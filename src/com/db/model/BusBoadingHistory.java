package com.db.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="bus_rout_details")
public class BusBoadingHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name ="system_id",nullable = false, unique= true)
	private String id;
	@Column(name = "base_fare")
	private double baseFare;
	@Column(name = "service_tax")
	private double serviceTax;
	@Column(name = "total_fare")
	private double totalFare;
	@Column(name ="orderBy")
	private double order;
	@Column(name = "source_name")
	private String source;
	@Column(name = "destination_name")
	private String destination;
	@Column(name ="doj")
	@Temporal(TemporalType.TIMESTAMP)
	private Date doj;
	@Column(name = "arrival_date")
	private String arrivalDate;
	@Column(name = "arrival_time")
	private String arrivalTime;
	@Column(name = "departure_date")
	private String departureDate;
	@Column(name = "departure_time")
	private String departureTime;
	@Column(name = "distance")
	private String distance;
	@Column(name = "duration")
	private String duration;
	@Column(name ="bus_number")
	private String busNo;
	@Column(name ="createdOn")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn = new Date();
	@Column(name ="createdBy")
	private String createdBy;
	@Column(name ="modifyOn")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyOn = new Date();
	@Column(name ="modifyBy")
	private String modifyBy;
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
	 * @return the baseFare
	 */
	public double getBaseFare() {
		return baseFare;
	}
	/**
	 * @param baseFare the baseFare to set
	 */
	public void setBaseFare(double baseFare) {
		this.baseFare = baseFare;
	}
	/**
	 * @return the serviceTax
	 */
	public double getServiceTax() {
		return serviceTax;
	}
	/**
	 * @param serviceTax the serviceTax to set
	 */
	public void setServiceTax(double serviceTax) {
		this.serviceTax = serviceTax;
	}
	/**
	 * @return the totalFare
	 */
	public double getTotalFare() {
		return totalFare;
	}
	/**
	 * @param totalFare the totalFare to set
	 */
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
	/**
	 * @return the order
	 */
	public double getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(double order) {
		this.order = order;
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
	 * @return the doj
	 */
	public Date getDoj() {
		return doj;
	}
	/**
	 * @param doj the doj to set
	 */
	public void setDoj(Date doj) {
		this.doj = doj;
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
	 * @return the distance
	 */
	public String getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(String distance) {
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
	 * @return the busNo
	 */
	public String getBusNo() {
		return busNo;
	}
	/**
	 * @param busNo the busNo to set
	 */
	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}
	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}
	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the modifyOn
	 */
	public Date getModifyOn() {
		return modifyOn;
	}
	/**
	 * @param modifyOn the modifyOn to set
	 */
	public void setModifyOn(Date modifyOn) {
		this.modifyOn = modifyOn;
	}
	/**
	 * @return the modifyBy
	 */
	public String getModifyBy() {
		return modifyBy;
	}
	/**
	 * @param modifyBy the modifyBy to set
	 */
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	
}
