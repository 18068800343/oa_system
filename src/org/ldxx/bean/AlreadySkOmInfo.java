package org.ldxx.bean;
/**
 * 已认领部门收款信息
 * @author hp
 *
 */
public class AlreadySkOmInfo {
	
	private String aoId;
	private String rId;//已认领收款信息id
	private String omId;//部门id
	private String omName;//部门名
	private Float omAlreadyMoney;//部门实际收款金额 
	private String time;
	private String operatorPerson;//操作人
	
	
	public String getAoId() {
		return aoId;
	}
	public void setAoId(String aoId) {
		this.aoId = aoId;
	}
	public String getRId() {
		return rId;
	}
	public void setRId(String rId) {
		this.rId = rId;
	}
	public String getOmId() {
		return omId;
	}
	public void setOmId(String omId) {
		this.omId = omId;
	}
	public String getOmName() {
		return omName;
	}
	public void setOmName(String omName) {
		this.omName = omName;
	}
	public Float getOmAlreadyMoney() {
		return omAlreadyMoney;
	}
	public void setOmAlreadyMoney(Float omAlreadyMoney) {
		this.omAlreadyMoney = omAlreadyMoney;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getOperatorPerson() {
		return operatorPerson;
	}
	public void setOperatorPerson(String operatorPerson) {
		this.operatorPerson = operatorPerson;
	}
	
	

}
