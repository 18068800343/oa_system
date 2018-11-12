package org.ldxx.bean;

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
	private String budgetDate;//预算日期
	private String declarer;//申报人
	private String makeTime;//填报时间
	private String state;//数据状态：0 历史数据 ； 1 最新数据
	private float allCost;//总预算金额
	private String department;//负责部门id
	private String omName;//部门名称
	
	private List<CostBudget> costBudget;
	private List<ArtificialBudget> artificialBudget;
	
    private String ccName;//项目负责人
	
	
    
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
	public float getAllCost() {
		return allCost;
	}
	public void setAllCost(float allCost) {
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
