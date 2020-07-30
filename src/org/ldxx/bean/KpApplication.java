package org.ldxx.bean;

import java.math.BigDecimal;

/** 
* @ClassName: KpApplication 
* @Description: 开票申请
* @author zhaohui
* @date 2018年11月5日 下午5:11:25 
*  
*/
public class KpApplication {

	private String kpId;
	private String fpNo;//发票编码
	private String contractName;
	private String contractNo;
	private String prjName;
	private String prjNo;
	private BigDecimal kpMoney;
	private String time;
	private BigDecimal allKpMoney;
	private String fpType;
	private String dutyNo;
	private String sqMen;
	private String payUnit;
	private String xyCode;
	private String address;
	private String phone;
	private String bank;
	private String bankNo;
	
	private BigDecimal contractMoney;
	private String kpDepartment;
	private String omName;//部门名
	private String kpDesc;
	private String kpNo;//开票申请编号
	
	
	public String getKpNo() {
		return kpNo;
	}
	public void setKpNo(String kpNo) {
		this.kpNo = kpNo;
	}
	public String getOmName() {
		return omName;
	}
	public void setOmName(String omName) {
		this.omName = omName;
	}
	public String getKpDepartment() {
		return kpDepartment;
	}
	public void setKpDepartment(String kpDepartment) {
		this.kpDepartment = kpDepartment;
	}
	public BigDecimal getContractMoney() {
		return contractMoney;
	}
	public void setContractMoney(BigDecimal contractMoney) {
		this.contractMoney = contractMoney;
	}
	public String getKpDesc() {
		return kpDesc;
	}
	public void setKpDesc(String kpDesc) {
		this.kpDesc = kpDesc;
	}
	public String getFpNo() {
		return fpNo;
	}
	public void setFpNo(String fpNo) {
		this.fpNo = fpNo;
	}
	public String getKpId() {
		return kpId;
	}
	public void setKpId(String kpId) {
		this.kpId = kpId;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
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
	public BigDecimal getKpMoney() {
		return kpMoney;
	}
	public void setKpMoney(BigDecimal kpMoney) {
		this.kpMoney = kpMoney;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public BigDecimal getAllKpMoney() {
		return allKpMoney;
	}
	public void setAllKpMoney(BigDecimal allKpMoney) {
		this.allKpMoney = allKpMoney;
	}
	public String getFpType() {
		return fpType;
	}
	public void setFpType(String fpType) {
		this.fpType = fpType;
	}
	public String getDutyNo() {
		return dutyNo;
	}
	public void setDutyNo(String dutyNo) {
		this.dutyNo = dutyNo;
	}
	public String getSqMen() {
		return sqMen;
	}
	public void setSqMen(String sqMen) {
		this.sqMen = sqMen;
	}
	public String getPayUnit() {
		return payUnit;
	}
	public void setPayUnit(String payUnit) {
		this.payUnit = payUnit;
	}
	public String getXyCode() {
		return xyCode;
	}
	public void setXyCode(String xyCode) {
		this.xyCode = xyCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	
	
}
