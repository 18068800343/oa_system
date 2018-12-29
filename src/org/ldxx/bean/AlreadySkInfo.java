package org.ldxx.bean;

import java.util.List;

/**
 * 已认领收款信息
 * @author hp
 *
 */
public class AlreadySkInfo {
	private String cId;
	private String skId;//收款的主键id
	private String prjName;
	private String taskNo;//任务单号 
	private String contractName;
	private String contractNo;//合同单号
	private Float alreadySkMoney;//实际收款金额 
	private Float allSkMoney;//累计收款
	private String time;
	private String operatorPerson;//操作人
	private String years;//年份
	private String yezhu;;//业主单位
	private String prjStartTime;//开始时间
	private String prjEndTime;//结束时间
	private String prjLeader;//项目负责人
	private Float contractMoney;//合同金额
	private Float contractJsMoney;// 合同结算额
	private String contractSkCondition;//合同收款条件
	private String fpNo;//发票编号
	private Float alreadyMoney;//已开票应收金额
	private String prjJindu;//项目完成进度
	private String backDesc;//部门反馈
	private String cdesc;//财务备注信息

	
	private List<AlreadySkOmInfo> asoList;
	private String status;
	
	
	
	public Float getContractMoney() {
		return contractMoney;
	}
	public void setContractMoney(Float contractMoney) {
		this.contractMoney = contractMoney;
	}
	public Float getContractJsMoney() {
		return contractJsMoney;
	}
	public void setContractJsMoney(Float contractJsMoney) {
		this.contractJsMoney = contractJsMoney;
	}
	public Float getAlreadyMoney() {
		return alreadyMoney;
	}
	public void setAlreadyMoney(Float alreadyMoney) {
		this.alreadyMoney = alreadyMoney;
	}
	
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public String getYezhu() {
		return yezhu;
	}
	public void setYezhu(String yezhu) {
		this.yezhu = yezhu;
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
	public String getPrjLeader() {
		return prjLeader;
	}
	public void setPrjLeader(String prjLeader) {
		this.prjLeader = prjLeader;
	}
	
	public String getContractSkCondition() {
		return contractSkCondition;
	}
	public void setContractSkCondition(String contractSkCondition) {
		this.contractSkCondition = contractSkCondition;
	}
	public String getFpNo() {
		return fpNo;
	}
	public void setFpNo(String fpNo) {
		this.fpNo = fpNo;
	}
	
	public String getPrjJindu() {
		return prjJindu;
	}
	public void setPrjJindu(String prjJindu) {
		this.prjJindu = prjJindu;
	}
	
	public String getBackDesc() {
		return backDesc;
	}
	public void setBackDesc(String backDesc) {
		this.backDesc = backDesc;
	}
	public String getCdesc() {
		return cdesc;
	}
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<AlreadySkOmInfo> getAsoList() {
		return asoList;
	}
	public void setAsoList(List<AlreadySkOmInfo> asoList) {
		this.asoList = asoList;
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getSkId() {
		return skId;
	}
	public void setSkId(String skId) {
		this.skId = skId;
	}
	public String getTaskNo() {
		return taskNo;
	}
	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public Float getAlreadySkMoney() {
		return alreadySkMoney;
	}
	public void setAlreadySkMoney(Float alreadySkMoney) {
		this.alreadySkMoney = alreadySkMoney;
	}
	public Float getAllSkMoney() {
		return allSkMoney;
	}
	public void setAllSkMoney(Float allSkMoney) {
		this.allSkMoney = allSkMoney;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getOperatorPerson() {
		return operatorPerson;
	}
	public void setOperatorPerson(String operatorPerson) {
		this.operatorPerson = operatorPerson;
	}
	
	

}
