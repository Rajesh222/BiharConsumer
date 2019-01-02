package com.db.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "bus_details")
public class BusRoutDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "system_id", nullable = false, unique = true)
	private String id;
	@Column(name ="user_id", nullable=false)
	private String uid;
	@Column(name = "bus_name")
	private String busName;
	@Column(name = "bus_number")
	private String busNumber;
	@Column(name ="seatavailability")
	private double seatAvailability;
	@Column(name ="totalseats")
	private double totalSeats;
	@Column(name = "bus_type")
	private String busType;
	@Column(name = "direction")
	private String direction;
	
	@Column(name = "createdOn")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn = new Date();
	@Column(name = "createdBy")
	private String createdBy;
	@Column(name = "modifyOn")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn = new Date();
	@Column(name = "modifyBy")
	private String modifiedBy;
	@Column(name = "cancellation_policy_rules", length=5000)
	private String canPolicyRules = "* Cancellation charges will be applicable on total ticket value. \n "
			+ "* Refundable amount is calculated based on scheduled bus departure time from the first boarding time."
			+ "* Partial cancellation is allowed for this ticket. Ticket cannot be cancelled after bus departure time.\n"
			+ "* Ticket cannot be cancelled after scehduled bus departure time from the first boarding point.";
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="bus_id")  
	//@OrderColumn(name="orderBy")  
	private List<BusBoadingHistory> boadingHistories;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="bus_id")  
	private List<BusSeatDetails> busSeatDetails;
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
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @return the busName
	 */
	public String getBusName() {
		return busName;
	}
	/**
	 * @param busName the busName to set
	 */
	public void setBusName(String busName) {
		this.busName = busName;
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
	 * @return the seatAvailability
	 */
	public double getSeatAvailability() {
		return seatAvailability;
	}
	/**
	 * @param seatAvailability the seatAvailability to set
	 */
	public void setSeatAvailability(double seatAvailability) {
		this.seatAvailability = seatAvailability;
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
	 * @return the modifiedOn
	 */
	public Date getModifiedOn() {
		return modifiedOn;
	}
	/**
	 * @param modifiedOn the modifiedOn to set
	 */
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}
	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	/**
	 * @return the canPolicyRules
	 */
	public String getCanPolicyRules() {
		return canPolicyRules;
	}
	/**
	 * @param canPolicyRules the canPolicyRules to set
	 */
	public void setCanPolicyRules(String canPolicyRules) {
		this.canPolicyRules = canPolicyRules;
	}
	/**
	 * @return the boadingHistories
	 */
	public List<BusBoadingHistory> getBoadingHistories() {
		return boadingHistories;
	}
	/**
	 * @param boadingHistories the boadingHistories to set
	 */
	public void setBoadingHistories(List<BusBoadingHistory> boadingHistories) {
		this.boadingHistories = boadingHistories;
	}
	/**
	 * @return the busSeatDetails
	 */
	public List<BusSeatDetails> getBusSeatDetails() {
		return busSeatDetails;
	}
	/**
	 * @param busSeatDetails the busSeatDetails to set
	 */
	public void setBusSeatDetails(List<BusSeatDetails> busSeatDetails) {
		this.busSeatDetails = busSeatDetails;
	}
	
}
