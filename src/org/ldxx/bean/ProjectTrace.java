package org.ldxx.bean;

import java.util.List;

public class ProjectTrace {
    private String ptId;

    private String prjNo;

    private String prjName;

    private String prjStates;

    private String prjLv;

    private String businessType;

    private String prjAddr;

    private String fillTime;

    private String isbid;

    private String traceDepartment;
    
    private Double predictPrjScale;

    private String prjDesc;

    private String ptInfo;

    private String ptUser;

    private List<Accessory> accessory;
    
    private String gzEnd;
    
    private String prjUnit;//业主单位
    
    private List<Enterprise> enterprise;
    
    
    public List<Enterprise> getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(List<Enterprise> enterprise) {
		this.enterprise = enterprise;
	}

	public String getPrjUnit() {
		return prjUnit;
	}

	public void setPrjUnit(String prjUnit) {
		this.prjUnit = prjUnit;
	}

	public String getGzEnd() {
		return gzEnd;
	}

	public void setGzEnd(String gzEnd) {
		this.gzEnd = gzEnd;
	}

	public String getPtId() {
        return ptId;
    }

    public void setPtId(String ptId) {
        this.ptId = ptId == null ? null : ptId.trim();
    }

    public String getPrjNo() {
        return prjNo;
    }

    public void setPrjNo(String prjNo) {
        this.prjNo = prjNo == null ? null : prjNo.trim();
    }

    public String getPrjName() {
        return prjName;
    }

    public void setPrjName(String prjName) {
        this.prjName = prjName == null ? null : prjName.trim();
    }

    public String getPrjStates() {
        return prjStates;
    }

    public void setPrjStates(String prjStates) {
        this.prjStates = prjStates == null ? null : prjStates.trim();
    }

    public String getPrjLv() {
        return prjLv;
    }

    public void setPrjLv(String prjLv) {
        this.prjLv = prjLv == null ? null : prjLv.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getPrjAddr() {
        return prjAddr;
    }

    public void setPrjAddr(String prjAddr) {
        this.prjAddr = prjAddr == null ? null : prjAddr.trim();
    }


    public String getFillTime() {
        return fillTime;
    }

    public void setFillTime(String fillTime) {
        this.fillTime = fillTime == null ? null : fillTime.trim();
    }

    public String getIsbid() {
        return isbid;
    }

    public void setIsbid(String isbid) {
        this.isbid = isbid == null ? null : isbid.trim();
    }


    public String getTraceDepartment() {
		return traceDepartment;
	}

	public void setTraceDepartment(String traceDepartment) {
		this.traceDepartment = traceDepartment;
	}

	public Double getPredictPrjScale() {
		return predictPrjScale;
	}

	public void setPredictPrjScale(Double predictPrjScale) {
		this.predictPrjScale = predictPrjScale;
	}

	public String getPrjDesc() {
        return prjDesc;
    }

    public void setPrjDesc(String prjDesc) {
        this.prjDesc = prjDesc == null ? null : prjDesc.trim();
    }

    public String getPtInfo() {
        return ptInfo;
    }

    public void setPtInfo(String ptInfo) {
        this.ptInfo = ptInfo == null ? null : ptInfo.trim();
    }


	public String getPtUser() {
		return ptUser;
	}

	public void setPtUser(String ptUser) {
		this.ptUser = ptUser;
	}

	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}

}