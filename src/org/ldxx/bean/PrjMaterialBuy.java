package org.ldxx.bean;

import java.util.List;

public class PrjMaterialBuy {
    private String pmbId;

    private String applyDepartment;

    private String applyPerson;

    private String applyCode;

    private String applyPrj;

    private String taskCode;

    private String cjContractCode;

    private String cjContractName;

    private String applyReason;
    
    private Float sumPrice;
    
    private List<MaterialDemand> md;
    
    
    public List<MaterialDemand> getMd() {
		return md;
	}

	public void setMd(List<MaterialDemand> md) {
		this.md = md;
	}

	public String getApplyCode() {
		return applyCode;
	}

	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public Float getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(Float sumPrice) {
		this.sumPrice = sumPrice;
	}

	public String getPmbId() {
        return pmbId;
    }

    public void setPmbId(String pmbId) {
        this.pmbId = pmbId == null ? null : pmbId.trim();
    }

    public String getApplyDepartment() {
        return applyDepartment;
    }

    public void setApplyDepartment(String applyDepartment) {
        this.applyDepartment = applyDepartment == null ? null : applyDepartment.trim();
    }

    public String getApplyPerson() {
        return applyPerson;
    }

    public void setApplyPerson(String applyPerson) {
        this.applyPerson = applyPerson == null ? null : applyPerson.trim();
    }


    public String getApplyPrj() {
		return applyPrj;
	}

	public void setApplyPrj(String applyPrj) {
		this.applyPrj = applyPrj;
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

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason == null ? null : applyReason.trim();
    }
}