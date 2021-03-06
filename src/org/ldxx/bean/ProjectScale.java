package org.ldxx.bean;

public class ProjectScale {
    private String psId;

    private String prjType;

    private String prjScale;

    private Integer contractAmountBig;

    private Integer contractAmountSmall;

    public String getPsId() {
        return psId;
    }

    public void setPsId(String psId) {
        this.psId = psId == null ? null : psId.trim();
    }

    public String getPrjType() {
        return prjType;
    }

    public void setPrjType(String prjType) {
        this.prjType = prjType == null ? null : prjType.trim();
    }

    public String getPrjScale() {
        return prjScale;
    }

    public void setPrjScale(String prjScale) {
        this.prjScale = prjScale == null ? null : prjScale.trim();
    }

    public Integer getContractAmountBig() {
        return contractAmountBig;
    }

    public void setContractAmountBig(Integer contractAmountBig) {
        this.contractAmountBig = contractAmountBig;
    }

    public Integer getContractAmountSmall() {
        return contractAmountSmall;
    }

    public void setContractAmountSmall(Integer contractAmountSmall) {
        this.contractAmountSmall = contractAmountSmall;
    }

	@Override
	public String toString() {
		return "ProjectScale [psId=" + psId + ", prjType=" + prjType + ", prjScale=" + prjScale + ", contractAmountBig="
				+ contractAmountBig + ", contractAmountSmall=" + contractAmountSmall + "]";
	}
    
    
}