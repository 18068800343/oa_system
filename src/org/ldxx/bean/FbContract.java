package org.ldxx.bean;

import java.util.List;

public class FbContract {
    private String fbId;

    private String contractName;//合同名称
    
    private String fbNo;// 分包合同编号

    private String fbcType;//类型

    private String contractNameJia;//合同甲方

    private String contractNameYi;//合同乙方单位

    private String workNo;//任务单号

    private String prjName;//项目名称

    private String cjContractCode;//承接合同号

    private String cjContractName;//承接合同名称

    private Double mainContractMoney;//主合同金额

    private Double nowFbAllMoney;//已经累计分包金额

    private String contractStartTime;//合同开始时间

    private String contractEndTime;//合同结束时间

    private String mainManageDepartment;//甲方管理部门

    private String contractLongTime;//合同工期

    private String payMode;//付款方式

    private Double contractMoney;//合同金额

    private Double temporaryMoney;//暂定金

    private Double performanceBond;//已收履约保证金
    
    private String workContent;//工作内容
    private String makeTime; //当前时间
    private String history;//历史状态
    private String rate;//税率
    private String rateType;//税票类型
    private String cancelReason;//终止原因
    
    private String omName;//部门名称
    private String ccName;//乙方单位名称
    
    private List<Accessory> accessory;
    private List<Accessory> accessory1;//法律顾问签字
    
    private String sm;
    
    private String starterName;//发起人
    private String status;//审批状态

    
    public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getSm() {
		return sm;
	}

	public void setSm(String sm) {
		this.sm = sm;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getRateType() {
		return rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public List<Accessory> getAccessory1() {
		return accessory1;
	}

	public void setAccessory1(List<Accessory> accessory1) {
		this.accessory1 = accessory1;
	}

	public String getMakeTime() {
		return makeTime;
	}

	public void setMakeTime(String makeTime) {
		this.makeTime = makeTime;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getFbNo() {
		return fbNo;
	}

	public void setFbNo(String fbNo) {
		this.fbNo = fbNo;
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


	public Double getPerformanceBond() {
		return performanceBond;
	}

	public void setPerformanceBond(Double performanceBond) {
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

   

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
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

    public Double getMainContractMoney() {
        return mainContractMoney;
    }

    public void setMainContractMoney(Double mainContractMoney) {
        this.mainContractMoney = mainContractMoney;
    }

    public Double getNowFbAllMoney() {
        return nowFbAllMoney;
    }

    public void setNowFbAllMoney(Double nowFbAllMoney) {
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

    public Double getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(Double contractMoney) {
        this.contractMoney = contractMoney;
    }

    public Double getTemporaryMoney() {
        return temporaryMoney;
    }

    public void setTemporaryMoney(Double temporaryMoney) {
        this.temporaryMoney = temporaryMoney;
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