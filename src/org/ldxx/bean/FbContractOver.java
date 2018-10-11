package org.ldxx.bean;

import java.util.List;

public class FbContractOver {/*分包结算申请*/
    private String fcoId;

    private String prjCode;

    private String prjName;

    private String cjContract;

    private String fbContract;

    private String settlementType;

    private String settlementTime;
    
    private String workInfo;
    
    private List<Accessory> accessory;
    

    public String getWorkInfo() {
		return workInfo;
	}

	public void setWorkInfo(String workInfo) {
		this.workInfo = workInfo;
	}

	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}

	public String getFcoId() {
        return fcoId;
    }

    public void setFcoId(String fcoId) {
        this.fcoId = fcoId == null ? null : fcoId.trim();
    }

    public String getPrjCode() {
        return prjCode;
    }

    public void setPrjCode(String prjCode) {
        this.prjCode = prjCode == null ? null : prjCode.trim();
    }

    public String getPrjName() {
        return prjName;
    }

    public void setPrjName(String prjName) {
        this.prjName = prjName == null ? null : prjName.trim();
    }

    public String getCjContract() {
        return cjContract;
    }

    public void setCjContract(String cjContract) {
        this.cjContract = cjContract == null ? null : cjContract.trim();
    }

    public String getFbContract() {
        return fbContract;
    }

    public void setFbContract(String fbContract) {
        this.fbContract = fbContract == null ? null : fbContract.trim();
    }

    public String getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType == null ? null : settlementType.trim();
    }

    public String getSettlementTime() {
        return settlementTime;
    }

    public void setSettlementTime(String settlementTime) {
        this.settlementTime = settlementTime == null ? null : settlementTime.trim();
    }

}