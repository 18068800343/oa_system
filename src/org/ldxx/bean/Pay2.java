package org.ldxx.bean;

import java.math.BigDecimal;
import java.util.List;

public class Pay2 {
	
    private String payId;

    private String payCode;//付款单号

    private String contractName;//分包合同名称
    
    private String contractNo;//分包合同编号

    private BigDecimal contractMoney;//分包合同金额

    private BigDecimal alreadyKpMoney;//已经开票金额
    
    private BigDecimal skMoney;//收款金额
    
    private String skScale;//收款比例

    private BigDecimal thisTimeKpMoney;//本次开票金额

    private String mainContractCode;//主合同号

    private String mainContractName;//主合同名称

    private BigDecimal mainContractMoney;//主合同金额

    private String prjListCode;//任务单号

    private String prjName;//项目名称

    private String fbContractSchedule;//分包合同进度

    private String ifContractDoCost;//是否进行合同履约结算

    private BigDecimal contractDoCostMoney;//合同履约结算金额

    private BigDecimal alreadyAccumulateMoney;//已累计进付金额

    private BigDecimal GenerationAdvancesMoney; //付款申请代垫款
    
    private BigDecimal thisTimeAskMoney;//本次申请付款

    private String payMethod;//付款性质

    private String payListExplain;//付款单说明

    private String compilerPerson;//编制人

    private String compilerTime;//编制时间
    
    private BigDecimal authorisePayment;//批准付款

    private String makeTime;

    private String history;

    private BigDecimal resultPay;//实际支付金额
    
    private String payTime;//支付时间
    
    private BigDecimal accumulatedFinancialRecognitionMoney;//财务确认累计付款金额(元)
    private BigDecimal otherMatsMoney;//其他代垫费用
    private BigDecimal ysqwfkMoney;//已申请未付款金额
    private BigDecimal yljfkMoney;////已累计付款金额
    
    
    private List<Accessory> accessory;
    private List<Accessory> accessory2;
    /*private List<Accessory> accessory3;//法律顾问签字*/    
    
    private BigDecimal fbcontractMoney;//分包合同金额
    private String contractNameYi;//分包合同乙方单位(分包单位)id
    private String ccName;//分包合同乙方单位名称(分包单位)
    private String uName;//编制人               
    
    private String starterName;//发起人
    private String status;//审批状态
    private String omName;
    private String doDate;
    
    
	public String getDoDate() {
		return doDate;
	}
	public void setDoDate(String doDate) {
		this.doDate = doDate;
	}
	public BigDecimal getYsqwfkMoney() {
		return ysqwfkMoney;
	}
	public void setYsqwfkMoney(BigDecimal ysqwfkMoney) {
		this.ysqwfkMoney = ysqwfkMoney;
	}
	public BigDecimal getYljfkMoney() {
		return yljfkMoney;
	}
	public void setYljfkMoney(BigDecimal yljfkMoney) {
		this.yljfkMoney = yljfkMoney;
	}
	public String getOmName() {
		return omName;
	}
	public void setOmName(String omName) {
		this.omName = omName;
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
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public BigDecimal getContractMoney() {
		return contractMoney;
	}
	public void setContractMoney(BigDecimal contractMoney) {
		this.contractMoney = contractMoney;
	}
	public BigDecimal getAlreadyKpMoney() {
		return alreadyKpMoney;
	}
	public void setAlreadyKpMoney(BigDecimal alreadyKpMoney) {
		this.alreadyKpMoney = alreadyKpMoney;
	}
	public BigDecimal getSkMoney() {
		return skMoney;
	}
	public void setSkMoney(BigDecimal skMoney) {
		this.skMoney = skMoney;
	}
	public String getSkScale() {
		return skScale;
	}
	public void setSkScale(String skScale) {
		this.skScale = skScale;
	}
	public BigDecimal getThisTimeKpMoney() {
		return thisTimeKpMoney;
	}
	public void setThisTimeKpMoney(BigDecimal thisTimeKpMoney) {
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
	public BigDecimal getMainContractMoney() {
		return mainContractMoney;
	}
	public void setMainContractMoney(BigDecimal mainContractMoney) {
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
	public BigDecimal getContractDoCostMoney() {
		return contractDoCostMoney;
	}
	public void setContractDoCostMoney(BigDecimal contractDoCostMoney) {
		this.contractDoCostMoney = contractDoCostMoney;
	}
	public BigDecimal getAlreadyAccumulateMoney() {
		return alreadyAccumulateMoney;
	}
	public void setAlreadyAccumulateMoney(BigDecimal alreadyAccumulateMoney) {
		this.alreadyAccumulateMoney = alreadyAccumulateMoney;
	}
	public BigDecimal getGenerationAdvancesMoney() {
		return GenerationAdvancesMoney;
	}
	public void setGenerationAdvancesMoney(BigDecimal generationAdvancesMoney) {
		GenerationAdvancesMoney = generationAdvancesMoney;
	}
	public BigDecimal getThisTimeAskMoney() {
		return thisTimeAskMoney;
	}
	public void setThisTimeAskMoney(BigDecimal thisTimeAskMoney) {
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
	public BigDecimal getAuthorisePayment() {
		return authorisePayment;
	}
	public void setAuthorisePayment(BigDecimal authorisePayment) {
		this.authorisePayment = authorisePayment;
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
	public BigDecimal getResultPay() {
		return resultPay;
	}
	public void setResultPay(BigDecimal resultPay) {
		this.resultPay = resultPay;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public BigDecimal getAccumulatedFinancialRecognitionMoney() {
		return accumulatedFinancialRecognitionMoney;
	}
	public void setAccumulatedFinancialRecognitionMoney(BigDecimal accumulatedFinancialRecognitionMoney) {
		this.accumulatedFinancialRecognitionMoney = accumulatedFinancialRecognitionMoney;
	}
	public BigDecimal getOtherMatsMoney() {
		return otherMatsMoney;
	}
	public void setOtherMatsMoney(BigDecimal otherMatsMoney) {
		this.otherMatsMoney = otherMatsMoney;
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
	public BigDecimal getFbcontractMoney() {
		return fbcontractMoney;
	}
	public void setFbcontractMoney(BigDecimal fbcontractMoney) {
		this.fbcontractMoney = fbcontractMoney;
	}
	public String getContractNameYi() {
		return contractNameYi;
	}
	public void setContractNameYi(String contractNameYi) {
		this.contractNameYi = contractNameYi;
	}
	public String getCcName() {
		return ccName;
	}
	public void setCcName(String ccName) {
		this.ccName = ccName;
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