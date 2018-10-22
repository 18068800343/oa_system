package org.ldxx.bean;

import java.util.List;

/**
 * 公司材料出库
 * @author hp
 */

public class CompanyMateriaOut {

	private String cmoId;
	private String cgNo;//采购合同号
	private String cgName;//采购合同名
	private String taskNo;//任务单号
	private String pickProject;//领料项目
	private String pickDate;//领料日期
	private String pickPerson;//领料人
	private String cmoDesc;//备注
	private String type;//出库类型  1：公司出库
	private String getPerson;//收货人
	private String getInfos;//验收及处理意见
	private String getStatus;//收货状态 0：未确认收货 1：确认收货
	private String remainType;//结余状态 0 未结余 1 已结余
	private List<Accessory> accessory;
	private List<GsClOut> gsClOut;
	private List<outRemain> oRemain;
	private List<ClRemain> clRemain;
	
	private String disposePerson; //废旧处理申请人
	private String disposeTime;//废旧处理时间
	private String disposeReason;//废旧处理原因
	private String disposeType;//处理类型
	private String disposeMoney;//处理费用
	private String disposeDesc;//备注
	private String disposeStatus;//处理状态
	
	
	public List<ClRemain> getClRemain() {
		return clRemain;
	}

	public void setClRemain(List<ClRemain> clRemain) {
		this.clRemain = clRemain;
	}

	public String getDisposePerson() {
		return disposePerson;
	}

	public void setDisposePerson(String disposePerson) {
		this.disposePerson = disposePerson;
	}

	public String getDisposeTime() {
		return disposeTime;
	}

	public void setDisposeTime(String disposeTime) {
		this.disposeTime = disposeTime;
	}

	public String getDisposeReason() {
		return disposeReason;
	}

	public void setDisposeReason(String disposeReason) {
		this.disposeReason = disposeReason;
	}

	public String getDisposeType() {
		return disposeType;
	}

	public void setDisposeType(String disposeType) {
		this.disposeType = disposeType;
	}

	public String getDisposeMoney() {
		return disposeMoney;
	}

	public void setDisposeMoney(String disposeMoney) {
		this.disposeMoney = disposeMoney;
	}

	public String getDisposeDesc() {
		return disposeDesc;
	}

	public void setDisposeDesc(String disposeDesc) {
		this.disposeDesc = disposeDesc;
	}

	public String getDisposeStatus() {
		return disposeStatus;
	}

	public void setDisposeStatus(String disposeStatus) {
		this.disposeStatus = disposeStatus;
	}

	public List<outRemain> getoRemain() {
		return oRemain;
	}

	public void setoRemain(List<outRemain> oRemain) {
		this.oRemain = oRemain;
	}

	public List<GsClOut> getGsClOut() {
		return gsClOut;
	}

	public void setGsClOut(List<GsClOut> gsClOut) {
		this.gsClOut = gsClOut;
	}

	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}
	
	public String getCmoId() {
		return cmoId;
	}
	
	public void setCmoId(String cmoId) {
		this.cmoId = cmoId;
	}

	public String getCgNo() {
		return cgNo;
	}

	public void setCgNo(String cgNo) {
		this.cgNo = cgNo;
	}

	public String getCgName() {
		return cgName;
	}

	public void setCgName(String cgName) {
		this.cgName = cgName;
	}

	public String getTaskNo() {
		return taskNo;
	}

	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}

	public String getPickProject() {
		return pickProject;
	}

	public void setPickProject(String pickProject) {
		this.pickProject = pickProject;
	}

	public String getPickDate() {
		return pickDate;
	}

	public void setPickDate(String pickDate) {
		this.pickDate = pickDate;
	}

	public String getPickPerson() {
		return pickPerson;
	}

	public void setPickPerson(String pickPerson) {
		this.pickPerson = pickPerson;
	}

	public String getCmoDesc() {
		return cmoDesc;
	}

	public void setCmoDesc(String cmoDesc) {
		this.cmoDesc = cmoDesc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGetPerson() {
		return getPerson;
	}

	public void setGetPerson(String getPerson) {
		this.getPerson = getPerson;
	}

	public String getGetInfos() {
		return getInfos;
	}

	public void setGetInfos(String getInfos) {
		this.getInfos = getInfos;
	}

	public String getGetStatus() {
		return getStatus;
	}

	public void setGetStatus(String getStatus) {
		this.getStatus = getStatus;
	}

	public String getRemainType() {
		return remainType;
	}

	public void setRemainType(String remainType) {
		this.remainType = remainType;
	}

	
}
