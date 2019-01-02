package com.db.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "bus_ticket_history")
public class BusTicketHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "system_id", nullable = false, unique = false)
	private String id;
	@Column(name = "user_id")
	private String uid;
	@Column(name = "bus_name")
	private String busName;
	@Column(name = "bus_number")
	private String busNumber;
	@Column(name = "source_name")
	private String source;
	@Column(name = "destination_name")
	private String destination;
	@Column(name = "bank_name")
	private String bankName;
	@Column(name = "bustype")
	private String busType;
	@Column(name = "chart_status")
	private String chartStatus;
	@Column(name = "total_fare")
	private String totalfare;
	@Column(name = "boardingDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date boardingDate;
	
	@Column(name = "createdOn")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();
	@Column(name = "createdBy")
	private String createdBy;
	@Column(name = "modifyOn")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyOn = new Date();
	@Column(name = "modifyBy")
	private String modifyBy;
	@Column(name = "isLicence", nullable = false)
	private boolean isLicence;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ticket_id")  
	@OrderColumn(name="orderBy")  
	private List<BusPassengerHistory> passengerDetails;

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
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
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
	 * @return the chartStatus
	 */
	public String getChartStatus() {
		return chartStatus;
	}

	/**
	 * @param chartStatus the chartStatus to set
	 */
	public void setChartStatus(String chartStatus) {
		this.chartStatus = chartStatus;
	}

	/**
	 * @return the totalfare
	 */
	public String getTotalfare() {
		return totalfare;
	}

	/**
	 * @param totalfare the totalfare to set
	 */
	public void setTotalfare(String totalfare) {
		this.totalfare = totalfare;
	}

	/**
	 * @return the boardingDate
	 */
	public Date getBoardingDate() {
		return boardingDate;
	}

	/**
	 * @param boardingDate the boardingDate to set
	 */
	public void setBoardingDate(Date boardingDate) {
		this.boardingDate = boardingDate;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	/**
	 * @return the isLicence
	 */
	public boolean isLicence() {
		return isLicence;
	}

	/**
	 * @param isLicence the isLicence to set
	 */
	public void setLicence(boolean isLicence) {
		this.isLicence = isLicence;
	}

	/**
	 * @return the passengerDetails
	 */
	public List<BusPassengerHistory> getPassengerDetails() {
		return passengerDetails;
	}

	/**
	 * @param passengerDetails the passengerDetails to set
	 */
	public void setPassengerDetails(List<BusPassengerHistory> passengerDetails) {
		this.passengerDetails = passengerDetails;
	}
}
