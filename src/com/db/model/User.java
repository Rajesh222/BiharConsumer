package com.db.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "user_master")
public class User implements Serializable {

	private static final long serialVersionUID = 8773592091012906066L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "user_id", nullable = false, unique = true)
	private String uid;
	@Column(name = "name", length = 500)
	private String name;
	@Column(name = "email", length = 500)
	private String email;
	@Column(name = "address", length = 500)
	private String address;
	@Column(name = "phone_number", length = 500)
	private String phone;
	@Column(name = "pan_number", length = 500)
	private String pan;
	@Column(name = "password", length = 500)
	private String password;
	@Transient
	private String passwordConfirm;
	@Column(name = "city", length = 500)
	private String city;
	@Column(name = "state", length = 500)
	private String state;
	@Column(name = "country", length = 500)
	private String country;
	@Column(name = "islock", nullable = false)
	private boolean isLock;
	@Column(name = "attempt", nullable = false)
	private Integer attempt;
	@Column(name = "isactive", nullable = false)
    private boolean isActive;
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private UserModule module;
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Wallet wallet;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the pan
	 */
	public String getPan() {
		return pan;
	}
	/**
	 * @param pan the pan to set
	 */
	public void setPan(String pan) {
		this.pan = pan;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the passwordConfirm
	 */
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	/**
	 * @param passwordConfirm the passwordConfirm to set
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
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
	/**
	 * @return the isLock
	 */
	public boolean isLock() {
		return isLock;
	}
	/**
	 * @param isLock the isLock to set
	 */
	public void setLock(boolean isLock) {
		this.isLock = isLock;
	}
	/**
	 * @return the attempt
	 */
	public Integer getAttempt() {
		return attempt;
	}
	/**
	 * @param attempt the attempt to set
	 */
	public void setAttempt(Integer attempt) {
		this.attempt = attempt;
	}
	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}
	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	/**
	 * @return the module
	 */
	public UserModule getModule() {
		return module;
	}
	/**
	 * @param module the module to set
	 */
	public void setModule(UserModule module) {
		this.module = module;
	}
	/**
	 * @return the wallet
	 */
	public Wallet getWallet() {
		return wallet;
	}
	/**
	 * @param wallet the wallet to set
	 */
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
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