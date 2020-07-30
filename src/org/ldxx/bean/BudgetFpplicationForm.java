package org.ldxx.bean;

import java.math.BigDecimal;
import java.util.List;

/**
 * 预算申请单
 * @author hp
 *
 */
public class BudgetFpplicationForm {
	
	private String bfId;
	private String bfNo;//预算单编号
	private String prjId;//项目id
	private String taskNo;//任务单号
	private String prjUnit;//甲方单位
	private String prjMode;//项目经营模式
	private String budgetDate;//预算日期
	private String declarer;//申报人
	private String makeTime;//填报时间
	private String state;//数据状态：0 历史数据 ； 1 最新数据
	private BigDecimal allCost;//总预算金额
	private String department;//负责部门id
	private String omName;//部门名称
	private BigDecimal allMainMaterialMoney;//主材料总费用
	
	private List<CostBudget> costBudget;//材料费用
	private List<ArtificialBudget> artificialBudget;//人工费用
	private List<BudgetMainMaterial> budgetMainMaterial;//主材料费
	
    private String ccName;//项目负责人
    private BigDecimal prjEstimateMoney;//任务单金额
    
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
	
    
	public BigDecimal getMainDepartmentMoney() {
		return mainDepartmentMoney;
	}
	public void setMainDepartmentMoney(BigDecimal mainDepartmentMoney) {
		this.mainDepartmentMoney = mainDepartmentMoney;
	}
	public BigDecimal getAssistDepartment1Money() {
		return assistDepartment1Money;
	}
	public void setAssistDepartment1Money(BigDecimal assistDepartment1Money) {
		this.assistDepartment1Money = assistDepartment1Money;
	}
	public BigDecimal getAssistDepartment2Money() {
		return assistDepartment2Money;
	}
	public void setAssistDepartment2Money(BigDecimal assistDepartment2Money) {
		this.assistDepartment2Money = assistDepartment2Money;
	}
	public BigDecimal getAssistDepartment3Money() {
		return assistDepartment3Money;
	}
	public void setAssistDepartment3Money(BigDecimal assistDepartment3Money) {
		this.assistDepartment3Money = assistDepartment3Money;
	}
	public String getMainName() {
		return mainName;
	}
	public void setMainName(String mainName) {
		this.mainName = mainName;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getName3() {
		return name3;
	}
	public void setName3(String name3) {
		this.name3 = name3;
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
	public BigDecimal getPrjEstimateMoney() {
		return prjEstimateMoney;
	}
	public void setPrjEstimateMoney(BigDecimal prjEstimateMoney) {
		this.prjEstimateMoney = prjEstimateMoney;
	}
	public String getPrjMode() {
		return prjMode;
	}
	public void setPrjMode(String prjMode) {
		this.prjMode = prjMode;
	}
	public BigDecimal getAllMainMaterialMoney() {
		return allMainMaterialMoney;
	}
	public void setAllMainMaterialMoney(BigDecimal allMainMaterialMoney) {
		this.allMainMaterialMoney = allMainMaterialMoney;
	}
	public List<BudgetMainMaterial> getBudgetMainMaterial() {
		return budgetMainMaterial;
	}
	public void setBudgetMainMaterial(List<BudgetMainMaterial> budgetMainMaterial) {
		this.budgetMainMaterial = budgetMainMaterial;
	}
	public String getOmName() {
		return omName;
	}
	public void setOmName(String omName) {
		this.omName = omName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public BigDecimal getAllCost() {
		return allCost;
	}
	public void setAllCost(BigDecimal allCost) {
		this.allCost = allCost;
	}
	public String getBfNo() {
		return bfNo;
	}
	public void setBfNo(String bfNo) {
		this.bfNo = bfNo;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMakeTime() {
		return makeTime;
	}
	public void setMakeTime(String makeTime) {
		this.makeTime = makeTime;
	}
	
	public String getCcName() {
		return ccName;
	}
	public void setCcName(String ccName) {
		this.ccName = ccName;
	}
	public List<CostBudget> getCostBudget() {
		return costBudget;
	}
	public void setCostBudget(List<CostBudget> costBudget) {
		this.costBudget = costBudget;
	}
	public List<ArtificialBudget> getArtificialBudget() {
		return artificialBudget;
	}
	public void setArtificialBudget(List<ArtificialBudget> artificialBudget) {
		this.artificialBudget = artificialBudget;
	}
	public String getBfId() {
		return bfId;
	}
	public void setBfId(String bfId) {
		this.bfId = bfId;
	}
	public String getPrjId() {
		return prjId;
	}
	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}
	
	public String getTaskNo() {
		return taskNo;
	}
	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}
	public String getPrjUnit() {
		return prjUnit;
	}
	public void setPrjUnit(String prjUnit) {
		this.prjUnit = prjUnit;
	}
	
	public String getBudgetDate() {
		return budgetDate;
	}
	public void setBudgetDate(String budgetDate) {
		this.budgetDate = budgetDate;
	}
	public String getDeclarer() {
		return declarer;
	}
	public void setDeclarer(String declarer) {
		this.declarer = declarer;
	}
	
	

}
