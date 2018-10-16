package org.ldxx.bean;

public class MaterialDemand {
    private String mdlId;
    
    private String buyId;

    private String materialName;

    private String materialType;

    private String buyCompany;

    private Float price;
    
    private int num;

    private String provideCompany;
    private String name;

    private String sureMaterialMode;
    private String name2;

    private String infos;

    
    public String getBuyId() {
		return buyId;
	}

	public void setBuyId(String buyId) {
		this.buyId = buyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

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

    public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getBuyCompany() {
        return buyCompany;
    }

    public void setBuyCompany(String buyCompany) {
        this.buyCompany = buyCompany == null ? null : buyCompany.trim();
    }


    public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
	}

}