package org.ldxx.bean;

public class PrjEndWorkApply {
    private String peId;

    private String prjCode;

    private String cjContractCode;

    private String cjContractName;

    private String contractNameJia;

    private String contractStartTime;

    private String contractEndTime;

    private String prjProbablyText;

    private String workText;

    private Double contractMoney;

    private Double endMoney;

    private String otherFilePath;

    public String getPeId() {
        return peId;
    }

    public void setPeId(String peId) {
        this.peId = peId == null ? null : peId.trim();
    }

    public String getPrjCode() {
        return prjCode;
    }

    public void setPrjCode(String prjCode) {
        this.prjCode = prjCode == null ? null : prjCode.trim();
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

    public String getContractNameJia() {
        return contractNameJia;
    }

    public void setContractNameJia(String contractNameJia) {
        this.contractNameJia = contractNameJia == null ? null : contractNameJia.trim();
    }

    public String getContractStartTime() {
        return contractStartTime;
    }

    public void setContractStartTime(String contractStartTime) {
        this.contractStartTime = contractStartTime == null ? null : contractStartTime.trim();
    }

    public String getContractEndTime() {
        return contractEndTime;
    }

    public void setContractEndTime(String contractEndTime) {
        this.contractEndTime = contractEndTime == null ? null : contractEndTime.trim();
    }

    public String getPrjProbablyText() {
        return prjProbablyText;
    }

    public void setPrjProbablyText(String prjProbablyText) {
        this.prjProbablyText = prjProbablyText == null ? null : prjProbablyText.trim();
    }

    public String getWorkText() {
        return workText;
    }

    public void setWorkText(String workText) {
        this.workText = workText == null ? null : workText.trim();
    }

    public Double getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(Double contractMoney) {
        this.contractMoney = contractMoney;
    }

    public Double getEndMoney() {
        return endMoney;
    }

    public void setEndMoney(Double endMoney) {
        this.endMoney = endMoney;
    }

    public String getOtherFilePath() {
        return otherFilePath;
    }

    public void setOtherFilePath(String otherFilePath) {
        this.otherFilePath = otherFilePath == null ? null : otherFilePath.trim();
    }
}