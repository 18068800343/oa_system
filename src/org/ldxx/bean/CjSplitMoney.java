package org.ldxx.bean;

import java.math.BigDecimal;

//承接合同拆分金额表
public class CjSplitMoney {
	private String cjId;
	private String year;//拆分年份
	private BigDecimal money;//拆分金额
	
	
	public String getCjId() {
		return cjId;
	}
	public void setCjId(String cjId) {
		this.cjId = cjId;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
}
