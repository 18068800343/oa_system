package org.ldxx.bean;

import java.math.BigDecimal;

public class PrjProgressFillCj {

	private String cjId;
	private String cjName;
	private BigDecimal incomeBq;
	private BigDecimal incomeAll;
	private String bq;
	
	public String getCjId() {
		return cjId;
	}
	public void setCjId(String cjId) {
		this.cjId = cjId;
	}
	public String getCjName() {
		return cjName;
	}
	public void setCjName(String cjName) {
		this.cjName = cjName;
	}
	public BigDecimal getIncomeBq() {
		return incomeBq;
	}
	public void setIncomeBq(BigDecimal incomeBq) {
		this.incomeBq = incomeBq;
	}
	public BigDecimal getIncomeAll() {
		return incomeAll;
	}
	public void setIncomeAll(BigDecimal incomeAll) {
		this.incomeAll = incomeAll;
	}
	public String getBq() {
		return bq;
	}
	public void setBq(String bq) {
		this.bq = bq;
	}
	
}
