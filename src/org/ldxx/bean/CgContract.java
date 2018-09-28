package org.ldxx.bean;

import java.util.List;

/**
 * 采购合同
 * 
 * @author hp
 *
 */
public class CgContract {
	private String cgId;//编号
	private String contractName;// 采购合同名称
	private String cgNo;//采购合同编号
	private String workNo;// 任务单号
	private String isProgram;// 是否代购
	private String cgcType;// 采购合同类型
	private String cgDepartment;// 采购部门
	private Float departmentCgMoney;// 部门采购金额
	private Float programMoney;// 代购金额
	private Float cgContractMoney;// 采购合同金额
	private String contractNameJia;// 合同甲方名称
	private String contractNameYi;// 乙方
	private String payMode;// 付款方式
	private String contractSignTime;// 采购合同签订时间
	private String contractSummary;// 采购合同概述
	private String workContent;// 主要概况及工作内容

	private List<Accessory> accessory;

	private String omName;// 部门名称
	private String ccName;// 乙方单位名称

	
	
	public String getCgNo() {
		return cgNo;
	}

	public void setCgNo(String cgNo) {
		this.cgNo = cgNo;
	}

	public String getCgId() {
		return cgId;
	}

	public void setCgId(String cgId) {
		this.cgId = cgId;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getWorkNo() {
		return workNo;
	}

	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}

	public String getIsProgram() {
		return isProgram;
	}

	public void setIsProgram(String isProgram) {
		this.isProgram = isProgram;
	}

	public String getCgcType() {
		return cgcType;
	}

	public void setCgcType(String cgcType) {
		this.cgcType = cgcType;
	}

	public String getCgDepartment() {
		return cgDepartment;
	}

	public void setCgDepartment(String cgDepartment) {
		this.cgDepartment = cgDepartment;
	}

	public Float getDepartmentCgMoney() {
		return departmentCgMoney;
	}

	public void setDepartmentCgMoney(Float departmentCgMoney) {
		this.departmentCgMoney = departmentCgMoney;
	}

	public Float getProgramMoney() {
		return programMoney;
	}

	public void setProgramMoney(Float programMoney) {
		this.programMoney = programMoney;
	}

	public Float getCgContractMoney() {
		return cgContractMoney;
	}

	public void setCgContractMoney(Float cgContractMoney) {
		this.cgContractMoney = cgContractMoney;
	}

	public String getContractNameJia() {
		return contractNameJia;
	}

	public void setContractNameJia(String contractNameJia) {
		this.contractNameJia = contractNameJia;
	}

	public String getContractNameYi() {
		return contractNameYi;
	}

	public void setContractNameYi(String contractNameYi) {
		this.contractNameYi = contractNameYi;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getContractSignTime() {
		return contractSignTime;
	}

	public void setContractSignTime(String contractSignTime) {
		this.contractSignTime = contractSignTime;
	}

	public String getContractSummary() {
		return contractSummary;
	}

	public void setContractSummary(String contractSummary) {
		this.contractSummary = contractSummary;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}

	public String getOmName() {
		return omName;
	}

	public void setOmName(String omName) {
		this.omName = omName;
	}

	public String getCcName() {
		return ccName;
	}

	public void setCcName(String ccName) {
		this.ccName = ccName;
	}

}
