package org.ldxx.bean;

public class ModeStatus {
    private String modeId;

    private String status;

    private String remark;
    
    private String flowStatus;
    
    public String getFlowStatus() {
		return flowStatus;
	}

	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}

	public String getModeId() {
        return modeId;
    }

    public void setModeId(String modeId) {
        this.modeId = modeId == null ? null : modeId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}