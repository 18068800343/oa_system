package org.ldxx.bean;

public class ReceiveMoney {

	//收款主键id
	private String rmId;
	//甲方单位id
	private String ccId;
	//甲方单位名称
	private String ccName;
	//收款金额
	private Double receiveMoney;
	
	private String rmTime;
	//操作人
	private String doPerson;
	//操作时间
	private String doTime;
	
	private String status;
	
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
	public Double getReceiveMoney() {
		return receiveMoney;
	}
	public void setReceiveMoney(Double receiveMoney) {
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
