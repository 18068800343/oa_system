package org.ldxx.bean;

import java.util.List;

/** 
* @ClassName: PrjClosingAudit 
* @Description: 项目结算审计
* @author zhaohui
* @date 2018年10月29日 上午11:18:28 
*  
*/
public class PrjClosingAudit {

	private String pcId;
	private String prjName;
	private String prjNo;
	private String department;
	private Double endMoney;
	private String evaluate;
	private String prjType;
	private Double contractMoney;
	private String prjStartTime;
	private String prjEndTime;
	
	private List<PrjClosingAuditPerson> person;
	
	public String getPrjType() {
		return prjType;
	}
	public void setPrjType(String prjType) {
		this.prjType = prjType;
	}
	public Double getContractMoney() {
		return contractMoney;
	}
	public void setContractMoney(Double contractMoney) {
		this.contractMoney = contractMoney;
	}
	public String getPrjStartTime() {
		return prjStartTime;
	}
	public void setPrjStartTime(String prjStartTime) {
		this.prjStartTime = prjStartTime;
	}
	public String getPrjEndTime() {
		return prjEndTime;
	}
	public void setPrjEndTime(String prjEndTime) {
		this.prjEndTime = prjEndTime;
	}
	
	public List<PrjClosingAuditPerson> getPerson() {
		return person;
	}
	public void setPerson(List<PrjClosingAuditPerson> person) {
		this.person = person;
	}
	public String getPcId() {
		return pcId;
	}
	public void setPcId(String pcId) {
		this.pcId = pcId;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Double getEndMoney() {
		return endMoney;
	}
	public void setEndMoney(Double endMoney) {
		this.endMoney = endMoney;
	}
	public String getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	
	
}
