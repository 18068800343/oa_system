package org.ldxx.bean;

import java.util.List;

public class ProjectAccounting {
	
	private String paId;
	private String prjName;//项目名
	private String prjNo;//项目编号
	private String yezhu;//业主单位
	private String cjDepartment;//承接部门
	private String prjLeader;//项目负责人
	private Float  contractMoney;//合同金额
	private Float  prjJsMoney;//项目结算金额
	private Float  prjYsCost;//项目预算成本
	private Float  ysProfit;//预算利润
	private String ysProfitMargin;//预算利润率
	private Float  jsProfit;//结算利润
	private String jsProfitMargin;//结算利润率
	private Float  prjActualCost;//项目核算实际成本
	private Float  allJsProfit;//总成本的结算利润
	private Float  allYsProfit;//总成本的预算利润
	private String allJsProfitMargin;//总成本的结算利润率
	private String allYsProfitMargin;//总成本的预算利润率
	
	private List<ProjectAccountingRg> projectAccountingRg;//人员工时
	private List<ProjectAccountingFyys> projectAccountingFyys;//费用预算
	private List<ProjectAccountingClfy> projectAccountingClfy;//材料费用
	private List<ProjectAccountingJjfy> projectAccountingJjfy;//间接费用
	
	
	
	public List<ProjectAccountingRg> getProjectAccountingRg() {
		return projectAccountingRg;
	}
	public void setProjectAccountingRg(List<ProjectAccountingRg> projectAccountingRg) {
		this.projectAccountingRg = projectAccountingRg;
	}
	public List<ProjectAccountingFyys> getProjectAccountingFyys() {
		return projectAccountingFyys;
	}
	public void setProjectAccountingFyys(List<ProjectAccountingFyys> projectAccountingFyys) {
		this.projectAccountingFyys = projectAccountingFyys;
	}
	public List<ProjectAccountingClfy> getProjectAccountingClfy() {
		return projectAccountingClfy;
	}
	public void setProjectAccountingClfy(List<ProjectAccountingClfy> projectAccountingClfy) {
		this.projectAccountingClfy = projectAccountingClfy;
	}
	public List<ProjectAccountingJjfy> getProjectAccountingJjfy() {
		return projectAccountingJjfy;
	}
	public void setProjectAccountingJjfy(List<ProjectAccountingJjfy> projectAccountingJjfy) {
		this.projectAccountingJjfy = projectAccountingJjfy;
	}
	public String getPaId() {
		return paId;
	}
	public void setPaId(String paId) {
		this.paId = paId;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getPrjNo() {
		return prjNo;
	}
	public void setPrjNo(String prjNo) {
		this.prjNo = prjNo;
	}
	public String getYezhu() {
		return yezhu;
	}
	public void setYezhu(String yezhu) {
		this.yezhu = yezhu;
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
	public Float getContractMoney() {
		return contractMoney;
	}
	public void setContractMoney(Float contractMoney) {
		this.contractMoney = contractMoney;
	}
	public Float getPrjJsMoney() {
		return prjJsMoney;
	}
	public void setPrjJsMoney(Float prjJsMoney) {
		this.prjJsMoney = prjJsMoney;
	}
	public Float getPrjYsCost() {
		return prjYsCost;
	}
	public void setPrjYsCost(Float prjYsCost) {
		this.prjYsCost = prjYsCost;
	}
	public Float getYsProfit() {
		return ysProfit;
	}
	public void setYsProfit(Float ysProfit) {
		this.ysProfit = ysProfit;
	}
	public String getYsProfitMargin() {
		return ysProfitMargin;
	}
	public void setYsProfitMargin(String ysProfitMargin) {
		this.ysProfitMargin = ysProfitMargin;
	}
	public Float getJsProfit() {
		return jsProfit;
	}
	public void setJsProfit(Float jsProfit) {
		this.jsProfit = jsProfit;
	}
	public String getJsProfitMargin() {
		return jsProfitMargin;
	}
	public void setJsProfitMargin(String jsProfitMargin) {
		this.jsProfitMargin = jsProfitMargin;
	}
	public Float getPrjActualCost() {
		return prjActualCost;
	}
	public void setPrjActualCost(Float prjActualCost) {
		this.prjActualCost = prjActualCost;
	}
	public Float getAllJsProfit() {
		return allJsProfit;
	}
	public void setAllJsProfit(Float allJsProfit) {
		this.allJsProfit = allJsProfit;
	}
	public Float getAllYsProfit() {
		return allYsProfit;
	}
	public void setAllYsProfit(Float allYsProfit) {
		this.allYsProfit = allYsProfit;
	}
	public String getAllJsProfitMargin() {
		return allJsProfitMargin;
	}
	public void setAllJsProfitMargin(String allJsProfitMargin) {
		this.allJsProfitMargin = allJsProfitMargin;
	}
	public String getAllYsProfitMargin() {
		return allYsProfitMargin;
	}
	public void setAllYsProfitMargin(String allYsProfitMargin) {
		this.allYsProfitMargin = allYsProfitMargin;
	}
	
	
	
	
}
