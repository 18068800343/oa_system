package org.ldxx.bean;

import java.math.BigDecimal;

/** 
* @ClassName: ProjectIntegrated 
* @Description: 项目综合查询
* @author zhaohui
* @date 2018年12月6日 上午11:31:23 
*  
*/
public class ProjectIntegrated {

	private String prjNo;//任务单号
	private String prjName;//项目名称
	private String contractNo;//合同编号
	private String contractName;//合同名称
	private String prjType2;//项目类型
	private BigDecimal prjYs;//项目预算
	private String cjDepartment;//承接部门
	private String prjLeader;//项目负责人
	private BigDecimal workMoney;//任务单金额
	private BigDecimal contractMoney;//合同金额
	private BigDecimal zdMoney;//暂定金
	private BigDecimal contractEndMoney;//合同结算金额
	private BigDecimal totalKpMoney;//累积开票金额
	private BigDecimal totalMoney;//累计收款
	private BigDecimal prjCost;//项目成本
	private String prjPlan;//项目进度
	private String fbName;//分包项目名称
	private BigDecimal fbContractMoney;//分包合同金额
	private BigDecimal fbEndMoney;//分包结算金额
	private String fbPlan;//分包进度
	private BigDecimal practicalFbPayMoney;//实际分包付款金额
	
	
	public String getFbName() {
		return fbName;
	}
	public void setFbName(String fbName) {
		this.fbName = fbName;
	}
	public String getPrjNo() {
		return prjNo;
	}
	public void setPrjNo(String prjNo) {
		this.prjNo = prjNo;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getPrjType2() {
		return prjType2;
	}
	public void setPrjType2(String prjType2) {
		this.prjType2 = prjType2;
	}
	public BigDecimal getPrjYs() {
		return prjYs;
	}
	public void setPrjYs(BigDecimal prjYs) {
		this.prjYs = prjYs;
	}
	public String getCjDepartment() {
		return cjDepartment;
	}
	public void setCjDepartment(String cjDepartment) {
		this.cjDepartment = cjDepartment;
	}
	public String getPrjLeader() {
		return prjLeader;
	}
	public void setPrjLeader(String prjLeader) {
		this.prjLeader = prjLeader;
	}
	public BigDecimal getWorkMoney() {
		return workMoney;
	}
	public void setWorkMoney(BigDecimal workMoney) {
		this.workMoney = workMoney;
	}
	public BigDecimal getContractMoney() {
		return contractMoney;
	}
	public void setContractMoney(BigDecimal contractMoney) {
		this.contractMoney = contractMoney;
	}
	public BigDecimal getZdMoney() {
		return zdMoney;
	}
	public void setZdMoney(BigDecimal zdMoney) {
		this.zdMoney = zdMoney;
	}
	public BigDecimal getContractEndMoney() {
		return contractEndMoney;
	}
	public void setContractEndMoney(BigDecimal contractEndMoney) {
		this.contractEndMoney = contractEndMoney;
	}
	public BigDecimal getTotalKpMoney() {
		return totalKpMoney;
	}
	public void setTotalKpMoney(BigDecimal totalKpMoney) {
		this.totalKpMoney = totalKpMoney;
	}
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
	public BigDecimal getPrjCost() {
		return prjCost;
	}
	public void setPrjCost(BigDecimal prjCost) {
		this.prjCost = prjCost;
	}
	public String getPrjPlan() {
		return prjPlan;
	}
	public void setPrjPlan(String prjPlan) {
		this.prjPlan = prjPlan;
	}
	public BigDecimal getFbContractMoney() {
		return fbContractMoney;
	}
	public void setFbContractMoney(BigDecimal fbContractMoney) {
		this.fbContractMoney = fbContractMoney;
	}
	public BigDecimal getFbEndMoney() {
		return fbEndMoney;
	}
	public void setFbEndMoney(BigDecimal fbEndMoney) {
		this.fbEndMoney = fbEndMoney;
	}
	public String getFbPlan() {
		return fbPlan;
	}
	public void setFbPlan(String fbPlan) {
		this.fbPlan = fbPlan;
	}
	public BigDecimal getPracticalFbPayMoney() {
		return practicalFbPayMoney;
	}
	public void setPracticalFbPayMoney(BigDecimal practicalFbPayMoney) {
		this.practicalFbPayMoney = practicalFbPayMoney;
	}
	
	
}
