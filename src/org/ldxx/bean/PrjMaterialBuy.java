package org.ldxx.bean;

public class PrjMaterialBuy {
    private String pmbId;

    private String applyDepartment;

    private String applyPerson;

    private String applyListCode;

    private String contractNameYi;

    private String taskListCode;

    private String cjContractCode;

    private String cjContractName;

    private String applyReason;

    public String getPmbId() {
        return pmbId;
    }

    public void setPmbId(String pmbId) {
        this.pmbId = pmbId == null ? null : pmbId.trim();
    }

    public String getApplyDepartment() {
        return applyDepartment;
    }

    public void setApplyDepartment(String applyDepartment) {
        this.applyDepartment = applyDepartment == null ? null : applyDepartment.trim();
    }

    public String getApplyPerson() {
        return applyPerson;
    }

    public void setApplyPerson(String applyPerson) {
        this.applyPerson = applyPerson == null ? null : applyPerson.trim();
    }

    public String getApplyListCode() {
        return applyListCode;
    }

    public void setApplyListCode(String applyListCode) {
        this.applyListCode = applyListCode == null ? null : applyListCode.trim();
    }

    public String getContractNameYi() {
        return contractNameYi;
    }

    public void setContractNameYi(String contractNameYi) {
        this.contractNameYi = contractNameYi == null ? null : contractNameYi.trim();
    }

    public String getTaskListCode() {
        return taskListCode;
    }

    public void setTaskListCode(String taskListCode) {
        this.taskListCode = taskListCode == null ? null : taskListCode.trim();
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

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason == null ? null : applyReason.trim();
    }
}