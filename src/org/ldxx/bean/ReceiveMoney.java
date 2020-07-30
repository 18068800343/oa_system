package org.ldxx.bean;

import java.math.BigDecimal;

public class ReceiveMoney {

	//收款主键id
	private String rmId;
	//甲方单位id
	private String ccId;
	//甲方单位名称
	private String ccName;
	//收款金额
	private BigDecimal receiveMoney;
	//收款时间
	private String rmTime;
	//操作人
	private String doPerson;
	//操作时间
	private String doTime;
	private String status;//0：尚未确认，1：部分确认，2：正常确认
	private String skNo;//收款编号
	private String rmDesc;//收款摘要
	private BigDecimal leijiquerenMoney;//累计确认金额
	private BigDecimal shengyuMoney;//剩余金额
	
	
	
	public BigDecimal getShengyuMoney() {
		return shengyuMoney;
	}
	public void setShengyuMoney(BigDecimal shengyuMoney) {
		this.shengyuMoney = shengyuMoney;
	}
	public BigDecimal getLeijiquerenMoney() {
		return leijiquerenMoney;
	}
	public void setLeijiquerenMoney(BigDecimal leijiquerenMoney) {
		this.leijiquerenMoney = leijiquerenMoney;
	}
	public String getSkNo() {
		return skNo;
	}
	public void setSkNo(String skNo) {
		this.skNo = skNo;
	}
	public String getRmDesc() {
		return rmDesc;
	}
	public void setRmDesc(String rmDesc) {
		this.rmDesc = rmDesc;
	}
	public String getRmTime() {
		return rmTime;
	}
	public void setRmTime(String rmTime) {
		this.rmTime = rmTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRmId() {
		return rmId;
	}
	public void setRmId(String rmId) {
		this.rmId = rmId;
	}
	public String getCcId() {
		return ccId;
	}
	public void setCcId(String ccId) {
		this.ccId = ccId;
	}
	public String getCcName() {
		return ccName;
	}
	public void setCcName(String ccName) {
		this.ccName = ccName;
	}
	public BigDecimal getReceiveMoney() {
		return receiveMoney;
	}
	public void setReceiveMoney(BigDecimal receiveMoney) {
		this.receiveMoney = receiveMoney;
	}
	public String getDoPerson() {
		return doPerson;
	}
	public void setDoPerson(String doPerson) {
		this.doPerson = doPerson;
	}
	public String getDoTime() {
		return doTime;
	}
	public void setDoTime(String doTime) {
		this.doTime = doTime;
	}
	@Override
	public String toString() {
		return "ReceiveMoney [rmId=" + rmId + ", ccId=" + ccId + ", ccName=" + ccName + ", receiveMoney=" + receiveMoney
				+ ", doPerson=" + doPerson + ", doTime=" + doTime + "]";
	}
}
