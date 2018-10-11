package org.ldxx.bean;

import java.util.List;

public class ContractWork {
    private String cwId;

    private String prjCode;

    private String cjContractName;

    private String cjContractCode;

    private String contractNameJia;
    private String jiaFang;

    private String workText;
    
    private String rating;

    private Float contractMoney;

    private Float endMoney;

    private Float allReceieveMoney;

    private String prjChargeMan;

    private String type;

    private String mainDepartment;
	private String name;
	
	private float mainDepartmentMoney;
	
	private String assistDepartment1;
	private String name2;
	
	private float assistDepartment1Money;
	
	private String assistDepartment2;
	private String name3;
	
	private float assistDepartment2Money;
	
	private String assistDepartment3;
	private String name4;
	
	private float assistDepartment3Money;
	
	private List<Accessory> accessory;
	
	private List<Enterprise> enterprise;
	

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getJiaFang() {
		return jiaFang;
	}

	public void setJiaFang(String jiaFang) {
		this.jiaFang = jiaFang;
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

	public Float getContractMoney() {
		return contractMoney;
	}

	public void setContractMoney(Float contractMoney) {
		this.contractMoney = contractMoney;
	}

	public Float getEndMoney() {
		return endMoney;
	}

	public void setEndMoney(Float endMoney) {
		this.endMoney = endMoney;
	}

	public Float getAllReceieveMoney() {
		return allReceieveMoney;
	}

	public void setAllReceieveMoney(Float allReceieveMoney) {
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

	public String getMainDepartment() {
		return mainDepartment;
	}

	public void setMainDepartment(String mainDepartment) {
		this.mainDepartment = mainDepartment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMainDepartmentMoney() {
		return mainDepartmentMoney;
	}

	public void setMainDepartmentMoney(float mainDepartmentMoney) {
		this.mainDepartmentMoney = mainDepartmentMoney;
	}

	public String getAssistDepartment1() {
		return assistDepartment1;
	}

	public void setAssistDepartment1(String assistDepartment1) {
		this.assistDepartment1 = assistDepartment1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public float getAssistDepartment1Money() {
		return assistDepartment1Money;
	}

	public void setAssistDepartment1Money(float assistDepartment1Money) {
		this.assistDepartment1Money = assistDepartment1Money;
	}

	public String getAssistDepartment2() {
		return assistDepartment2;
	}

	public void setAssistDepartment2(String assistDepartment2) {
		this.assistDepartment2 = assistDepartment2;
	}

	public String getName3() {
		return name3;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public float getAssistDepartment2Money() {
		return assistDepartment2Money;
	}

	public void setAssistDepartment2Money(float assistDepartment2Money) {
		this.assistDepartment2Money = assistDepartment2Money;
	}

	public String getAssistDepartment3() {
		return assistDepartment3;
	}

	public void setAssistDepartment3(String assistDepartment3) {
		this.assistDepartment3 = assistDepartment3;
	}

	public String getName4() {
		return name4;
	}

	public void setName4(String name4) {
		this.name4 = name4;
	}

	public float getAssistDepartment3Money() {
		return assistDepartment3Money;
	}

	public void setAssistDepartment3Money(float assistDepartment3Money) {
		this.assistDepartment3Money = assistDepartment3Money;
	}

	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}

	@Override
	public String toString() {
		return "ContractWork [cwId=" + cwId + ", prjCode=" + prjCode + ", cjContractName=" + cjContractName
				+ ", cjContractCode=" + cjContractCode + ", contractNameJia=" + contractNameJia + ", workText="
				+ workText + ", contractMoney=" + contractMoney + ", endMoney=" + endMoney + ", allReceieveMoney="
				+ allReceieveMoney + ", prjChargeMan=" + prjChargeMan + ", type=" + type + ", mainDepartment="
				+ mainDepartment + ", name=" + name + ", mainDepartmentMoney=" + mainDepartmentMoney
				+ ", assistDepartment1=" + assistDepartment1 + ", name2=" + name2 + ", assistDepartment1Money="
				+ assistDepartment1Money + ", assistDepartment2=" + assistDepartment2 + ", name3=" + name3
				+ ", assistDepartment2Money=" + assistDepartment2Money + ", assistDepartment3=" + assistDepartment3
				+ ", name4=" + name4 + ", assistDepartment3Money=" + assistDepartment3Money + ", accessory=" + accessory
				+ ", enterprise=" + enterprise + "]";
	}

}