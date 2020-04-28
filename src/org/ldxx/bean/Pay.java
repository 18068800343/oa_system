package org.ldxx.bean;

import java.util.List;

public class Pay {
    private String payId;

    private String payCode;//付款单号

    private String contractName;//分包合同名称
    
    private String contractNo;//分包合同编号

    private Double contractMoney;//分包合同金额

    private Double alreadyKpMoney;//已经开票金额
    
    private double skMoney;//收款金额
    
    private String skScale;//收款比例

    private Double thisTimeKpMoney;//本次开票金额

    private String mainContractCode;//主合同号

    private String mainContractName;//主合同名称

    private Double mainContractMoney;//主合同金额

    private String prjListCode;//任务单号

    private String prjName;//项目名称

    private String fbContractSchedule;//分包合同进度

    private String ifContractDoCost;//是否进行合同履约结算

    private Double contractDoCostMoney;//合同履约结算金额

    private Double alreadyAccumulateMoney;//已累计进付金额

    private Double GenerationAdvancesMoney; //付款申请代垫款
    
    private Double thisTimeAskMoney;//本次申请付款

    private String payMethod;//付款性质

    private String payListExplain;//付款单说明

    private String compilerPerson;//编制人

    private String compilerTime;//编制时间
    
    private Double authorisePayment;//批准付款

    private String makeTime;

    private String history;

    private Double resultPay;//实际支付金额
    
    private String payTime;//支付时间
    
    private Double accumulatedFinancialRecognitionMoney;//财务确认累计付款金额(元)
    private Double otherMatsMoney;//其他代垫费用
    
    
    private List<Accessory> accessory;
    private List<Accessory> accessory2;
    /*private List<Accessory> accessory3;//法律顾问签字*/    
    
    private Double fbcontractMoney;//分包合同金额
    private String contractNameYi;//分包合同乙方单位(分包单位)id
    private String ccName;//分包合同乙方单位名称(分包单位)
    private String uName;//编制人               
    
    private String starterName;//发起人
    private String status;//审批状态
    
    
    public Double getAccumulatedFinancialRecognitionMoney() {
		return accumulatedFinancialRecognitionMoney;
	}
	public void setAccumulatedFinancialRecognitionMoney(Double accumulatedFinancialRecognitionMoney) {
		this.accumulatedFinancialRecognitionMoney = accumulatedFinancialRecognitionMoney;
	}
	public Double getOtherMatsMoney() {
		return otherMatsMoney;
	}
	public void setOtherMatsMoney(Double otherMatsMoney) {
		this.otherMatsMoney = otherMatsMoney;
	}
	public double getSkMoney() {
		return skMoney;
	}
	public void setSkMoney(double skMoney) {
		this.skMoney = skMoney;
	}
	public String getSkScale() {
		return skScale;
	}
	public void setSkScale(String skScale) {
		this.skScale = skScale;
	}
	public Double getAuthorisePayment() {
		return authorisePayment;
	}
	public void setAuthorisePayment(Double authorisePayment) {
		this.authorisePayment = authorisePayment;
	}
	public Double getResultPay() {
		return resultPay;
	}
	public void setResultPay(Double resultPay) {
		this.resultPay = resultPay;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
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
	public Double getGenerationAdvancesMoney() {
		return GenerationAdvancesMoney;
	}
	public void setGenerationAdvancesMoney(Double generationAdvancesMoney) {
		GenerationAdvancesMoney = generationAdvancesMoney;
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
	public Double getContractMoney() {
		return contractMoney;
	}
	public void setContractMoney(Double contractMoney) {
		this.contractMoney = contractMoney;
	}
	public Double getAlreadyKpMoney() {
		return alreadyKpMoney;
	}
	public void setAlreadyKpMoney(Double alreadyKpMoney) {
		this.alreadyKpMoney = alreadyKpMoney;
	}
	public Double getThisTimeKpMoney() {
		return thisTimeKpMoney;
	}
	public void setThisTimeKpMoney(Double thisTimeKpMoney) {
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
	public Double getMainContractMoney() {
		return mainContractMoney;
	}
	public void setMainContractMoney(Double mainContractMoney) {
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
	public Double getContractDoCostMoney() {
		return contractDoCostMoney;
	}
	public void setContractDoCostMoney(Double contractDoCostMoney) {
		this.contractDoCostMoney = contractDoCostMoney;
	}
	public Double getAlreadyAccumulateMoney() {
		return alreadyAccumulateMoney;
	}
	public void setAlreadyAccumulateMoney(Double alreadyAccumulateMoney) {
		this.alreadyAccumulateMoney = alreadyAccumulateMoney;
	}
	public Double getThisTimeAskMoney() {
		return thisTimeAskMoney;
	}
	public void setThisTimeAskMoney(Double thisTimeAskMoney) {
		this.thisTimeAskMoney = thisTimeAskMoney;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
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
	public Double getFbcontractMoney() {
		return fbcontractMoney;
	}
	public void setFbcontractMoney(Double fbcontractMoney) {
		this.fbcontractMoney = fbcontractMoney;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
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
    
    
	
    
    
    
}