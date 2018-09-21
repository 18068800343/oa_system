package org.ldxx.bean;

import java.util.List;

public class Task {
    private String prjId;

    private String prjType1;
    
    private String prjType2;

    private String prjNo;

    private String prjName;

    private String prjManagementModel;

    private String prjCompany;

    private String jsPhases;
    
    private String prjOwnerUnit;

    private String workContent;

    private Float prjEstimateMoney;

    private Float contractMoney;

    private Float provisionalSum;

    private String prjStartTime;

    private String prjEndTime;

    private String mainDepartment;

    private Float mainDepartmentMoney;

    private String assistDepartment1;

    private Float assistDepartment1Money;

    private String assistDepartment2;

    private Float assistDepartment2Money;

    private String assistDepartment3;

    private Float assistDepartment3Money;

    private List<Enterprise> enterprise;
    
    private String omName;//主办部门
    private String name1;//协办部门1
    private String name2;//协办部门2
    private String name3;//协办部门3
    
    private String makeTime;
    
    private String ccName;
    
	public String getCcName() {
		return ccName;
	}

	public void setCcName(String ccName) {
		this.ccName = ccName;
	}

	public String getMakeTime() {
		return makeTime;
	}

	public void setMakeTime(String makeTime) {
		this.makeTime = makeTime;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getName3() {
		return name3;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public String getOmName() {
		return omName;
	}

	public void setOmName(String omName) {
		this.omName = omName;
	}

	public List<Enterprise> getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(List<Enterprise> enterprise) {
		this.enterprise = enterprise;
	}

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}


	public String getPrjType1() {
		return prjType1;
	}

	public void setPrjType1(String prjType1) {
		this.prjType1 = prjType1;
	}

	public String getPrjType2() {
		return prjType2;
	}

	public void setPrjType2(String prjType2) {
		this.prjType2 = prjType2;
	}

	public String getPrjNo() {
		return prjNo;
	}

	public void setPrjNo(String prjNo) {
		this.prjNo = prjNo;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getPrjManagementModel() {
		return prjManagementModel;
	}

	public void setPrjManagementModel(String prjManagementModel) {
		this.prjManagementModel = prjManagementModel;
	}

	public String getPrjCompany() {
		return prjCompany;
	}

	public void setPrjCompany(String prjCompany) {
		this.prjCompany = prjCompany;
	}

	public String getJsPhases() {
		return jsPhases;
	}

	public void setJsPhases(String jsPhases) {
		this.jsPhases = jsPhases;
	}

	public String getPrjOwnerUnit() {
		return prjOwnerUnit;
	}

	public void setPrjOwnerUnit(String prjOwnerUnit) {
		this.prjOwnerUnit = prjOwnerUnit;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	public Float getPrjEstimateMoney() {
		return prjEstimateMoney;
	}

	public void setPrjEstimateMoney(Float prjEstimateMoney) {
		this.prjEstimateMoney = prjEstimateMoney;
	}

	public Float getContractMoney() {
		return contractMoney;
	}

	public void setContractMoney(Float contractMoney) {
		this.contractMoney = contractMoney;
	}

	public Float getProvisionalSum() {
		return provisionalSum;
	}

	public void setProvisionalSum(Float provisionalSum) {
		this.provisionalSum = provisionalSum;
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

	public String getMainDepartment() {
		return mainDepartment;
	}

	public void setMainDepartment(String mainDepartment) {
		this.mainDepartment = mainDepartment;
	}

	public Float getMainDepartmentMoney() {
		return mainDepartmentMoney;
	}

	public void setMainDepartmentMoney(Float mainDepartmentMoney) {
		this.mainDepartmentMoney = mainDepartmentMoney;
	}

	public String getAssistDepartment1() {
		return assistDepartment1;
	}

	public void setAssistDepartment1(String assistDepartment1) {
		this.assistDepartment1 = assistDepartment1;
	}

	public Float getAssistDepartment1Money() {
		return assistDepartment1Money;
	}

	public void setAssistDepartment1Money(Float assistDepartment1Money) {
		this.assistDepartment1Money = assistDepartment1Money;
	}

	public String getAssistDepartment2() {
		return assistDepartment2;
	}

	public void setAssistDepartment2(String assistDepartment2) {
		this.assistDepartment2 = assistDepartment2;
	}

	public Float getAssistDepartment2Money() {
		return assistDepartment2Money;
	}

	public void setAssistDepartment2Money(Float assistDepartment2Money) {
		this.assistDepartment2Money = assistDepartment2Money;
	}

	public String getAssistDepartment3() {
		return assistDepartment3;
	}

	public void setAssistDepartment3(String assistDepartment3) {
		this.assistDepartment3 = assistDepartment3;
	}

	public Float getAssistDepartment3Money() {
		return assistDepartment3Money;
	}

	public void setAssistDepartment3Money(Float assistDepartment3Money) {
		this.assistDepartment3Money = assistDepartment3Money;
	}

	@Override
	public String toString() {
		return "Task [prjId=" + prjId + ", prjType1=" + prjType1 + ", prjType2=" + prjType2 + ", prjNo=" + prjNo
				+ ", prjName=" + prjName + ", prjManagementModel=" + prjManagementModel + ", prjCompany=" + prjCompany
				+ ", jsPhases=" + jsPhases + ", prjOwnerUnit=" + prjOwnerUnit + ", workContent=" + workContent
				+ ", prjEstimateMoney=" + prjEstimateMoney + ", contractMoney=" + contractMoney + ", provisionalSum="
				+ provisionalSum + ", prjStartTime=" + prjStartTime + ", prjEndTime=" + prjEndTime + ", mainDepartment="
				+ mainDepartment + ", mainDepartmentMoney=" + mainDepartmentMoney + ", assistDepartment1="
				+ assistDepartment1 + ", assistDepartment1Money=" + assistDepartment1Money + ", assistDepartment2="
				+ assistDepartment2 + ", assistDepartment2Money=" + assistDepartment2Money + ", assistDepartment3="
				+ assistDepartment3 + ", assistDepartment3Money=" + assistDepartment3Money + ", enterprise="
				+ enterprise + "]";
	}


}