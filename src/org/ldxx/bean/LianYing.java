package org.ldxx.bean;

import java.math.BigDecimal;
import java.util.List;

/** 
* @ClassName: LianYing 
* @Description: 联营合同
* @author zhaohui
* @date 2019年1月19日 上午9:59:30 
*  
*/
public class LianYing {

	private String lyId;
	private String lyNo;
	private String prjNo;
	private String prjName;
	private String prjArea;
	private String prjType2;
	private String ccName;
	private BigDecimal contractMoney;
	private String contractNo;
	private String contractNameYi;
	
	private String lyUnit;
	private String lyUnitName;
	private String uniformCode;
	private String certifications;
	private String safetyCertificateInfo;
	private String openingAccounts;
	private String openingBank;
	private String fbInfo;
	private String contractType;
	private String managementFee;
	private String otherFee;
	private String fbMoney;
	private String payTime;
	private String pbType;
	private String pbMoney;
	private List<Accessory> accessory;
	private List<FbContract> fb;
	
	private String starterName;//发起人
    private String status;//审批状态
    
    
	
	public String getStarterName() {
		return starterName;
	}
	public void setStarterName(String starterName) {
		this.starterName = starterName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<FbContract> getFb() {
		return fb;
	}
	public void setFb(List<FbContract> fb) {
		this.fb = fb;
	}
	public String getLyUnitName() {
		return lyUnitName;
	}
	public void setLyUnitName(String lyUnitName) {
		this.lyUnitName = lyUnitName;
	}
	public String getContractNameYi() {
		return contractNameYi;
	}
	public void setContractNameYi(String contractNameYi) {
		this.contractNameYi = contractNameYi;
	}
	public List<Accessory> getAccessory() {
		return accessory;
	}
	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getPrjArea() {
		return prjArea;
	}
	public void setPrjArea(String prjArea) {
		this.prjArea = prjArea;
	}
	public String getPrjType2() {
		return prjType2;
	}
	public void setPrjType2(String prjType2) {
		this.prjType2 = prjType2;
	}
	public BigDecimal getContractMoney() {
		return contractMoney;
	}
	public void setContractMoney(BigDecimal contractMoney) {
		this.contractMoney = contractMoney;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getCcName() {
		return ccName;
	}
	public void setCcName(String ccName) {
		this.ccName = ccName;
	}
	public String getLyId() {
		return lyId;
	}
	public void setLyId(String lyId) {
		this.lyId = lyId;
	}
	public String getLyNo() {
		return lyNo;
	}
	public void setLyNo(String lyNo) {
		this.lyNo = lyNo;
	}
	public String getPrjNo() {
		return prjNo;
	}
	public void setPrjNo(String prjNo) {
		this.prjNo = prjNo;
	}
	public String getLyUnit() {
		return lyUnit;
	}
	public void setLyUnit(String lyUnit) {
		this.lyUnit = lyUnit;
	}
	public String getUniformCode() {
		return uniformCode;
	}
	public void setUniformCode(String uniformCode) {
		this.uniformCode = uniformCode;
	}
	public String getCertifications() {
		return certifications;
	}
	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}
	public String getSafetyCertificateInfo() {
		return safetyCertificateInfo;
	}
	public void setSafetyCertificateInfo(String safetyCertificateInfo) {
		this.safetyCertificateInfo = safetyCertificateInfo;
	}
	public String getOpeningAccounts() {
		return openingAccounts;
	}
	public void setOpeningAccounts(String openingAccounts) {
		this.openingAccounts = openingAccounts;
	}
	public String getOpeningBank() {
		return openingBank;
	}
	public void setOpeningBank(String openingBank) {
		this.openingBank = openingBank;
	}
	public String getFbInfo() {
		return fbInfo;
	}
	public void setFbInfo(String fbInfo) {
		this.fbInfo = fbInfo;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public String getManagementFee() {
		return managementFee;
	}
	public void setManagementFee(String managementFee) {
		this.managementFee = managementFee;
	}
	public String getOtherFee() {
		return otherFee;
	}
	public void setOtherFee(String otherFee) {
		this.otherFee = otherFee;
	}
	public String getFbMoney() {
		return fbMoney;
	}
	public void setFbMoney(String fbMoney) {
		this.fbMoney = fbMoney;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public String getPbType() {
		return pbType;
	}
	public void setPbType(String pbType) {
		this.pbType = pbType;
	}
	public String getPbMoney() {
		return pbMoney;
	}
	public void setPbMoney(String pbMoney) {
		this.pbMoney = pbMoney;
	}
	
}
