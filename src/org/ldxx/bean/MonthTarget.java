package org.ldxx.bean;

public class MonthTarget {

	private String otId;
	private int month;
	private float contractAmount;
	private float revenueTarget;
	private float collectionTarget;
	
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
