package org.ldxx.bean;

import java.math.BigDecimal;

/**
 * 材料分包合同下的履约评价表
 * @author hp
 */
public class ClfbContractEvaluate {
	private String ceId;
	private String taskNo;//任务单号
	private String prjName;//项目名称
	private String prjPerson;//项目负责人
	private String department;//部门
	private String materialContractCode;//材料采购合同编号
	private BigDecimal contractAllMoney;//合同累计金额
	private BigDecimal contractEndMoney;//合同实际结算金额
	private String payMode;//付款方式
	private String actualChargePerson;//实际负责人
	private String scoreProductQualityEase;//产品质量及易用情况
	private String scoreGiveProductionTime;//交货周期
	private String scoreMaterialReport;//材料合格证书检测报告完备
	private String scoreCustomerUse;//咨询及对顾客使用、维护的指导情况等售后服务
	private String scorePayModeEvaluate;//付款方式评价
	/*private String scoreSafetyCivilizationEnvironment;//安全文明与环保*/	
	private String allScore;//综合评价
	private String makeTime;
	private String history;
	
	
	private String uName;//实际负责人
	private String omName;//部门名
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
	public String getOmName() {
		return omName;
	}
	public void setOmName(String omName) {
		this.omName = omName;
	}
	public String getMakeTime() {
		return makeTime;
	}
	public void setMakeTime(String makeTime) {
		this.makeTime = makeTime;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getAllScore() {
		return allScore;
	}
	public void setAllScore(String allScore) {
		this.allScore = allScore;
	}
	public String getCeId() {
		return ceId;
	}
	public void setCeId(String ceId) {
		this.ceId = ceId;
	}
	public String getTaskNo() {
		return taskNo;
	}
	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getPrjPerson() {
		return prjPerson;
	}
	public void setPrjPerson(String prjPerson) {
		this.prjPerson = prjPerson;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMaterialContractCode() {
		return materialContractCode;
	}
	public void setMaterialContractCode(String materialContractCode) {
		this.materialContractCode = materialContractCode;
	}
	
	public BigDecimal getContractAllMoney() {
		return contractAllMoney;
	}
	public void setContractAllMoney(BigDecimal contractAllMoney) {
		this.contractAllMoney = contractAllMoney;
	}
	public BigDecimal getContractEndMoney() {
		return contractEndMoney;
	}
	public void setContractEndMoney(BigDecimal contractEndMoney) {
		this.contractEndMoney = contractEndMoney;
	}
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public String getActualChargePerson() {
		return actualChargePerson;
	}
	public void setActualChargePerson(String actualChargePerson) {
		this.actualChargePerson = actualChargePerson;
	}
	public String getScoreProductQualityEase() {
		return scoreProductQualityEase;
	}
	public void setScoreProductQualityEase(String scoreProductQualityEase) {
		this.scoreProductQualityEase = scoreProductQualityEase;
	}
	public String getScoreGiveProductionTime() {
		return scoreGiveProductionTime;
	}
	public void setScoreGiveProductionTime(String scoreGiveProductionTime) {
		this.scoreGiveProductionTime = scoreGiveProductionTime;
	}
	public String getScoreMaterialReport() {
		return scoreMaterialReport;
	}
	public void setScoreMaterialReport(String scoreMaterialReport) {
		this.scoreMaterialReport = scoreMaterialReport;
	}
	public String getScoreCustomerUse() {
		return scoreCustomerUse;
	}
	public void setScoreCustomerUse(String scoreCustomerUse) {
		this.scoreCustomerUse = scoreCustomerUse;
	}
	public String getScorePayModeEvaluate() {
		return scorePayModeEvaluate;
	}
	public void setScorePayModeEvaluate(String scorePayModeEvaluate) {
		this.scorePayModeEvaluate = scorePayModeEvaluate;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	
	
}
