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
@Table(name ="bus_seat_details")
public class BusSeatDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name ="system_id",nullable = false, unique= true)
	private String id;
	@Column(name ="isbook" , nullable = false)
	private boolean isBook;
	@Column(name ="seat_number", nullable= false)
	private String seatNo;
	@Column(name ="seat_location")
	private String seatLocation;
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
	 * @return the isBook
	 */
	public boolean isBook() {
		return isBook;
	}
	/**
	 * @param isBook the isBook to set
	 */
	public void setBook(boolean isBook) {
		this.isBook = isBook;
	}
	/**
	 * @return the seatNo
	 */
	public String getSeatNo() {
		return seatNo;
	}
	/**
	 * @param seatNo the seatNo to set
	 */
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	/**
	 * @return the seatLocation
	 */
	public String getSeatLocation() {
		return seatLocation;
	}
	/**
	 * @param seatLocation the seatLocation to set
	 */
	public void setSeatLocation(String seatLocation) {
		this.seatLocation = seatLocation;
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
