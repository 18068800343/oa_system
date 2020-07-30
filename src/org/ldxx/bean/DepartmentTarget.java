package org.ldxx.bean;

import java.math.BigDecimal;

public class DepartmentTarget {

	private String tId;//部门指标id
	private String otId;//公司指标id
	private String omId;//部门id
	private String bmmc;//部门名称
	private String year;//年份
	private BigDecimal contractAmount;//合同额目标
	private BigDecimal xqhte;//实际合同额
	private BigDecimal revenueTarget;//收入目标
	private BigDecimal sr;//实际收入
	private BigDecimal collectionTarget;//收款目标
	private BigDecimal sk;//实际收款
	private BigDecimal zjcb;//直接成本
	private BigDecimal jjcb;//间接成本
	private BigDecimal profit;//利润目标
	private BigDecimal lr;//实际利润
	private BigDecimal cjhte;
	
	
	
	public BigDecimal getCjhte() {
		return cjhte;
	}
	public void setCjhte(BigDecimal cjhte) {
		this.cjhte = cjhte;
	}
	public String gettId() {
		return tId;
	}
	public void settId(String tId) {
		this.tId = tId;
	}
	public String getOtId() {
		return otId;
	}
	public void setOtId(String otId) {
		this.otId = otId;
	}
	public String getOmId() {
		return omId;
	}
	public void setOmId(String omId) {
		this.omId = omId;
	}
	public String getBmmc() {
		return bmmc;
	}
	public void setBmmc(String bmmc) {
		this.bmmc = bmmc;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public BigDecimal getContractAmount() {
		return contractAmount;
	}
	public void setContractAmount(BigDecimal contractAmount) {
		this.contractAmount = contractAmount;
	}
	public BigDecimal getXqhte() {
		return xqhte;
	}
	public void setXqhte(BigDecimal xqhte) {
		this.xqhte = xqhte;
	}
	public BigDecimal getRevenueTarget() {
		return revenueTarget;
	}
	public void setRevenueTarget(BigDecimal revenueTarget) {
		this.revenueTarget = revenueTarget;
	}
	public BigDecimal getSr() {
		return sr;
	}
	public void setSr(BigDecimal sr) {
		this.sr = sr;
	}
	public BigDecimal getCollectionTarget() {
		return collectionTarget;
	}
	public void setCollectionTarget(BigDecimal collectionTarget) {
		this.collectionTarget = collectionTarget;
	}
	public BigDecimal getSk() {
		return sk;
	}
	public void setSk(BigDecimal sk) {
		this.sk = sk;
	}
	public BigDecimal getZjcb() {
		return zjcb;
	}
	public void setZjcb(BigDecimal zjcb) {
		this.zjcb = zjcb;
	}
	public BigDecimal getJjcb() {
		return jjcb;
	}
	public void setJjcb(BigDecimal jjcb) {
		this.jjcb = jjcb;
	}
	public BigDecimal getProfit() {
		return profit;
	}
	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}
	public BigDecimal getLr() {
		return lr;
	}
	public void setLr(BigDecimal lr) {
		this.lr = lr;
	}
	
}
