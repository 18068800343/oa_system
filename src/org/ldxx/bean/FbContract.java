package org.ldxx.bean;

import java.util.List;

public class FbContract {
    private String fbId;

    private String contractName;//合同名称

    private String fbcType;//类型

    private String contractNameJia;//合同甲方

    private String contractNameYi;//合同乙方单位

    private String workNo;//任务单号

    private String prjId;//项目名称

    private String cjContractCode;//承接合同号

    private String cjContractName;//承接合同名称

    private Float mainContractMoney;//主合同金额

    private Float nowFbAllMoney;//已经累计分包金额

    private String contractStartTime;//合同开始时间

    private String contractEndTime;//合同结束时间

    private String mainManageDepartment;//甲方管理部门

    private String contractLongTime;//合同工期

    private String payMode;//付款方式

    private Float contractMoney;//合同金额

    private Float temporaryMoney;//暂定金

    private Float performanceBond;//已收履约保证金
    
    private String workContent;//工作内容
    
    
    private String prjName;//项目名
    private String omName;//部门名称
    private String ccName;//乙方单位名称
    private String cjcontractName2;//承接合同名称
    
    private List<Accessory> accessory;
    
    
    

    

	public String getCjcontractName2() {
		return cjcontractName2;
	}

	public void setCjcontractName2(String cjcontractName2) {
		this.cjcontractName2 = cjcontractName2;
	}

	public String getCcName() {
		return ccName;
	}

	public void setCcName(String ccName) {
		this.ccName = ccName;
	}

	public String getOmName() {
		return omName;
	}

	public void setOmName(String omName) {
		this.omName = omName;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public Float getPerformanceBond() {
		return performanceBond;
	}

	public void setPerformanceBond(Float performanceBond) {
		this.performanceBond = performanceBond;
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

	public String getFbId() {
        return fbId;
    }

    public void setFbId(String fbId) {
        this.fbId = fbId == null ? null : fbId.trim();
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    public String getFbcType() {
        return fbcType;
    }

    public void setFbcType(String fbcType) {
        this.fbcType = fbcType == null ? null : fbcType.trim();
    }

    public String getContractNameJia() {
        return contractNameJia;
    }

    public void setContractNameJia(String contractNameJia) {
        this.contractNameJia = contractNameJia == null ? null : contractNameJia.trim();
    }

    public String getContractNameYi() {
        return contractNameYi;
    }

    public void setContractNameYi(String contractNameYi) {
        this.contractNameYi = contractNameYi == null ? null : contractNameYi.trim();
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo == null ? null : workNo.trim();
    }

    public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}

	public String getCjContractCode() {
        return cjContractCode;
    }

    public void setCjContractCode(String cjContractCode) {
        this.cjContractCode = cjContractCode == null ? null : cjContractCode.trim();
    }

    public String getCjContractName() {
        return cjContractName;
    }

    public void setCjContractName(String cjContractName) {
        this.cjContractName = cjContractName == null ? null : cjContractName.trim();
    }

    public Float getMainContractMoney() {
        return mainContractMoney;
    }

    public void setMainContractMoney(Float mainContractMoney) {
        this.mainContractMoney = mainContractMoney;
    }

    public Float getNowFbAllMoney() {
        return nowFbAllMoney;
    }

    public void setNowFbAllMoney(Float nowFbAllMoney) {
        this.nowFbAllMoney = nowFbAllMoney;
    }

    public String getContractStartTime() {
        return contractStartTime;
    }

    public void setContractStartTime(String contractStartTime) {
        this.contractStartTime = contractStartTime == null ? null : contractStartTime.trim();
    }

    public String getContractEndTime() {
        return contractEndTime;
    }

    public void setContractEndTime(String contractEndTime) {
        this.contractEndTime = contractEndTime == null ? null : contractEndTime.trim();
    }

    public String getMainManageDepartment() {
        return mainManageDepartment;
    }

    public void setMainManageDepartment(String mainManageDepartment) {
        this.mainManageDepartment = mainManageDepartment == null ? null : mainManageDepartment.trim();
    }

    public String getContractLongTime() {
        return contractLongTime;
    }

    public void setContractLongTime(String contractLongTime) {
        this.contractLongTime = contractLongTime == null ? null : contractLongTime.trim();
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode == null ? null : payMode.trim();
    }

    public Float getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(Float contractMoney) {
        this.contractMoney = contractMoney;
    }

    public Float getTemporaryMoney() {
        return temporaryMoney;
    }

    public void setTemporaryMoney(Float temporaryMoney) {
        this.temporaryMoney = temporaryMoney;
    }

}