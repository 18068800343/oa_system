package org.ldxx.bean;

public class DepartmentTarget {

	private String tId;//部门指标id
	private String otId;//公司指标id
	private String omId;//部门id
	private float contractAmount;//合同额目标
	private float revenueTarget;//收入目标
	private float collectionTarget;//收款目标
	private float budgetCost;//预算成本
	private float actualCost;//实际成本
	private String omName;
	private String year;
	private float actualPayment;//实际收款
	private float realIncome;//实际收入
	private float actualContractAmount;//实际合同额
	
	
	public float getActualContractAmount() {
		return actualContractAmount;
	}
	public void setActualContractAmount(float actualContractAmount) {
		this.actualContractAmount = actualContractAmount;
	}
	public float getRealIncome() {
		return realIncome;
	}
	public void setRealIncome(float realIncome) {
		this.realIncome = realIncome;
	}
	public float getActualPayment() {
		return actualPayment;
	}
	public void setActualPayment(float actualPayment) {
		this.actualPayment = actualPayment;
	}
	public float getBudgetCost() {
		return budgetCost;
	}
	public void setBudgetCost(float budgetCost) {
		this.budgetCost = budgetCost;
	}
	public float getActualCost() {
		return actualCost;
	}
	public void setActualCost(float actualCost) {
		this.actualCost = actualCost;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getOmName() {
		return omName;
	}
	public void setOmName(String omName) {
		this.omName = omName;
	}
	public String getOtId() {
		return otId;
	}
	public void setOtId(String otId) {
		this.otId = otId;
	}
	public String gettId() {
		return tId;
	}
	public void settId(String tId) {
		this.tId = tId;
	}
	public String getOmId() {
		return omId;
	}
	public void setOmId(String omId) {
		this.omId = omId;
	}
	public float getContractAmount() {
		return contractAmount;
	}
	public void setContractAmount(float contractAmount) {
		this.contractAmount = contractAmount;
	}
	public float getRevenueTarget() {
		return revenueTarget;
	}
	public void setRevenueTarget(float revenueTarget) {
		this.revenueTarget = revenueTarget;
	}
	public float getCollectionTarget() {
		return collectionTarget;
	}
	public void setCollectionTarget(float collectionTarget) {
		this.collectionTarget = collectionTarget;
	}
	
}
