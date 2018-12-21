package org.ldxx.bean;

import java.util.List;

/**
 * 材料分包合同下的采购结算申请
 * @author hp
 *
 */
public class clfbContractPurchaseSettlement {
	private String cpId;
	private String taskNo;//任务单号
	private String prjName;//项目名
	private String cgContract;//采购合同名
	private String cgNo;//采购合同号
	private String cjContract;//承接合同名
	private String cjNo;//承接合同号
	private String auditSettlementType;//审计结算类型
	private String settlementTime;//时间
	private String purchaseSettlementDesc;//概述
	private String makeTime;
	private String history;
	
	private List<Accessory> accessory;//法律顾问签字
	
	
	
	public List<Accessory> getAccessory() {
		return accessory;
	}
	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}
	public String getCjNo() {
		return cjNo;
	}
	public void setCjNo(String cjNo) {
		this.cjNo = cjNo;
	}
	public String getCgNo() {
		return cgNo;
	}
	public void setCgNo(String cgNo) {
		this.cgNo = cgNo;
	}
	public String getCpId() {
		return cpId;
	}
	public void setCpId(String cpId) {
		this.cpId = cpId;
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
	public String getCgContract() {
		return cgContract;
	}
	public void setCgContract(String cgContract) {
		this.cgContract = cgContract;
	}
	public String getCjContract() {
		return cjContract;
	}
	public void setCjContract(String cjContract) {
		this.cjContract = cjContract;
	}
	
	public String getAuditSettlementType() {
		return auditSettlementType;
	}
	public void setAuditSettlementType(String auditSettlementType) {
		this.auditSettlementType = auditSettlementType;
	}
	public String getSettlementTime() {
		return settlementTime;
	}
	public void setSettlementTime(String settlementTime) {
		this.settlementTime = settlementTime;
	}
	public String getPurchaseSettlementDesc() {
		return purchaseSettlementDesc;
	}
	public void setPurchaseSettlementDesc(String purchaseSettlementDesc) {
		this.purchaseSettlementDesc = purchaseSettlementDesc;
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
	
	

}
