package org.ldxx.bean;

import java.util.List;

public class PrjMaterialBuy {
    private String pmbId;

    private String applyDepartment;//申请部门编号
    private String omName;//申请部门名称

    private String applyPerson;//申请人编号
    private String uName;//申请人名称

    private String applyCode;//任务单号

    private String applyPrj;//任务名称

    private String taskCode;//申请单编号

    private String cjContractCode;//承接合同编号

    private String cjContractName;//承接合同名称

    private String applyReason;//申请原因
    
    private Double sumPrice;//总价格
    
    private List<MaterialDemand> md;
    
    
    public String getOmName() {
		return omName;
	}

	public void setOmName(String omName) {
		this.omName = omName;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

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

	public Double getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(Double sumPrice) {
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