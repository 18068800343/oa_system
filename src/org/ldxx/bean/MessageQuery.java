package org.ldxx.bean;

public class MessageQuery {
    private String mqId;

    private String applicant;

    private String recipient;

    private String sendTime;

    private String mqDesc;

    public String getMqId() {
        return mqId;
    }

    public void setMqId(String mqId) {
        this.mqId = mqId == null ? null : mqId.trim();
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant == null ? null : applicant.trim();
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient == null ? null : recipient.trim();
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime == null ? null : sendTime.trim();
    }

    public String getMqDesc() {
        return mqDesc;
    }

    public void setMqDesc(String mqDesc) {
        this.mqDesc = mqDesc == null ? null : mqDesc.trim();
    }
}