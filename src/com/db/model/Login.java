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
@Table(name = "user_login")
public class Login {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "ref_number", unique = true, nullable = false)
	private String id;
	@Column(name=  "user_id")
	private String uid;
	@Column(name=  "user_name")
	private String name;
	@Column(name = "session_id", length = 500)
	private String sessionId;
	@Column(name = "login_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new Date();
	@Column(name = "address", length = 500)
	private String address;
	@Column(name =  "logout_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date logoutd = new Date();
	@Column(name = "client_ip", length = 500)
	private String clientIP;
	@Column(name = "client_host", length =500)
	private String chost;
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
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}
	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * @return the logoutd
	 */
	public Date getLogoutd() {
		return logoutd;
	}
	/**
	 * @param logoutd the logoutd to set
	 */
	public void setLogoutd(Date logoutd) {
		this.logoutd = logoutd;
	}
	/**
	 * @return the clientIP
	 */
	public String getClientIP() {
		return clientIP;
	}
	/**
	 * @param clientIP the clientIP to set
	 */
	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}
	/**
	 * @return the chost
	 */
	public String getChost() {
		return chost;
	}
	/**
	 * @param chost the chost to set
	 */
	public void setChost(String chost) {
		this.chost = chost;
	}
	
}
