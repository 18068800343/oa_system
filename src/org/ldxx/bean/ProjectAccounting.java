package org.ldxx.bean;

import java.math.BigDecimal;
import java.util.List;

public class ProjectAccounting {
	
	private String paId;
	private String hsNo;//项目核算单编号
	private String prjName;//项目名
	private String prjNo;//项目编号
	private String yezhu;//业主单位
	private String cjDepartment;//承接部门
	private String prjLeader;//项目负责人
	private BigDecimal  prjJsMoney;//项目结算金额
	private BigDecimal  contractJsMoney;//合同结算金额
	private BigDecimal  zjFbYsMoney;//直接成本的分包预算金额
	private BigDecimal  zjFbJsMoney;//直接成本的分包结算金额
	private BigDecimal  zjZcYsMoney;//直接成本的主材预算金额
	private BigDecimal  zjZcJsMoney;//直接成本的主材结算金额
	private BigDecimal  zjPrjotherYsMoney;//直接成本的项目其他直接成本预算金额
	private BigDecimal  zjPrjotherJsMoney;//直接成本的项目其他直接成本结算金额
	private BigDecimal  jjPersonMoney;//间接成本的项目人员薪酬金额
	private BigDecimal  jjZhejiuMoney;//间接成本的折旧费用金额
	private BigDecimal  qtGsGlMoney;//其他摊销费用的公司管理费用
	private BigDecimal  qtGsXsMoney;//其他摊销费用的公司销售费用
	private BigDecimal  qtTxMoney;//其他摊销费用的其他摊销费用
	private BigDecimal  allSubtotal;//总成本
	private BigDecimal  allJsProfit;//总成本的结算jing利润(结算利润=项目结算金额-总成本)
	private BigDecimal  allYsProfit;//总成本的预算jing利润(预算利润=项目结算金额-预算成本)
	private String allJsProfitMargin;//总成本的结算jing利润率(结算利润率=结算利润/项目结算金额)
	private String allYsProfitMargin;//总成本的预算jing利润率(预算利润率=预算利润/项目结算金额)
	private BigDecimal allJsMargin;//结算毛利润（结算毛利润=项目结算金额—直接成本）
	private String allJsMarginLv;//结算毛利润率（结算毛利润率=结算毛利润/项目结算金额 ）
	private BigDecimal jcSjMoney;//检测二部直接成本
	
	private List<ProjectAccountingRg> projectAccountingRg;//人员工时
	private String jsState;//结算状态（0:全部结算，1:部分结算，2:未结算）

	private String mainName;//主办部门
    private BigDecimal mainDepartmentMoney;
    private String name1;//协办部门1
    private BigDecimal assistDepartment1Money;
    private String name2;//协办部门2
    private BigDecimal assistDepartment2Money;
    private String name3;//协办部门3
    private BigDecimal assistDepartment3Money;
    private String starterName;//发起人
    private String status;//审批状态
	
	
	public String getMainName() {
		return mainName;
	}

	public void setMainName(String mainName) {
		this.mainName = mainName;
	}

	public BigDecimal getMainDepartmentMoney() {
		return mainDepartmentMoney;
	}

	public void setMainDepartmentMoney(BigDecimal mainDepartmentMoney) {
		this.mainDepartmentMoney = mainDepartmentMoney;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public BigDecimal getAssistDepartment1Money() {
		return assistDepartment1Money;
	}

	public void setAssistDepartment1Money(BigDecimal assistDepartment1Money) {
		this.assistDepartment1Money = assistDepartment1Money;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public BigDecimal getAssistDepartment2Money() {
		return assistDepartment2Money;
	}

	public void setAssistDepartment2Money(BigDecimal assistDepartment2Money) {
		this.assistDepartment2Money = assistDepartment2Money;
	}

	public String getName3() {
		return name3;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public BigDecimal getAssistDepartment3Money() {
		return assistDepartment3Money;
	}

	public void setAssistDepartment3Money(BigDecimal assistDepartment3Money) {
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

	public BigDecimal getAllJsMargin() {
		return allJsMargin;
	}

	public void setAllJsMargin(BigDecimal allJsMargin) {
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

	public BigDecimal getJcSjMoney() {
		return jcSjMoney;
	}

	public void setJcSjMoney(BigDecimal jcSjMoney) {
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

	public BigDecimal getAllSubtotal() {
		return allSubtotal;
	}

	public void setAllSubtotal(BigDecimal allSubtotal) {
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

	public BigDecimal getPrjJsMoney() {
		return prjJsMoney;
	}

	public void setPrjJsMoney(BigDecimal prjJsMoney) {
		this.prjJsMoney = prjJsMoney;
	}

	public BigDecimal getContractJsMoney() {
		return contractJsMoney;
	}

	public void setContractJsMoney(BigDecimal contractJsMoney) {
		this.contractJsMoney = contractJsMoney;
	}

	public BigDecimal getZjFbYsMoney() {
		return zjFbYsMoney;
	}

	public void setZjFbYsMoney(BigDecimal zjFbYsMoney) {
		this.zjFbYsMoney = zjFbYsMoney;
	}

	public BigDecimal getZjFbJsMoney() {
		return zjFbJsMoney;
	}

	public void setZjFbJsMoney(BigDecimal zjFbJsMoney) {
		this.zjFbJsMoney = zjFbJsMoney;
	}

	public BigDecimal getZjZcYsMoney() {
		return zjZcYsMoney;
	}

	public void setZjZcYsMoney(BigDecimal zjZcYsMoney) {
		this.zjZcYsMoney = zjZcYsMoney;
	}

	public BigDecimal getZjZcJsMoney() {
		return zjZcJsMoney;
	}

	public void setZjZcJsMoney(BigDecimal zjZcJsMoney) {
		this.zjZcJsMoney = zjZcJsMoney;
	}

	public BigDecimal getZjPrjotherYsMoney() {
		return zjPrjotherYsMoney;
	}

	public void setZjPrjotherYsMoney(BigDecimal zjPrjotherYsMoney) {
		this.zjPrjotherYsMoney = zjPrjotherYsMoney;
	}

	public BigDecimal getZjPrjotherJsMoney() {
		return zjPrjotherJsMoney;
	}

	public void setZjPrjotherJsMoney(BigDecimal zjPrjotherJsMoney) {
		this.zjPrjotherJsMoney = zjPrjotherJsMoney;
	}

	public BigDecimal getJjPersonMoney() {
		return jjPersonMoney;
	}

	public void setJjPersonMoney(BigDecimal jjPersonMoney) {
		this.jjPersonMoney = jjPersonMoney;
	}

	public BigDecimal getJjZhejiuMoney() {
		return jjZhejiuMoney;
	}

	public void setJjZhejiuMoney(BigDecimal jjZhejiuMoney) {
		this.jjZhejiuMoney = jjZhejiuMoney;
	}

	public BigDecimal getQtGsGlMoney() {
		return qtGsGlMoney;
	}

	public void setQtGsGlMoney(BigDecimal qtGsGlMoney) {
		this.qtGsGlMoney = qtGsGlMoney;
	}

	public BigDecimal getQtGsXsMoney() {
		return qtGsXsMoney;
	}

	public void setQtGsXsMoney(BigDecimal qtGsXsMoney) {
		this.qtGsXsMoney = qtGsXsMoney;
	}

	public BigDecimal getQtTxMoney() {
		return qtTxMoney;
	}

	public void setQtTxMoney(BigDecimal qtTxMoney) {
		this.qtTxMoney = qtTxMoney;
	}

	public BigDecimal getAllJsProfit() {
		return allJsProfit;
	}

	public void setAllJsProfit(BigDecimal allJsProfit) {
		this.allJsProfit = allJsProfit;
	}

	public BigDecimal getAllYsProfit() {
		return allYsProfit;
	}

	public void setAllYsProfit(BigDecimal allYsProfit) {
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
