package org.ldxx.bean;

public class MessageNotice {
    private String mnId;

    private String mfId;

    public String getMnId() {
        return mnId;
    }

    public void setMnId(String mnId) {
        this.mnId = mnId == null ? null : mnId.trim();
    }

    public String getMfId() {
        return mfId;
    }

    public void setMfId(String mfId) {
        this.mfId = mfId == null ? null : mfId.trim();
    }
}