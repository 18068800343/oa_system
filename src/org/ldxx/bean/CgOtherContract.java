package org.ldxx.bean;

import java.math.BigDecimal;
import java.util.List;

/**
 * 采购合同
 * 
 * @author hp
 *
 */
public class CgOtherContract {
	private String cgoId;//编号
	private String contractName;// 其他采购合同名称
	private String cgoNo;//其他采购合同编号
	private String workNo;// 任务单号
	private String prjName;//项目名称
	private String cgocType;// 采购合同类型
	private BigDecimal CgoContractMoney;// 采购合同金额
	private String contractNameJia;// 合同甲方名称
	private String contractNameYi;// 乙方
	private String payMode;// 付款方式
	private String contractSignTime;// 采购合同签订时间
	private String contractSummary;// 采购合同概述
	private String workContent;// 主要概况及工作内容
	private String makeTime; //当前时间
	private String history;//历史状态
	private String cgoDepartment;//采购部门
	private BigDecimal freight;//运费
	private BigDecimal shuilv;//税率
	private BigDecimal shuijin;//税金
	    
	private List<Accessory> accessory;
	private List<Accessory> accessory1;

	private String spName;// 乙方单位名称

	private String starterName;//发起人
    private String status;//审批状态
    private String doDate;//审批状态
	
    
    
	public String getDoDate() {
		return doDate;
	}

	public void setDoDate(String doDate) {
		this.doDate = doDate;
	}
	public BigDecimal getShuilv() {
		return shuilv;
	}

	public void setShuilv(BigDecimal shuilv) {
		this.shuilv = shuilv;
	}

	public BigDecimal getShuijin() {
		return shuijin;
	}

	public void setShuijin(BigDecimal shuijin) {
		this.shuijin = shuijin;
	}

	public String getCgoId() {
		return cgoId;
	}

	public void setCgoId(String cgoId) {
		this.cgoId = cgoId;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getCgoNo() {
		return cgoNo;
	}

	public void setCgoNo(String cgoNo) {
		this.cgoNo = cgoNo;
	}

	public String getWorkNo() {
		return workNo;
	}

	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getCgocType() {
		return cgocType;
	}

	public void setCgocType(String cgocType) {
		this.cgocType = cgocType;
	}

	public BigDecimal getCgoContractMoney() {
		return CgoContractMoney;
	}

	public void setCgoContractMoney(BigDecimal cgoContractMoney) {
		CgoContractMoney = cgoContractMoney;
	}

	public String getContractNameJia() {
		return contractNameJia;
	}

	public void setContractNameJia(String contractNameJia) {
		this.contractNameJia = contractNameJia;
	}

	public String getContractNameYi() {
		return contractNameYi;
	}

	public void setContractNameYi(String contractNameYi) {
		this.contractNameYi = contractNameYi;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getContractSignTime() {
		return contractSignTime;
	}

	public void setContractSignTime(String contractSignTime) {
		this.contractSignTime = contractSignTime;
	}

	public String getContractSummary() {
		return contractSummary;
	}

	public void setContractSummary(String contractSummary) {
		this.contractSummary = contractSummary;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
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

	public String getCgoDepartment() {
		return cgoDepartment;
	}

	public void setCgoDepartment(String cgoDepartment) {
		this.cgoDepartment = cgoDepartment;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}

	public List<Accessory> getAccessory1() {
		return accessory1;
	}

	public void setAccessory1(List<Accessory> accessory1) {
		this.accessory1 = accessory1;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
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
