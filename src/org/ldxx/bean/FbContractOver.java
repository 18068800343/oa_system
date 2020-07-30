package org.ldxx.bean;

import java.math.BigDecimal;
import java.util.List;

public class FbContractOver {/*分包结算申请*/
    private String fcoId;

    private String prjCode;//任务单号

    private String cjContract;//承接单号
    private String cjName;//承接名称

    private String fbContract;//分包单号
    private String fbName;//分包名称

    private BigDecimal fbMoney;//分包合同金额
    
    private BigDecimal fbEndMoney;//分包结算金额
   /* private String settlementType;//结算类型*/
    
    private String settlementTime;//时间
    
    private String workInfo;
    private BigDecimal qianqijyMoney;//前期经营费用
    private String isKouchu;//是否扣除
    
    private List<Accessory> accessory;
    /*private List<Accessory> accessory2;//法律顾问签字*/    
    
    private String starterName;//发起人
    private String status;//审批状态
    
    private String cwoState;//审批状态

    
    
    public String getCwoState() {
		return cwoState;
	}

	public void setCwoState(String cwoState) {
		this.cwoState = cwoState;
	}

	public BigDecimal getFbMoney() {
		return fbMoney;
	}

	public BigDecimal getQianqijyMoney() {
		return qianqijyMoney;
	}

	public void setQianqijyMoney(BigDecimal qianqijyMoney) {
		this.qianqijyMoney = qianqijyMoney;
	}

	public String getIsKouchu() {
		return isKouchu;
	}

	public void setIsKouchu(String isKouchu) {
		this.isKouchu = isKouchu;
	}

	public void setFbMoney(BigDecimal fbMoney) {
		this.fbMoney = fbMoney;
	}

	public BigDecimal getFbEndMoney() {
		return fbEndMoney;
	}

	public void setFbEndMoney(BigDecimal fbEndMoney) {
		this.fbEndMoney = fbEndMoney;
	}

	public String getCjName() {
		return cjName;
	}

	public void setCjName(String cjName) {
		this.cjName = cjName;
	}

	public String getFbName() {
		return fbName;
	}

	public void setFbName(String fbName) {
		this.fbName = fbName;
	}

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

    public String getSettlementTime() {
        return settlementTime;
    }

    public void setSettlementTime(String settlementTime) {
        this.settlementTime = settlementTime == null ? null : settlementTime.trim();
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