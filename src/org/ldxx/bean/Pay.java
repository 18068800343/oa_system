package org.ldxx.bean;

import java.util.List;

public class Pay {
    private String payId;

    private String payCode;//付款单号

    private String contractCode;//合同编码

    private String contractName;//合同名称

    private String contractMoney;//合同金额

    private String alreadyKpMoney;//已经开票金额

    private String thisTimeKpMoney;//本次开票金额

    private String mainContractCode;//主合同号

    private String mainContractName;//主合同名称

    private String mainContractMoney;//主合同金额

    private String prjListCode;//任务单号

    private String prjName;//项目名称

    private String fbContractSchedule;//分包合同进度

    private String ifContractDoCost;//是否进行合同履约结算

    private String contractDoCostMoney;//合同履约结算金额

    private String alreadyAccumulateMoney;//已累计进付金额

    private String shouldCutDfMoney;//应扣除代付款

    private String shouldCutMaterialMoney;//应扣除材料费

    private String thisTimeAskMoney;//本次申请付款

    private String payMethod;//付款性质

    private String receieveMoneyCompany;//收款单位

    private String thisTimeActualPayMoney;//本次实际付款

    private String payListExplain;//付款单说明
    
    private String omId;//部门

    private String compilerPerson;//编制人

    private String compilerTime;//编制时间

    private String openTicketFile;//开票附件名称

    private String ticketFilePath;

    
    private List<Accessory> accessory;
    private List<Accessory> accessory2;
    
    
    private String fbNo;//分包合同号
    private Float fbcontractMoney;//分包合同金额
    private String uName;//编制人
    
    
    public String getOmId() {
		return omId;
	}

	public void setOmId(String omId) {
		this.omId = omId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getFbNo() {
		return fbNo;
	}

	public void setFbNo(String fbNo) {
		this.fbNo = fbNo;
	}

	public Float getFbcontractMoney() {
		return fbcontractMoney;
	}

	public void setFbcontractMoney(Float fbcontractMoney) {
		this.fbcontractMoney = fbcontractMoney;
	}

	public List<Accessory> getAccessory2() {
		return accessory2;
	}

	public void setAccessory2(List<Accessory> accessory2) {
		this.accessory2 = accessory2;
	}

	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}

	public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId == null ? null : payId.trim();
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode == null ? null : payCode.trim();
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

    public String getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(String contractMoney) {
        this.contractMoney = contractMoney == null ? null : contractMoney.trim();
    }

    public String getAlreadyKpMoney() {
        return alreadyKpMoney;
    }

    public void setAlreadyKpMoney(String alreadyKpMoney) {
        this.alreadyKpMoney = alreadyKpMoney == null ? null : alreadyKpMoney.trim();
    }

    public String getThisTimeKpMoney() {
        return thisTimeKpMoney;
    }

    public void setThisTimeKpMoney(String thisTimeKpMoney) {
        this.thisTimeKpMoney = thisTimeKpMoney == null ? null : thisTimeKpMoney.trim();
    }

    public String getMainContractCode() {
        return mainContractCode;
    }

    public void setMainContractCode(String mainContractCode) {
        this.mainContractCode = mainContractCode == null ? null : mainContractCode.trim();
    }

    public String getMainContractName() {
        return mainContractName;
    }

    public void setMainContractName(String mainContractName) {
        this.mainContractName = mainContractName == null ? null : mainContractName.trim();
    }

    public String getMainContractMoney() {
        return mainContractMoney;
    }

    public void setMainContractMoney(String mainContractMoney) {
        this.mainContractMoney = mainContractMoney == null ? null : mainContractMoney.trim();
    }

    public String getPrjListCode() {
        return prjListCode;
    }

    public void setPrjListCode(String prjListCode) {
        this.prjListCode = prjListCode == null ? null : prjListCode.trim();
    }

    public String getPrjName() {
        return prjName;
    }

    public void setPrjName(String prjName) {
        this.prjName = prjName == null ? null : prjName.trim();
    }

    public String getFbContractSchedule() {
        return fbContractSchedule;
    }

    public void setFbContractSchedule(String fbContractSchedule) {
        this.fbContractSchedule = fbContractSchedule == null ? null : fbContractSchedule.trim();
    }

    public String getIfContractDoCost() {
        return ifContractDoCost;
    }

    public void setIfContractDoCost(String ifContractDoCost) {
        this.ifContractDoCost = ifContractDoCost == null ? null : ifContractDoCost.trim();
    }

    public String getContractDoCostMoney() {
        return contractDoCostMoney;
    }

    public void setContractDoCostMoney(String contractDoCostMoney) {
        this.contractDoCostMoney = contractDoCostMoney == null ? null : contractDoCostMoney.trim();
    }

    public String getAlreadyAccumulateMoney() {
        return alreadyAccumulateMoney;
    }

    public void setAlreadyAccumulateMoney(String alreadyAccumulateMoney) {
        this.alreadyAccumulateMoney = alreadyAccumulateMoney == null ? null : alreadyAccumulateMoney.trim();
    }

    public String getShouldCutDfMoney() {
        return shouldCutDfMoney;
    }

    public void setShouldCutDfMoney(String shouldCutDfMoney) {
        this.shouldCutDfMoney = shouldCutDfMoney == null ? null : shouldCutDfMoney.trim();
    }

    public String getShouldCutMaterialMoney() {
        return shouldCutMaterialMoney;
    }

    public void setShouldCutMaterialMoney(String shouldCutMaterialMoney) {
        this.shouldCutMaterialMoney = shouldCutMaterialMoney == null ? null : shouldCutMaterialMoney.trim();
    }

    public String getThisTimeAskMoney() {
        return thisTimeAskMoney;
    }

    public void setThisTimeAskMoney(String thisTimeAskMoney) {
        this.thisTimeAskMoney = thisTimeAskMoney == null ? null : thisTimeAskMoney.trim();
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod == null ? null : payMethod.trim();
    }

    public String getReceieveMoneyCompany() {
        return receieveMoneyCompany;
    }

    public void setReceieveMoneyCompany(String receieveMoneyCompany) {
        this.receieveMoneyCompany = receieveMoneyCompany == null ? null : receieveMoneyCompany.trim();
    }

    public String getThisTimeActualPayMoney() {
        return thisTimeActualPayMoney;
    }

    public void setThisTimeActualPayMoney(String thisTimeActualPayMoney) {
        this.thisTimeActualPayMoney = thisTimeActualPayMoney == null ? null : thisTimeActualPayMoney.trim();
    }

    public String getPayListExplain() {
        return payListExplain;
    }

    public void setPayListExplain(String payListExplain) {
        this.payListExplain = payListExplain == null ? null : payListExplain.trim();
    }

    public String getCompilerPerson() {
        return compilerPerson;
    }

    public void setCompilerPerson(String compilerPerson) {
        this.compilerPerson = compilerPerson == null ? null : compilerPerson.trim();
    }

    public String getCompilerTime() {
        return compilerTime;
    }

    public void setCompilerTime(String compilerTime) {
        this.compilerTime = compilerTime == null ? null : compilerTime.trim();
    }

    public String getOpenTicketFile() {
        return openTicketFile;
    }

    public void setOpenTicketFile(String openTicketFile) {
        this.openTicketFile = openTicketFile == null ? null : openTicketFile.trim();
    }

    public String getTicketFilePath() {
        return ticketFilePath;
    }

    public void setTicketFilePath(String ticketFilePath) {
        this.ticketFilePath = ticketFilePath == null ? null : ticketFilePath.trim();
    }
}