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
@Table(name = "bus_passenger_details")
public class BusPassengerHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "system_id", nullable = false, unique = false)
	private String id;
	@Column(name = "passenger_name")
	private String name;
	@Column(name = "age")
	private int age;
	@Column(name = "gender")
	private String gender;
	@Column(name = "id_type")
	private String idType;
	@Column(name = "id_number")
	private String idNumber;
	@Column(name = "seat_number")
	private String seatNo;
	@Column(name = "isCancelled")
	private String isCancelled;
	@Column(name="createdBy")
	private String createdBy;
	@Column(name="createdOn", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn = new Date();
	@Column(name="modifyBy")
	private String modifyBy;
	@Column(name="modifyOn", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyOn;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the idType
	 */
	public String getIdType() {
		return idType;
	}
	/**
	 * @param idType the idType to set
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}
	/**
	 * @return the idNumber
	 */
	public String getIdNumber() {
		return idNumber;
	}
	/**
	 * @param idNumber the idNumber to set
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
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
	 * @return the isCancelled
	 */
	public String getIsCancelled() {
		return isCancelled;
	}
	/**
	 * @param isCancelled the isCancelled to set
	 */
	public void setIsCancelled(String isCancelled) {
		this.isCancelled = isCancelled;
	}
	
}
