package com.db.model;

import java.io.Serializable;
import java.util.Date;

public class Wallet extends BaseModel implements Serializable{
	
	private static final long serialVersionUID = 7198033653493021478L;
	private String id;
	private String userId;
	private double previousBalance = 0;
	private double currentBalance = 0;
	private double addedBalance = 0;
	private String createdBy;
	private Date createdOn = new Date();
	private String modifyBy;
	private Date modifyOn = new Date();
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
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
}
