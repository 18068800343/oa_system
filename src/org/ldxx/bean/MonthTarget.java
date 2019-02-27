package org.ldxx.bean;

public class MonthTarget {

	private String otId;
	private int month;
	private double contractAmount;
	private double revenueTarget;
	private double collectionTarget;
	private double profit;
	
	
	public String getOtId() {
		return otId;
	}
	public void setOtId(String otId) {
		this.otId = otId;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public double getContractAmount() {
		return contractAmount;
	}
	public void setContractAmount(double contractAmount) {
		this.contractAmount = contractAmount;
	}
	public double getRevenueTarget() {
		return revenueTarget;
	}
	public void setRevenueTarget(double revenueTarget) {
		this.revenueTarget = revenueTarget;
	}
	public double getCollectionTarget() {
		return collectionTarget;
	}
	public void setCollectionTarget(double collectionTarget) {
		this.collectionTarget = collectionTarget;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	
}
