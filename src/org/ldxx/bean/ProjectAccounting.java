package org.ldxx.bean;

import java.util.List;

public class ProjectAccounting {
	
	private String paId;
	private String hsNo;//项目核算单编号
	private String prjName;//项目名
	private String prjNo;//项目编号
	private String yezhu;//业主单位
	private String cjDepartment;//承接部门
	private String prjLeader;//项目负责人
	private Float  prjJsMoney;//项目结算金额
	private Float  contractJsMoney;//合同结算金额
	private Float  zjFbYsMoney;//直接成本的分包预算金额
	private Float  zjFbJsMoney;//直接成本的分包结算金额
	private Float  zjZcYsMoney;//直接成本的主材预算金额
	private Float  zjZcJsMoney;//直接成本的主材结算金额
	private Float  zjPrjotherYsMoney;//直接成本的项目其他直接成本预算金额
	private Float  zjPrjotherJsMoney;//直接成本的项目其他直接成本结算金额
	private Float  jjPersonMoney;//间接成本的项目人员薪酬金额
	private Float  jjZhejiuMoney;//间接成本的折旧费用金额
	private Float  qtGsGlMoney;//其他摊销费用的公司管理费用
	private Float  qtGsXsMoney;//其他摊销费用的公司销售费用
	private Float  qtTxMoney;//其他摊销费用的其他摊销费用
	private Float  allSubtotal;//总成本
	private Float  allJsProfit;//总成本的结算利润
	private Float  allYsProfit;//总成本的预算利润
	private String allJsProfitMargin;//总成本的结算利润率
	private String allYsProfitMargin;//总成本的预算利润率
	private Float jcSjMoney;//检测二部直接成本
	
	private List<ProjectAccountingRg> projectAccountingRg;//人员工时
	

	
	public Float getJcSjMoney() {
		return jcSjMoney;
	}

	public void setJcSjMoney(Float jcSjMoney) {
		this.jcSjMoney = jcSjMoney;
	}

	public String getHsNo() {
		return hsNo;
	}

	public void setHsNo(String hsNo) {
		this.hsNo = hsNo;
	}

	public String getPaId() {
		return paId;
	}

	public Float getAllSubtotal() {
		return allSubtotal;
	}

	public void setAllSubtotal(Float allSubtotal) {
		this.allSubtotal = allSubtotal;
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

	public Float getPrjJsMoney() {
		return prjJsMoney;
	}

	public void setPrjJsMoney(Float prjJsMoney) {
		this.prjJsMoney = prjJsMoney;
	}

	public Float getContractJsMoney() {
		return contractJsMoney;
	}

	public void setContractJsMoney(Float contractJsMoney) {
		this.contractJsMoney = contractJsMoney;
	}

	public Float getZjFbYsMoney() {
		return zjFbYsMoney;
	}

	public void setZjFbYsMoney(Float zjFbYsMoney) {
		this.zjFbYsMoney = zjFbYsMoney;
	}

	public Float getZjFbJsMoney() {
		return zjFbJsMoney;
	}

	public void setZjFbJsMoney(Float zjFbJsMoney) {
		this.zjFbJsMoney = zjFbJsMoney;
	}

	public Float getZjZcYsMoney() {
		return zjZcYsMoney;
	}

	public void setZjZcYsMoney(Float zjZcYsMoney) {
		this.zjZcYsMoney = zjZcYsMoney;
	}

	public Float getZjZcJsMoney() {
		return zjZcJsMoney;
	}

	public void setZjZcJsMoney(Float zjZcJsMoney) {
		this.zjZcJsMoney = zjZcJsMoney;
	}

	public Float getZjPrjotherYsMoney() {
		return zjPrjotherYsMoney;
	}

	public void setZjPrjotherYsMoney(Float zjPrjotherYsMoney) {
		this.zjPrjotherYsMoney = zjPrjotherYsMoney;
	}

	public Float getZjPrjotherJsMoney() {
		return zjPrjotherJsMoney;
	}

	public void setZjPrjotherJsMoney(Float zjPrjotherJsMoney) {
		this.zjPrjotherJsMoney = zjPrjotherJsMoney;
	}

	public Float getJjPersonMoney() {
		return jjPersonMoney;
	}

	public void setJjPersonMoney(Float jjPersonMoney) {
		this.jjPersonMoney = jjPersonMoney;
	}

	public Float getJjZhejiuMoney() {
		return jjZhejiuMoney;
	}

	public void setJjZhejiuMoney(Float jjZhejiuMoney) {
		this.jjZhejiuMoney = jjZhejiuMoney;
	}

	public Float getQtGsGlMoney() {
		return qtGsGlMoney;
	}

	public void setQtGsGlMoney(Float qtGsGlMoney) {
		this.qtGsGlMoney = qtGsGlMoney;
	}

	public Float getQtGsXsMoney() {
		return qtGsXsMoney;
	}

	public void setQtGsXsMoney(Float qtGsXsMoney) {
		this.qtGsXsMoney = qtGsXsMoney;
	}

	public Float getQtTxMoney() {
		return qtTxMoney;
	}

	public void setQtTxMoney(Float qtTxMoney) {
		this.qtTxMoney = qtTxMoney;
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

	public List<ProjectAccountingRg> getProjectAccountingRg() {
		return projectAccountingRg;
	}

	public void setProjectAccountingRg(List<ProjectAccountingRg> projectAccountingRg) {
		this.projectAccountingRg = projectAccountingRg;
	}	
	
	
	
	
	
}
