package org.ldxx.bean;

public class OperationTarget {

	private String otId;
	private double contractAmount;//合同额目标
	private double cjhte;
	private double xqhte;//实际合同额
	private double revenueTarget;//收入目标
	private double sr;//实际收入
	private double collectionTarget;//收款目标
	private double sk;//实际收款
	private double zjcb;//直接成本
	private double jjcb;//间接成本
	private double profit;//利润目标
	private double lr;//实际利润
	private String year;
	
	
	public double getCjhte() {
		return cjhte;
	}
	public void setCjhte(double cjhte) {
		this.cjhte = cjhte;
	}
	public String getOtId() {
		return otId;
	}
	public void setOtId(String otId) {
		this.otId = otId;
	}
	public double getContractAmount() {
		return contractAmount;
	}
	public void setContractAmount(double contractAmount) {
		this.contractAmount = contractAmount;
	}
	public double getXqhte() {
		return xqhte;
	}
	public void setXqhte(double xqhte) {
		this.xqhte = xqhte;
	}
	public double getRevenueTarget() {
		return revenueTarget;
	}
	public void setRevenueTarget(double revenueTarget) {
		this.revenueTarget = revenueTarget;
	}
	public double getSr() {
		return sr;
	}
	public void setSr(double sr) {
		this.sr = sr;
	}
	public double getCollectionTarget() {
		return collectionTarget;
	}
	public void setCollectionTarget(double collectionTarget) {
		this.collectionTarget = collectionTarget;
	}
	public double getSk() {
		return sk;
	}
	public void setSk(double sk) {
		this.sk = sk;
	}
	public double getZjcb() {
		return zjcb;
	}
	public void setZjcb(double zjcb) {
		this.zjcb = zjcb;
	}
	public double getJjcb() {
		return jjcb;
	}
	public void setJjcb(double jjcb) {
		this.jjcb = jjcb;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public double getLr() {
		return lr;
	}
	public void setLr(double lr) {
		this.lr = lr;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
}
