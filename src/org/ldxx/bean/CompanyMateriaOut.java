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
	private String type;//出库类型  1：公司出库;2:项目出库;3::结余转出
	private String getPerson;//收货人
	private String getInfos;//验收及处理意见
	private String getStatus;//收货状态 0：未确认收货 1：确认收货
	private String remainType;//结余状态 0 未结余 1 已结余
	private List<Accessory> accessory;
	private List<GsClOut> gsClOut;
	private List<outRemain> oRemain;
	private List<ClRemain> clRemain;
	private List<PrjMaterialBuy> prjMaterialBuy;
	
	private List<MaterialDemand> md;
	
	
	
	public List<PrjMaterialBuy> getPrjMaterialBuy() {
		return prjMaterialBuy;
	}

	public void setPrjMaterialBuy(List<PrjMaterialBuy> prjMaterialBuy) {
		this.prjMaterialBuy = prjMaterialBuy;
	}

	public List<MaterialDemand> getMd() {
		return md;
	}

	public void setMd(List<MaterialDemand> md) {
		this.md = md;
	}

	public List<ClRemain> getClRemain() {
		return clRemain;
	}

	public void setClRemain(List<ClRemain> clRemain) {
		this.clRemain = clRemain;
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
