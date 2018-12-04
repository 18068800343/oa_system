package org.ldxx.bean;

public class OperationTarget {

	private String otId;
	private float contractAmount;//合同额目标
	private float revenueTarget;//收入目标
	private float collectionTarget;//收款目标
	private float budgetCost;//预算成本
	private float actualCost;//实际成本
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
	public float getActualPayment() {
		return actualPayment;
	}
	public void setActualPayment(float actualPayment) {
		this.actualPayment = actualPayment;
	}
	public float getRealIncome() {
		return realIncome;
	}
	public void setRealIncome(float realIncome) {
		this.realIncome = realIncome;
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
	public String getOtId() {
		return otId;
	}
	public void setOtId(String otId) {
		this.otId = otId;
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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "OperationTarget [otId=" + otId + ", contractAmount=" + contractAmount + ", revenueTarget="
				+ revenueTarget + ", collectionTarget=" + collectionTarget + ", year=" + year + "]";
	}
	
	
}
