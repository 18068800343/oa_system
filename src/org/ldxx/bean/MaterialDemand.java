package org.ldxx.bean;

public class MaterialDemand {
    private String mdlId;

    private String materialName;

    private String materialCode;

    private String buyCompany;

    private Float price;
    
    private String num;

    private String provideCompany;

    private String sureMaterialMode;

    private String desc;

    public String getMdlId() {
        return mdlId;
    }

    public void setMdlId(String mdlId) {
        this.mdlId = mdlId == null ? null : mdlId.trim();
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode == null ? null : materialCode.trim();
    }

    public String getBuyCompany() {
        return buyCompany;
    }

    public void setBuyCompany(String buyCompany) {
        this.buyCompany = buyCompany == null ? null : buyCompany.trim();
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }


    public String getProvideCompany() {
		return provideCompany;
	}

	public void setProvideCompany(String provideCompany) {
		this.provideCompany = provideCompany;
	}

	public String getSureMaterialMode() {
		return sureMaterialMode;
	}

	public void setSureMaterialMode(String sureMaterialMode) {
		this.sureMaterialMode = sureMaterialMode;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}