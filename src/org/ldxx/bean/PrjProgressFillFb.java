package org.ldxx.bean;

import java.math.BigDecimal;

public class PrjProgressFillFb {

	private String ppfId;
	private String fbId;
	private String fbName;
	private String department;
	private String fbUnit;
	private BigDecimal fbMoney;
	private BigDecimal incomeAllBili;//比例
	private BigDecimal incomeAll;
	private BigDecimal incomeBq;
	private String bq;
	private BigDecimal rate;
	private BigDecimal rateMoney;
	
	
	public BigDecimal getIncomeAllBili() {
		return incomeAllBili;
	}
	public void setIncomeAllBili(BigDecimal incomeAllBili) {
		this.incomeAllBili = incomeAllBili;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public BigDecimal getRateMoney() {
		return rateMoney;
	}
	public void setRateMoney(BigDecimal rateMoney) {
		this.rateMoney = rateMoney;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPpfId() {
		return ppfId;
	}
	public void setPpfId(String ppfId) {
		this.ppfId = ppfId;
	}
	public String getFbUnit() {
		return fbUnit;
	}
	public void setFbUnit(String fbUnit) {
		this.fbUnit = fbUnit;
	}
	public BigDecimal getFbMoney() {
		return fbMoney;
	}
	public void setFbMoney(BigDecimal fbMoney) {
		this.fbMoney = fbMoney;
	}
	public String getFbId() {
		return fbId;
	}
	public void setFbId(String fbId) {
		this.fbId = fbId;
	}
	public String getFbName() {
		return fbName;
	}
	public void setFbName(String fbName) {
		this.fbName = fbName;
	}
	public BigDecimal getIncomeAll() {
		return incomeAll;
	}
	public void setIncomeAll(BigDecimal incomeAll) {
		this.incomeAll = incomeAll;
	}
	public BigDecimal getIncomeBq() {
		return incomeBq;
	}
	public void setIncomeBq(BigDecimal incomeBq) {
		this.incomeBq = incomeBq;
	}
	public String getBq() {
		return bq;
	}
	public void setBq(String bq) {
		this.bq = bq;
	}
	
}
