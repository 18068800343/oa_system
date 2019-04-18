package org.ldxx.bean;

/** 
* @ClassName: FinancialHk 
* @Description: 财务还款
* @author zhaohui
* @date 2018年11月20日 上午11:02:14 
*  
*/
public class FinancialHk {

	private String hkId;
	private String prjName;
	private String prjNo;
	private String prjLeader;
	private Double hkMoney;
	private String hkType;
	private String hkTime;
	public String getHkId() {
		return hkId;
	}
	public void setHkId(String hkId) {
		this.hkId = hkId;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getPrjNo() {
		return prjNo;
	}
	public void setPrjNo(String prjNo) {
		this.prjNo = prjNo;
	}
	public String getPrjLeader() {
		return prjLeader;
	}
	public void setPrjLeader(String prjLeader) {
		this.prjLeader = prjLeader;
	}
	public Double getHkMoney() {
		return hkMoney;
	}
	public void setHkMoney(Double hkMoney) {
		this.hkMoney = hkMoney;
	}
	public String getHkType() {
		return hkType;
	}
	public void setHkType(String hkType) {
		this.hkType = hkType;
	}
	public String getHkTime() {
		return hkTime;
	}
	public void setHkTime(String hkTime) {
		this.hkTime = hkTime;
	}
	
	
}
