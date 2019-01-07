package com.db.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="wallet_details")
public class Wallet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "system_id", nullable = false, unique = true)
	private String id;
	@Column(name = "previous_balance")
	private double previousBalance = 0;
	@Column(name = "current_balance")
	private double currentBalance = 0;
	@Column(name = "added_balance")
	private double addedBalance = 0;
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
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
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
	 * @return the previousBalance
	 */
	public double getPreviousBalance() {
		return previousBalance;
	}
	/**
	 * @param previousBalance the previousBalance to set
	 */
	public void setPreviousBalance(double previousBalance) {
		this.previousBalance = previousBalance;
	}
	/**
	 * @return the currentBalance
	 */
	public double getCurrentBalance() {
		return currentBalance;
	}
	/**
	 * @param currentBalance the currentBalance to set
	 */
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	/**
	 * @return the addedBalance
	 */
	public double getAddedBalance() {
		return addedBalance;
	}
	/**
	 * @param addedBalance the addedBalance to set
	 */
	public void setAddedBalance(double addedBalance) {
		this.addedBalance = addedBalance;
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
}
