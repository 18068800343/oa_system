package org.ldxx.bean;

import java.math.BigDecimal;
import java.util.List;

public class ContractWork {
    private String cwId;

    private String prjCode;

    private String cjContractName;

    private String cjContractCode;

    private String contractNameJia;

    private String workText;//工作内容
    
    private String prjText;//项目概况
    
    private String gqText;//实际工期
    
    private String rating;

    private BigDecimal contractMoney;

    private BigDecimal endMoney;
    
    private String cjContractLongTime;//承接合同工期

    private BigDecimal allReceieveMoney;

    private String prjChargeMan;

    private String type;

	private List<Accessory> accessory;
	
	private List<Enterprise> enterprise;
	
	private List<Task> taskArray;
	
	private String prjManager;//项目经理
	private String deputyPrjManager1;//项目副经理1
	private String deputyPrjManager2;//项目副经理2
	private String prjGeneral;//项目总工
	private String prjDuration;//项目工期开始时间
	private String prjDurationEnd;//项目工期结束时间
	private String prjGrade;//公路等级
	
	private String cjContractEndTime;//履约完结时间
	private String xmJinduPiancha;//项目进度偏差
	
	private String contractStartTime;//承接合同开始时间
	private String contractEndTime;//承接合同结束时间
	private String contractLongTime;//承接合同工期
	
	private String starterName;//发起人
    private String status;//审批状态
    private String omName;//主办部门
    private String doDate;//审批时间
    
	
	public String getDoDate() {
		return doDate;
	}

	public void setDoDate(String doDate) {
		this.doDate = doDate;
	}

	public String getOmName() {
		return omName;
	}

	public void setOmName(String omName) {
		this.omName = omName;
	}

	public String getCjContractLongTime() {
		return cjContractLongTime;
	}

	public void setCjContractLongTime(String cjContractLongTime) {
		this.cjContractLongTime = cjContractLongTime;
	}

	public String getXmJinduPiancha() {
		return xmJinduPiancha;
	}

	public void setXmJinduPiancha(String xmJinduPiancha) {
		this.xmJinduPiancha = xmJinduPiancha;
	}

	public String getContractStartTime() {
		return contractStartTime;
	}

	public void setContractStartTime(String contractStartTime) {
		this.contractStartTime = contractStartTime;
	}

	public String getContractEndTime() {
		return contractEndTime;
	}

	public void setContractEndTime(String contractEndTime) {
		this.contractEndTime = contractEndTime;
	}

	public String getContractLongTime() {
		return contractLongTime;
	}

	public void setContractLongTime(String contractLongTime) {
		this.contractLongTime = contractLongTime;
	}

	public List<Task> getTaskArray() {
		return taskArray;
	}

	public void setTaskArray(List<Task> taskArray) {
		this.taskArray = taskArray;
	}

	public String getPrjText() {
		return prjText;
	}

	public void setPrjText(String prjText) {
		this.prjText = prjText;
	}

	public String getGqText() {
		return gqText;
	}

	public void setGqText(String gqText) {
		this.gqText = gqText;
	}

	public String getPrjDurationEnd() {
		return prjDurationEnd;
	}

	public void setPrjDurationEnd(String prjDurationEnd) {
		this.prjDurationEnd = prjDurationEnd;
	}

	public String getCjContractEndTime() {
		return cjContractEndTime;
	}

	public void setCjContractEndTime(String cjContractEndTime) {
		this.cjContractEndTime = cjContractEndTime;
	}

	public String getPrjManager() {
		return prjManager;
	}

	public void setPrjManager(String prjManager) {
		this.prjManager = prjManager;
	}

	public String getDeputyPrjManager1() {
		return deputyPrjManager1;
	}

	public void setDeputyPrjManager1(String deputyPrjManager1) {
		this.deputyPrjManager1 = deputyPrjManager1;
	}

	public String getDeputyPrjManager2() {
		return deputyPrjManager2;
	}

	public void setDeputyPrjManager2(String deputyPrjManager2) {
		this.deputyPrjManager2 = deputyPrjManager2;
	}

	public String getPrjGeneral() {
		return prjGeneral;
	}

	public void setPrjGeneral(String prjGeneral) {
		this.prjGeneral = prjGeneral;
	}

	public String getPrjDuration() {
		return prjDuration;
	}

	public void setPrjDuration(String prjDuration) {
		this.prjDuration = prjDuration;
	}

	public String getPrjGrade() {
		return prjGrade;
	}

	public void setPrjGrade(String prjGrade) {
		this.prjGrade = prjGrade;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public List<Enterprise> getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(List<Enterprise> enterprise) {
		this.enterprise = enterprise;
	}

	public String getCwId() {
		return cwId;
	}

	public void setCwId(String cwId) {
		this.cwId = cwId;
	}

	public String getPrjCode() {
		return prjCode;
	}

	public void setPrjCode(String prjCode) {
		this.prjCode = prjCode;
	}

	public String getCjContractName() {
		return cjContractName;
	}

	public void setCjContractName(String cjContractName) {
		this.cjContractName = cjContractName;
	}

	public String getCjContractCode() {
		return cjContractCode;
	}

	public void setCjContractCode(String cjContractCode) {
		this.cjContractCode = cjContractCode;
	}

	public String getContractNameJia() {
		return contractNameJia;
	}

	public void setContractNameJia(String contractNameJia) {
		this.contractNameJia = contractNameJia;
	}

	public String getWorkText() {
		return workText;
	}

	public void setWorkText(String workText) {
		this.workText = workText;
	}

	public BigDecimal getContractMoney() {
		return contractMoney;
	}

	public void setContractMoney(BigDecimal contractMoney) {
		this.contractMoney = contractMoney;
	}

	public BigDecimal getEndMoney() {
		return endMoney;
	}

	public void setEndMoney(BigDecimal endMoney) {
		this.endMoney = endMoney;
	}

	public BigDecimal getAllReceieveMoney() {
		return allReceieveMoney;
	}

	public void setAllReceieveMoney(BigDecimal allReceieveMoney) {
		this.allReceieveMoney = allReceieveMoney;
	}

	public String getPrjChargeMan() {
		return prjChargeMan;
	}

	public void setPrjChargeMan(String prjChargeMan) {
		this.prjChargeMan = prjChargeMan;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}

	public String getStarterName() {
		return starterName;
	}

	public void setStarterName(String starterName) {
		this.starterName = starterName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}