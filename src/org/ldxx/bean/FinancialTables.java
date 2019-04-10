package org.ldxx.bean;
//检测二部的财务收款
public class FinancialTables {
	
	private String tId;
	private String tNo;//项目编号
	private String tName;//项目名称
	private String tDepartment;//核算部门
	private Double tCollectionValue;//收款值
	private String tDesc;//备注
	private String tTime;//到账时间
	private String state;//状态：1：未认领，0：已认领
	
	
	public String gettNo() {
		return tNo;
	}
	public void settNo(String tNo) {
		this.tNo = tNo;
	}
	public String gettId() {
		return tId;
	}
	public void settId(String tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String gettDepartment() {
		return tDepartment;
	}
	public void settDepartment(String tDepartment) {
		this.tDepartment = tDepartment;
	}
	public Double gettCollectionValue() {
		return tCollectionValue;
	}
	public void settCollectionValue(Double tCollectionValue) {
		this.tCollectionValue = tCollectionValue;
	}
	public String gettDesc() {
		return tDesc;
	}
	public void settDesc(String tDesc) {
		this.tDesc = tDesc;
	}
	public String gettTime() {
		return tTime;
	}
	public void settTime(String tTime) {
		this.tTime = tTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
