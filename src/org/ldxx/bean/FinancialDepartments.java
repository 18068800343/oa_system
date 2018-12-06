package org.ldxx.bean;

public class FinancialDepartments {
	private String ftId;
	private String ftDepartment;//部门
	private String ftPerson;//人员
	private float ftMoney;//认领金额
	
	private String state;
	private String uName;
	private String omName;
	
	
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getOmName() {
		return omName;
	}
	public void setOmName(String omName) {
		this.omName = omName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getFtId() {
		return ftId;
	}
	public void setFtId(String ftId) {
		this.ftId = ftId;
	}
	public String getFtDepartment() {
		return ftDepartment;
	}
	public void setFtDepartment(String ftDepartment) {
		this.ftDepartment = ftDepartment;
	}
	public String getFtPerson() {
		return ftPerson;
	}
	public void setFtPerson(String ftPerson) {
		this.ftPerson = ftPerson;
	}
	public float getFtMoney() {
		return ftMoney;
	}
	public void setFtMoney(float ftMoney) {
		this.ftMoney = ftMoney;
	}
}
