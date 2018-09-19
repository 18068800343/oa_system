package org.ldxx.bean;

public class MessageFunction {
    private String mfId;

    private String mfName;

    public String getMfId() {
        return mfId;
    }

    public void setMfId(String mfId) {
        this.mfId = mfId == null ? null : mfId.trim();
    }

    public String getMfName() {
        return mfName;
    }

    public void setMfName(String mfName) {
        this.mfName = mfName == null ? null : mfName.trim();
    }
}