package org.ldxx.bean;

import java.math.BigDecimal;
import java.util.List;

public class OtherContract {
    private String oId;

    /*private String contractType;*/

    private String contractCode;

    private String contractName;

    private String contractNameJia;

    private String contractNameYi;
    private String ccName;

    private BigDecimal contractMoney;

    private String abutmentDepartment;
    private String omName;

    private String contractStartTime;

    private String contractEndTime;

    private String contractProbablyText;

    private String abutmentSignedTime;
    private BigDecimal zandingMoney;//暂定金
    
    /*private BigDecimal rate;
    private BigDecimal rateMoney;*/

    private List<Accessory> accessory;
    private List<Accessory> accessory2;//法律顾问签字

    private String starterName;//发起人
    private String status;//审批状态
    

   /* public BigDecimal getRate() {
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
	}*/

    
	public BigDecimal getZandingMoney() {
		return zandingMoney;
	}

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

	public void setZandingMoney(BigDecimal zandingMoney) {
		this.zandingMoney = zandingMoney;
	}

	public List<Accessory> getAccessory2() {
		return accessory2;
	}

	public void setAccessory2(List<Accessory> accessory2) {
		this.accessory2 = accessory2;
	}

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

    public BigDecimal getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(BigDecimal contractMoney) {
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