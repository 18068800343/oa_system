package org.ldxx.bean;

import java.util.List;

public class FbContractOverWj {
    private String fcowId;

    private String fbContractName;//分包合同名称

    private String fbContract;//分包合同

    private String prjCode;//任务单号

    private String prjChargePerson;//项目负责人

    private String cjContractName;//承接合同名称

    private String cjContract;//承接合同

    private String contractNameYi;//合同乙方单位
    
    private String yiFang;//乙方名称

    private String fbChargePerson;//分包合同负责人

    private String prjProbablyText;//项目概况

    private Double contractMoney;//合同金额

    private Double provisionalMoney;//暂定金

    private Double overWorkMoney;//结算金额

    private String overWorkExplain;//结算说明

    private Double allPayMoney;//累计付款

    private String doAppointScore;//履约评级
    
    private List<Accessory> accessory;
    private List<Accessory> accessory1;//法律顾问签字


    
    public List<Accessory> getAccessory1() {
		return accessory1;
	}

	public void setAccessory1(List<Accessory> accessory1) {
		this.accessory1 = accessory1;
	}

	public String getYiFang() {
		return yiFang;
	}

	public void setYiFang(String yiFang) {
		this.yiFang = yiFang;
	}

	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}

	public String getFcowId() {
        return fcowId;
    }

    public void setFcowId(String fcowId) {
        this.fcowId = fcowId == null ? null : fcowId.trim();
    }

    public String getFbContractName() {
        return fbContractName;
    }

    public void setFbContractName(String fbContractName) {
        this.fbContractName = fbContractName == null ? null : fbContractName.trim();
    }

    public String getFbContract() {
        return fbContract;
    }

    public void setFbContract(String fbContract) {
        this.fbContract = fbContract == null ? null : fbContract.trim();
    }

    public String getPrjCode() {
        return prjCode;
    }

    public void setPrjCode(String prjCode) {
        this.prjCode = prjCode == null ? null : prjCode.trim();
    }

    public String getPrjChargePerson() {
        return prjChargePerson;
    }

    public void setPrjChargePerson(String prjChargePerson) {
        this.prjChargePerson = prjChargePerson == null ? null : prjChargePerson.trim();
    }

    public String getCjContractName() {
        return cjContractName;
    }

    public void setCjContractName(String cjContractName) {
        this.cjContractName = cjContractName == null ? null : cjContractName.trim();
    }

    public String getCjContract() {
        return cjContract;
    }

    public void setCjContract(String cjContract) {
        this.cjContract = cjContract == null ? null : cjContract.trim();
    }

    public String getContractNameYi() {
        return contractNameYi;
    }

    public void setContractNameYi(String contractNameYi) {
        this.contractNameYi = contractNameYi == null ? null : contractNameYi.trim();
    }

    public String getFbChargePerson() {
        return fbChargePerson;
    }

    public void setFbChargePerson(String fbChargePerson) {
        this.fbChargePerson = fbChargePerson == null ? null : fbChargePerson.trim();
    }

    public String getPrjProbablyText() {
        return prjProbablyText;
    }

    public void setPrjProbablyText(String prjProbablyText) {
        this.prjProbablyText = prjProbablyText == null ? null : prjProbablyText.trim();
    }


    public Double getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(Double contractMoney) {
        this.contractMoney = contractMoney;
    }

    public Double getProvisionalMoney() {
        return provisionalMoney;
    }

    public void setProvisionalMoney(Double provisionalMoney) {
        this.provisionalMoney = provisionalMoney;
    }

    public Double getOverWorkMoney() {
        return overWorkMoney;
    }

    public void setOverWorkMoney(Double overWorkMoney) {
        this.overWorkMoney = overWorkMoney;
    }

    public String getOverWorkExplain() {
        return overWorkExplain;
    }

    public void setOverWorkExplain(String overWorkExplain) {
        this.overWorkExplain = overWorkExplain == null ? null : overWorkExplain.trim();
    }

    public Double getAllPayMoney() {
        return allPayMoney;
    }

    public void setAllPayMoney(Double allPayMoney) {
        this.allPayMoney = allPayMoney;
    }

    public String getDoAppointScore() {
        return doAppointScore;
    }

    public void setDoAppointScore(String doAppointScore) {
        this.doAppointScore = doAppointScore == null ? null : doAppointScore.trim();
    }

}