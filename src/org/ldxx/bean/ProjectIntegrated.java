package org.ldxx.bean;

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
	private Double prjYs;//项目预算
	private String cjDepartment;//承接部门
	private String prjLeader;//项目负责人
	private Double workMoney;//任务单金额
	private Double contractMoney;//合同金额
	private Double zdMoney;//暂定金
	private Double contractEndMoney;//合同结算金额
	private Double totalKpMoney;//累积开票金额
	private double totalMoney;//累计收款
	private double prjCost;//项目成本
	private String prjPlan;//项目进度
	private String fbName;//分包项目名称
	private Double fbContractMoney;//分包合同金额
	private Double fbEndMoney;//分包结算金额
	private String fbPlan;//分包进度
	private Double practicalFbPayMoney;//实际分包付款金额
	
	
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
	public Double getPrjYs() {
		return prjYs;
	}
	public void setPrjYs(Double prjYs) {
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
	public Double getWorkMoney() {
		return workMoney;
	}
	public void setWorkMoney(Double workMoney) {
		this.workMoney = workMoney;
	}
	public Double getContractMoney() {
		return contractMoney;
	}
	public void setContractMoney(Double contractMoney) {
		this.contractMoney = contractMoney;
	}
	public Double getZdMoney() {
		return zdMoney;
	}
	public void setZdMoney(Double zdMoney) {
		this.zdMoney = zdMoney;
	}
	public Double getContractEndMoney() {
		return contractEndMoney;
	}
	public void setContractEndMoney(Double contractEndMoney) {
		this.contractEndMoney = contractEndMoney;
	}
	public Double getTotalKpMoney() {
		return totalKpMoney;
	}
	public void setTotalKpMoney(Double totalKpMoney) {
		this.totalKpMoney = totalKpMoney;
	}
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public double getPrjCost() {
		return prjCost;
	}
	public void setPrjCost(double prjCost) {
		this.prjCost = prjCost;
	}
	public String getPrjPlan() {
		return prjPlan;
	}
	public void setPrjPlan(String prjPlan) {
		this.prjPlan = prjPlan;
	}
	public Double getFbContractMoney() {
		return fbContractMoney;
	}
	public void setFbContractMoney(Double fbContractMoney) {
		this.fbContractMoney = fbContractMoney;
	}
	public Double getFbEndMoney() {
		return fbEndMoney;
	}
	public void setFbEndMoney(Double fbEndMoney) {
		this.fbEndMoney = fbEndMoney;
	}
	public String getFbPlan() {
		return fbPlan;
	}
	public void setFbPlan(String fbPlan) {
		this.fbPlan = fbPlan;
	}
	public Double getPracticalFbPayMoney() {
		return practicalFbPayMoney;
	}
	public void setPracticalFbPayMoney(Double practicalFbPayMoney) {
		this.practicalFbPayMoney = practicalFbPayMoney;
	}
	
	
}
