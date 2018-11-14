package org.ldxx.bean;

import java.util.List;

public class Pay {
    private String payId;

    private String payCode;//付款单号

    private String contractName;//分包合同名称
    
    private String contractNo;//分包合同编号

    private Float contractMoney;//合同金额

    private Float alreadyKpMoney;//已经开票金额

    private Float thisTimeKpMoney;//本次开票金额

    private String mainContractCode;//主合同号

    private String mainContractName;//主合同名称

    private Float mainContractMoney;//主合同金额

    private String prjListCode;//任务单号

    private String prjName;//项目名称

    private String fbContractSchedule;//分包合同进度

    private String ifContractDoCost;//是否进行合同履约结算

    private Float contractDoCostMoney;//合同履约结算金额

    private Float alreadyAccumulateMoney;//已累计进付金额

    private Float GenerationAdvancesMoney; //付款申请代垫款
    
    private Float thisTimeAskMoney;//本次申请付款

    private String payMethod;//付款性质

    private String receieveMoneyCompany;//收款单位

    private Float thisTimeActualPayMoney;//本次实际付款

    private String payListExplain;//付款单说明

    private String compilerPerson;//编制人

    private String compilerTime;//编制时间

    private String makeTime;

    private String history;

    
    private List<Accessory> accessory;
    private List<Accessory> accessory2;
    private List<Accessory> accessory3;//法律顾问签字
    
    private Float fbcontractMoney;//分包合同金额
    private String contractNameYi;//分包合同乙方单位(分包单位)id
    private String ccName;//分包合同乙方单位名称(分包单位)
    private String uName;//编制人               
    
    
    
    public String getCcName() {
		return ccName;
	}
	public void setCcName(String ccName) {
		this.ccName = ccName;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public Float getGenerationAdvancesMoney() {
		return GenerationAdvancesMoney;
	}
	public void setGenerationAdvancesMoney(Float generationAdvancesMoney) {
		GenerationAdvancesMoney = generationAdvancesMoney;
	}
	public List<Accessory> getAccessory3() {
		return accessory3;
	}
	public void setAccessory3(List<Accessory> accessory3) {
		this.accessory3 = accessory3;
	}
	public String getContractNameYi() {
		return contractNameYi;
	}
	public void setContractNameYi(String contractNameYi) {
		this.contractNameYi = contractNameYi;
	}
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public String getPayCode() {
		return payCode;
	}
	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public Float getContractMoney() {
		return contractMoney;
	}
	public void setContractMoney(Float contractMoney) {
		this.contractMoney = contractMoney;
	}
	public Float getAlreadyKpMoney() {
		return alreadyKpMoney;
	}
	public void setAlreadyKpMoney(Float alreadyKpMoney) {
		this.alreadyKpMoney = alreadyKpMoney;
	}
	public Float getThisTimeKpMoney() {
		return thisTimeKpMoney;
	}
	public void setThisTimeKpMoney(Float thisTimeKpMoney) {
		this.thisTimeKpMoney = thisTimeKpMoney;
	}
	public String getMainContractCode() {
		return mainContractCode;
	}
	public void setMainContractCode(String mainContractCode) {
		this.mainContractCode = mainContractCode;
	}
	public String getMainContractName() {
		return mainContractName;
	}
	public void setMainContractName(String mainContractName) {
		this.mainContractName = mainContractName;
	}
	public Float getMainContractMoney() {
		return mainContractMoney;
	}
	public void setMainContractMoney(Float mainContractMoney) {
		this.mainContractMoney = mainContractMoney;
	}
	public String getPrjListCode() {
		return prjListCode;
	}
	public void setPrjListCode(String prjListCode) {
		this.prjListCode = prjListCode;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getFbContractSchedule() {
		return fbContractSchedule;
	}
	public void setFbContractSchedule(String fbContractSchedule) {
		this.fbContractSchedule = fbContractSchedule;
	}
	public String getIfContractDoCost() {
		return ifContractDoCost;
	}
	public void setIfContractDoCost(String ifContractDoCost) {
		this.ifContractDoCost = ifContractDoCost;
	}
	public Float getContractDoCostMoney() {
		return contractDoCostMoney;
	}
	public void setContractDoCostMoney(Float contractDoCostMoney) {
		this.contractDoCostMoney = contractDoCostMoney;
	}
	public Float getAlreadyAccumulateMoney() {
		return alreadyAccumulateMoney;
	}
	public void setAlreadyAccumulateMoney(Float alreadyAccumulateMoney) {
		this.alreadyAccumulateMoney = alreadyAccumulateMoney;
	}
	public Float getThisTimeAskMoney() {
		return thisTimeAskMoney;
	}
	public void setThisTimeAskMoney(Float thisTimeAskMoney) {
		this.thisTimeAskMoney = thisTimeAskMoney;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public String getReceieveMoneyCompany() {
		return receieveMoneyCompany;
	}
	public void setReceieveMoneyCompany(String receieveMoneyCompany) {
		this.receieveMoneyCompany = receieveMoneyCompany;
	}
	public Float getThisTimeActualPayMoney() {
		return thisTimeActualPayMoney;
	}
	public void setThisTimeActualPayMoney(Float thisTimeActualPayMoney) {
		this.thisTimeActualPayMoney = thisTimeActualPayMoney;
	}
	public String getPayListExplain() {
		return payListExplain;
	}
	public void setPayListExplain(String payListExplain) {
		this.payListExplain = payListExplain;
	}
	public String getCompilerPerson() {
		return compilerPerson;
	}
	public void setCompilerPerson(String compilerPerson) {
		this.compilerPerson = compilerPerson;
	}
	public String getCompilerTime() {
		return compilerTime;
	}
	public void setCompilerTime(String compilerTime) {
		this.compilerTime = compilerTime;
	}
	
	public String getMakeTime() {
		return makeTime;
	}
	public void setMakeTime(String makeTime) {
		this.makeTime = makeTime;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public List<Accessory> getAccessory() {
		return accessory;
	}
	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}
	public List<Accessory> getAccessory2() {
		return accessory2;
	}
	public void setAccessory2(List<Accessory> accessory2) {
		this.accessory2 = accessory2;
	}
	public Float getFbcontractMoney() {
		return fbcontractMoney;
	}
	public void setFbcontractMoney(Float fbcontractMoney) {
		this.fbcontractMoney = fbcontractMoney;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
    
    
	
    
    
    
}