package org.ldxx.bean;

import java.math.BigDecimal;
import java.util.List;

/**
 * 材料分包合同下的采购合同履约
 * @author hp
 *
 */
public class clfbCgcontractPerformance {
	
	private String pId;
	private String cgContract;//采购合同名
	private String cgNo;//采购合同号
	private String cjContract;//承接合同名
	private String cjNo;//承接合同号
	private String taskNo;//任务单号
	private String prjPerson;//项目负责人
	private String contractYi;//合同乙方
	private String fbPerson;//分包负责人
	private BigDecimal contractMoney;//合同金额
	private BigDecimal provisionalMoney;//暂定金
	private BigDecimal settlementMoney;//结算金额
	private String settlementDesc;//结算说明
	private BigDecimal accumulativePaymentMoney;//累计付款
	private String performanceGrade;//履约评级
	private String performanceDesc;//项目概况及工作内容
	private String makeTime;
	private String history;
	
	private List<Accessory> accessory;
	/*private List<Accessory> accessory2;//法律顾问签字*/	
	
	private String spName;//乙方名称
	
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

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}


	public String getCgContract() {
		return cgContract;
	}

	public void setCgContract(String cgContract) {
		this.cgContract = cgContract;
	}

	public String getCgNo() {
		return cgNo;
	}

	public void setCgNo(String cgNo) {
		this.cgNo = cgNo;
	}

	public String getCjContract() {
		return cjContract;
	}

	public void setCjContract(String cjContract) {
		this.cjContract = cjContract;
	}

	public String getCjNo() {
		return cjNo;
	}

	public void setCjNo(String cjNo) {
		this.cjNo = cjNo;
	}

	public String getTaskNo() {
		return taskNo;
	}

	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}

	public String getPrjPerson() {
		return prjPerson;
	}

	public void setPrjPerson(String prjPerson) {
		this.prjPerson = prjPerson;
	}

	public String getContractYi() {
		return contractYi;
	}

	public void setContractYi(String contractYi) {
		this.contractYi = contractYi;
	}

	public String getFbPerson() {
		return fbPerson;
	}

	public void setFbPerson(String fbPerson) {
		this.fbPerson = fbPerson;
	}

	public BigDecimal getContractMoney() {
		return contractMoney;
	}

	public void setContractMoney(BigDecimal contractMoney) {
		this.contractMoney = contractMoney;
	}

	public BigDecimal getProvisionalMoney() {
		return provisionalMoney;
	}

	public void setProvisionalMoney(BigDecimal provisionalMoney) {
		this.provisionalMoney = provisionalMoney;
	}

	public BigDecimal getSettlementMoney() {
		return settlementMoney;
	}

	public void setSettlementMoney(BigDecimal settlementMoney) {
		this.settlementMoney = settlementMoney;
	}

	public String getSettlementDesc() {
		return settlementDesc;
	}

	public void setSettlementDesc(String settlementDesc) {
		this.settlementDesc = settlementDesc;
	}

	public BigDecimal getAccumulativePaymentMoney() {
		return accumulativePaymentMoney;
	}

	public void setAccumulativePaymentMoney(BigDecimal accumulativePaymentMoney) {
		this.accumulativePaymentMoney = accumulativePaymentMoney;
	}

	public String getPerformanceGrade() {
		return performanceGrade;
	}

	public void setPerformanceGrade(String performanceGrade) {
		this.performanceGrade = performanceGrade;
	}

	public String getPerformanceDesc() {
		return performanceDesc;
	}

	public void setPerformanceDesc(String performanceDesc) {
		this.performanceDesc = performanceDesc;
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

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	
}
