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
	private String pickProject;//需求项目
	private String materialName;//材料名称
	private String materialType;//材料类型
	private String specificationModel;//规格型号
	private String cmoUnit;//单位
	private String cmoNumber;// 领料数量
	private Float cmoUnitPrice;//价格
	private Float cmoMoney;//金额
	private String pickDate;//领料日期
	private String omId;//领料人部门
	private String pickPerson;//领料人
	private String cmoDesc;//备注
	
	private String omName;//部门名称
	private String uName; //人员名称
	
	
	
	public String getCgName() {
		return cgName;
	}
	public void setCgName(String cgName) {
		this.cgName = cgName;
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
	public String getTaskNo() {
		return taskNo;
	}
	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getMaterialType() {
		return materialType;
	}
	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}
	public String getSpecificationModel() {
		return specificationModel;
	}
	public void setSpecificationModel(String specificationModel) {
		this.specificationModel = specificationModel;
	}
	public String getCmoUnit() {
		return cmoUnit;
	}
	public void setCmoUnit(String cmoUnit) {
		this.cmoUnit = cmoUnit;
	}
	public String getCmoNumber() {
		return cmoNumber;
	}
	public void setCmoNumber(String cmoNumber) {
		this.cmoNumber = cmoNumber;
	}
	public Float getCmoUnitPrice() {
		return cmoUnitPrice;
	}
	public void setCmoUnitPrice(Float cmoUnitPrice) {
		this.cmoUnitPrice = cmoUnitPrice;
	}
	public Float getCmoMoney() {
		return cmoMoney;
	}
	public void setCmoMoney(Float cmoMoney) {
		this.cmoMoney = cmoMoney;
	}
	public String getPickDate() {
		return pickDate;
	}
	public void setPickDate(String pickDate) {
		this.pickDate = pickDate;
	}
	public String getOmId() {
		return omId;
	}
	public void setOmId(String omId) {
		this.omId = omId;
	}
	public String getPickPerson() {
		return pickPerson;
	}
	public void setPickPerson(String pickPerson) {
		this.pickPerson = pickPerson;
	}
	public String getPickProject() {
		return pickProject;
	}
	public void setPickProject(String pickProject) {
		this.pickProject = pickProject;
	}
	public String getCmoDesc() {
		return cmoDesc;
	}
	public void setCmoDesc(String cmoDesc) {
		this.cmoDesc = cmoDesc;
	}
	public String getOmName() {
		return omName;
	}
	public void setOmName(String omName) {
		this.omName = omName;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	
	
	
}
