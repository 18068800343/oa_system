package org.ldxx.bean;

import java.util.List;

public class OtherContract {
    private String oId;

    /*private String contractType;*/

    private String contractCode;

    private String contractName;

    private String contractNameJia;

    private String contractNameYi;
    private String ccName;

    private Float contractMoney;

    private String abutmentDepartment;
    private String omName;

    private String contractStartTime;

    private String contractEndTime;

    private String contractProbablyText;

    private String abutmentSignedTime;

    private List<Accessory> accessory;

    
    public String getOmName() {
		return omName;
	}

	public void setOmName(String omName) {
		this.omName = omName;
	}

	public String getCcName() {
		return ccName;
	}

	public void setCcName(String ccName) {
		this.ccName = ccName;
	}

	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}

	public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId == null ? null : oId.trim();
    }


    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode == null ? null : contractCode.trim();
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    public String getContractNameJia() {
        return contractNameJia;
    }

    public void setContractNameJia(String contractNameJia) {
        this.contractNameJia = contractNameJia == null ? null : contractNameJia.trim();
    }

    public String getContractNameYi() {
        return contractNameYi;
    }

    public void setContractNameYi(String contractNameYi) {
        this.contractNameYi = contractNameYi == null ? null : contractNameYi.trim();
    }

    public Float getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(Float contractMoney) {
        this.contractMoney = contractMoney;
    }

    public String getAbutmentDepartment() {
        return abutmentDepartment;
    }

    public void setAbutmentDepartment(String abutmentDepartment) {
        this.abutmentDepartment = abutmentDepartment == null ? null : abutmentDepartment.trim();
    }

    public String getContractStartTime() {
        return contractStartTime;
    }

    public void setContractStartTime(String contractStartTime) {
        this.contractStartTime = contractStartTime == null ? null : contractStartTime.trim();
    }

    public String getContractEndTime() {
        return contractEndTime;
    }

    public void setContractEndTime(String contractEndTime) {
        this.contractEndTime = contractEndTime == null ? null : contractEndTime.trim();
    }

    public String getContractProbablyText() {
        return contractProbablyText;
    }

    public void setContractProbablyText(String contractProbablyText) {
        this.contractProbablyText = contractProbablyText == null ? null : contractProbablyText.trim();
    }

    public String getAbutmentSignedTime() {
        return abutmentSignedTime;
    }

    public void setAbutmentSignedTime(String abutmentSignedTime) {
        this.abutmentSignedTime = abutmentSignedTime == null ? null : abutmentSignedTime.trim();
    }

}