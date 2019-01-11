package com.db.model;

public class BusCancellationPolicies extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7267795731820416481L;
	private String ruleId;
	private String routId;
	private String timeInterval;
	private String moneyDeducted;
	/**
	 * @return the ruleId
	 */
	public String getRuleId() {
		return ruleId;
	}
	/**
	 * @param ruleId the ruleId to set
	 */
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	/**
	 * @return the routId
	 */
	public String getRoutId() {
		return routId;
	}
	/**
	 * @param routId the routId to set
	 */
	public void setRoutId(String routId) {
		this.routId = routId;
	}
	/**
	 * @return the timeInterval
	 */
	public String getTimeInterval() {
		return timeInterval;
	}
	/**
	 * @param timeInterval the timeInterval to set
	 */
	public void setTimeInterval(String timeInterval) {
		this.timeInterval = timeInterval;
	}
	/**
	 * @return the moneyDeducted
	 */
	public String getMoneyDeducted() {
		return moneyDeducted;
	}
	/**
	 * @param moneyDeducted the moneyDeducted to set
	 */
	public void setMoneyDeducted(String moneyDeducted) {
		this.moneyDeducted = moneyDeducted;
	}
	
}
