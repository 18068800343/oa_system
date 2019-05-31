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
	private Double  prjJsMoney;//项目结算金额
	private Double  contractJsMoney;//合同结算金额
	private Double  zjFbYsMoney;//直接成本的分包预算金额
	private Double  zjFbJsMoney;//直接成本的分包结算金额
	private Double  zjZcYsMoney;//直接成本的主材预算金额
	private Double  zjZcJsMoney;//直接成本的主材结算金额
	private Double  zjPrjotherYsMoney;//直接成本的项目其他直接成本预算金额
	private Double  zjPrjotherJsMoney;//直接成本的项目其他直接成本结算金额
	private Double  jjPersonMoney;//间接成本的项目人员薪酬金额
	private Double  jjZhejiuMoney;//间接成本的折旧费用金额
	private Double  qtGsGlMoney;//其他摊销费用的公司管理费用
	private Double  qtGsXsMoney;//其他摊销费用的公司销售费用
	private Double  qtTxMoney;//其他摊销费用的其他摊销费用
	private Double  allSubtotal;//总成本
	private Double  allJsProfit;//总成本的结算jing利润(结算利润=项目结算金额-总成本)
	private Double  allYsProfit;//总成本的预算jing利润(预算利润=项目结算金额-预算成本)
	private String allJsProfitMargin;//总成本的结算jing利润率(结算利润率=结算利润/项目结算金额)
	private String allYsProfitMargin;//总成本的预算jing利润率(预算利润率=预算利润/项目结算金额)
	private Double allJsMargin;//结算毛利润（结算毛利润=项目结算金额—直接成本）
	private String allJsMarginLv;//结算毛利润率（结算毛利润率=结算毛利润/项目结算金额 ）
	private Double jcSjMoney;//检测二部直接成本
	
	private List<ProjectAccountingRg> projectAccountingRg;//人员工时
	private String jsState;//结算状态（0:全部结算，1:部分结算，2:未结算）

	private String mainName;//主办部门
    private Double mainDepartmentMoney;
    private String name1;//协办部门1
    private Double assistDepartment1Money;
    private String name2;//协办部门2
    private Double assistDepartment2Money;
    private String name3;//协办部门3
    private Double assistDepartment3Money;
    private String starterName;//发起人
    private String status;//审批状态
	
	
	public String getMainName() {
		return mainName;
	}

	public void setMainName(String mainName) {
		this.mainName = mainName;
	}

	public Double getMainDepartmentMoney() {
		return mainDepartmentMoney;
	}

	public void setMainDepartmentMoney(Double mainDepartmentMoney) {
		this.mainDepartmentMoney = mainDepartmentMoney;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public Double getAssistDepartment1Money() {
		return assistDepartment1Money;
	}

	public void setAssistDepartment1Money(Double assistDepartment1Money) {
		this.assistDepartment1Money = assistDepartment1Money;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public Double getAssistDepartment2Money() {
		return assistDepartment2Money;
	}

	public void setAssistDepartment2Money(Double assistDepartment2Money) {
		this.assistDepartment2Money = assistDepartment2Money;
	}

	public String getName3() {
		return name3;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public Double getAssistDepartment3Money() {
		return assistDepartment3Money;
	}

	public void setAssistDepartment3Money(Double assistDepartment3Money) {
		this.assistDepartment3Money = assistDepartment3Money;
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

	public Double getAllJsMargin() {
		return allJsMargin;
	}

	public void setAllJsMargin(Double allJsMargin) {
		this.allJsMargin = allJsMargin;
	}

	public String getAllJsMarginLv() {
		return allJsMarginLv;
	}

	public void setAllJsMarginLv(String allJsMarginLv) {
		this.allJsMarginLv = allJsMarginLv;
	}

	public String getJsState() {
		return jsState;
	}

	public void setJsState(String jsState) {
		this.jsState = jsState;
	}

	public Double getJcSjMoney() {
		return jcSjMoney;
	}

	public void setJcSjMoney(Double jcSjMoney) {
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

	public Double getAllSubtotal() {
		return allSubtotal;
	}

	public void setAllSubtotal(Double allSubtotal) {
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

	public Double getPrjJsMoney() {
		return prjJsMoney;
	}

	public void setPrjJsMoney(Double prjJsMoney) {
		this.prjJsMoney = prjJsMoney;
	}

	public Double getContractJsMoney() {
		return contractJsMoney;
	}

	public void setContractJsMoney(Double contractJsMoney) {
		this.contractJsMoney = contractJsMoney;
	}

	public Double getZjFbYsMoney() {
		return zjFbYsMoney;
	}

	public void setZjFbYsMoney(Double zjFbYsMoney) {
		this.zjFbYsMoney = zjFbYsMoney;
	}

	public Double getZjFbJsMoney() {
		return zjFbJsMoney;
	}

	public void setZjFbJsMoney(Double zjFbJsMoney) {
		this.zjFbJsMoney = zjFbJsMoney;
	}

	public Double getZjZcYsMoney() {
		return zjZcYsMoney;
	}

	public void setZjZcYsMoney(Double zjZcYsMoney) {
		this.zjZcYsMoney = zjZcYsMoney;
	}

	public Double getZjZcJsMoney() {
		return zjZcJsMoney;
	}

	public void setZjZcJsMoney(Double zjZcJsMoney) {
		this.zjZcJsMoney = zjZcJsMoney;
	}

	public Double getZjPrjotherYsMoney() {
		return zjPrjotherYsMoney;
	}

	public void setZjPrjotherYsMoney(Double zjPrjotherYsMoney) {
		this.zjPrjotherYsMoney = zjPrjotherYsMoney;
	}

	public Double getZjPrjotherJsMoney() {
		return zjPrjotherJsMoney;
	}

	public void setZjPrjotherJsMoney(Double zjPrjotherJsMoney) {
		this.zjPrjotherJsMoney = zjPrjotherJsMoney;
	}

	public Double getJjPersonMoney() {
		return jjPersonMoney;
	}

	public void setJjPersonMoney(Double jjPersonMoney) {
		this.jjPersonMoney = jjPersonMoney;
	}

	public Double getJjZhejiuMoney() {
		return jjZhejiuMoney;
	}

	public void setJjZhejiuMoney(Double jjZhejiuMoney) {
		this.jjZhejiuMoney = jjZhejiuMoney;
	}

	public Double getQtGsGlMoney() {
		return qtGsGlMoney;
	}

	public void setQtGsGlMoney(Double qtGsGlMoney) {
		this.qtGsGlMoney = qtGsGlMoney;
	}

	public Double getQtGsXsMoney() {
		return qtGsXsMoney;
	}

	public void setQtGsXsMoney(Double qtGsXsMoney) {
		this.qtGsXsMoney = qtGsXsMoney;
	}

	public Double getQtTxMoney() {
		return qtTxMoney;
	}

	public void setQtTxMoney(Double qtTxMoney) {
		this.qtTxMoney = qtTxMoney;
	}

	public Double getAllJsProfit() {
		return allJsProfit;
	}

	public void setAllJsProfit(Double allJsProfit) {
		this.allJsProfit = allJsProfit;
	}

	public Double getAllYsProfit() {
		return allYsProfit;
	}

	public void setAllYsProfit(Double allYsProfit) {
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
