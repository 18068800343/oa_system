package org.ldxx.bean;

import java.util.List;

public class Cooperator {
    private String ccId;

    private String ccName;

    private String ccType;

    private String creditCode;

    private String bankNo;

    private String bankName;

    private String businessLicense;

    private String businessLicenseTime;

    private String legalPersonName;

    private String enterpriseType;

    private String enterpriseAddr;

    private String enterpriseFax;

    private String enterpriseEmail;

    private List<Eva> enterpriseEva;
    
    private String enterpriseDesc;
    
    private String importantEvent;

    private List<Enterprise> enterprise;
    
    
    public List<Enterprise> getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(List<Enterprise> enterprise) {
		this.enterprise = enterprise;
	}

	public String getEnterpriseDesc() {
		return enterpriseDesc;
	}

	public void setEnterpriseDesc(String enterpriseDesc) {
		this.enterpriseDesc = enterpriseDesc;
	}

	public String getImportantEvent() {
		return importantEvent;
	}

	public void setImportantEvent(String importantEvent) {
		this.importantEvent = importantEvent;
	}

	public String getCcId() {
        return ccId;
    }

    public void setCcId(String ccId) {
        this.ccId = ccId == null ? null : ccId.trim();
    }

    public String getCcName() {
        return ccName;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName == null ? null : ccName.trim();
    }

    public String getCcType() {
        return ccType;
    }

    public void setCcType(String ccType) {
        this.ccType = ccType == null ? null : ccType.trim();
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode == null ? null : creditCode.trim();
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo == null ? null : bankNo.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    public String getBusinessLicenseTime() {
        return businessLicenseTime;
    }

    public void setBusinessLicenseTime(String businessLicenseTime) {
        this.businessLicenseTime = businessLicenseTime == null ? null : businessLicenseTime.trim();
    }

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName == null ? null : legalPersonName.trim();
    }

    public String getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType == null ? null : enterpriseType.trim();
    }

    public String getEnterpriseAddr() {
        return enterpriseAddr;
    }

    public void setEnterpriseAddr(String enterpriseAddr) {
        this.enterpriseAddr = enterpriseAddr == null ? null : enterpriseAddr.trim();
    }

    public String getEnterpriseFax() {
        return enterpriseFax;
    }

    public void setEnterpriseFax(String enterpriseFax) {
        this.enterpriseFax = enterpriseFax == null ? null : enterpriseFax.trim();
    }

    public String getEnterpriseEmail() {
        return enterpriseEmail;
    }

    public void setEnterpriseEmail(String enterpriseEmail) {
        this.enterpriseEmail = enterpriseEmail == null ? null : enterpriseEmail.trim();
    }

	public List<Eva> getEnterpriseEva() {
		return enterpriseEva;
	}

	public void setEnterpriseEva(List<Eva> enterpriseEva) {
		this.enterpriseEva = enterpriseEva;
	}
    
}