package org.ldxx.bean;

import java.math.BigDecimal;

public class MonthTarget {

	private String otId;
	private int month;
	private BigDecimal contractAmount;
	private BigDecimal revenueTarget;
	private BigDecimal collectionTarget;
	private BigDecimal profit;
	
	
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
	public BigDecimal getContractAmount() {
		return contractAmount;
	}
	public void setContractAmount(BigDecimal contractAmount) {
		this.contractAmount = contractAmount;
	}
	public BigDecimal getRevenueTarget() {
		return revenueTarget;
	}
	public void setRevenueTarget(BigDecimal revenueTarget) {
		this.revenueTarget = revenueTarget;
	}
	public BigDecimal getCollectionTarget() {
		return collectionTarget;
	}
	public void setCollectionTarget(BigDecimal collectionTarget) {
		this.collectionTarget = collectionTarget;
	}
	public BigDecimal getProfit() {
		return profit;
	}
	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}
	
}
