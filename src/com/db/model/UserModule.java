package com.db.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user_module")
public class UserModule {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ref_number", nullable = false, unique = true)
	private String id;
	@Column(name = "privilege_name", nullable = false)
	private String name;
	@Column(name = "isrecharge", nullable = false, columnDefinition = "boolean default false")
	private boolean isRecharge = false;
	@Column(name = "isbillpayment", nullable = false, columnDefinition = "boolean default false")
	private boolean isBillPayment = false;
	@Column(name = "ismoneytransfer", nullable = false, columnDefinition = "boolean default false")
	private boolean isMTransfer = false;
	@Column(name = "isaddmoney", nullable = false, columnDefinition = "boolean default false")
	private boolean isAddMonry = false;
	@Column(name = "isexportreport", nullable = false, columnDefinition = "boolean default false")
	private boolean isExportReport = false;
	@Column(name = "isbusbook", nullable = false, columnDefinition = "boolean default false")
	private boolean isBusBook = false;
	@Column(name = "createdBy")
	private String createdBy;
	@Column(name = "createdOn", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn = new Date();
	@Column(name = "modifyBy")
	private String modifyBy;
	@Column(name = "modifyOn", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyOn;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
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
	 * @return the isRecharge
	 */
	public boolean isRecharge() {
		return isRecharge;
	}

	/**
	 * @param isRecharge the isRecharge to set
	 */
	public void setRecharge(boolean isRecharge) {
		this.isRecharge = isRecharge;
	}

	/**
	 * @return the isBillPayment
	 */
	public boolean isBillPayment() {
		return isBillPayment;
	}

	/**
	 * @param isBillPayment the isBillPayment to set
	 */
	public void setBillPayment(boolean isBillPayment) {
		this.isBillPayment = isBillPayment;
	}

	/**
	 * @return the isMTransfer
	 */
	public boolean isMTransfer() {
		return isMTransfer;
	}

	/**
	 * @param isMTransfer the isMTransfer to set
	 */
	public void setMTransfer(boolean isMTransfer) {
		this.isMTransfer = isMTransfer;
	}

	/**
	 * @return the isAddMonry
	 */
	public boolean isAddMonry() {
		return isAddMonry;
	}

	/**
	 * @param isAddMonry the isAddMonry to set
	 */
	public void setAddMonry(boolean isAddMonry) {
		this.isAddMonry = isAddMonry;
	}

	/**
	 * @return the isExportReport
	 */
	public boolean isExportReport() {
		return isExportReport;
	}

	/**
	 * @param isExportReport the isExportReport to set
	 */
	public void setExportReport(boolean isExportReport) {
		this.isExportReport = isExportReport;
	}

	/**
	 * @return the isBusBook
	 */
	public boolean isBusBook() {
		return isBusBook;
	}

	/**
	 * @param isBusBook the isBusBook to set
	 */
	public void setBusBook(boolean isBusBook) {
		this.isBusBook = isBusBook;
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
