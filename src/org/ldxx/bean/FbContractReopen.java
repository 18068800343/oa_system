package org.ldxx.bean;

public class FbContractReopen {
    private String fbrId;

    private String fbId;

    private String fbContractCode;

    private String fbContractReopenReason;

    private String reopenTime;

    public String getFbrId() {
        return fbrId;
    }

    public void setFbrId(String fbrId) {
        this.fbrId = fbrId == null ? null : fbrId.trim();
    }

    public String getFbId() {
        return fbId;
    }

    public void setFbId(String fbId) {
        this.fbId = fbId == null ? null : fbId.trim();
    }

    public String getFbContractCode() {
        return fbContractCode;
    }

    public void setFbContractCode(String fbContractCode) {
        this.fbContractCode = fbContractCode == null ? null : fbContractCode.trim();
    }

    public String getFbContractReopenReason() {
        return fbContractReopenReason;
    }

    public void setFbContractReopenReason(String fbContractReopenReason) {
        this.fbContractReopenReason = fbContractReopenReason == null ? null : fbContractReopenReason.trim();
    }

    public String getReopenTime() {
        return reopenTime;
    }

    public void setReopenTime(String reopenTime) {
        this.reopenTime = reopenTime == null ? null : reopenTime.trim();
    }
}