package org.ldxx.bean;

import java.math.BigDecimal;

public class CompanyCostCf {
	
	private String cfjjId;;
	private String  prjName;
	private String  prjNo;
	private String  department;
	private String  date;
	private BigDecimal  cfMoney;
	
	
	
	public String getCfjjId() {
		return cfjjId;
	}
	public void setCfjjId(String cfjjId) {
		this.cfjjId = cfjjId;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getPrjNo() {
		return prjNo;
	}
	public void setPrjNo(String prjNo) {
		this.prjNo = prjNo;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getCfMoney() {
		return cfMoney;
	}
	public void setCfMoney(BigDecimal cfMoney) {
		this.cfMoney = cfMoney;
	}
	

	
}
