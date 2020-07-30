package org.ldxx.bean;

import java.math.BigDecimal;

public class FinancialReceivables {
    private String frId;

    private String year;

    private String workNo;

    private String prjName;

    private String productOwners;

    private String prjStratandendTime;

    private String projectLeader;

    private String contractNo;

    private BigDecimal contractAmount;

    private BigDecimal contractAmount2;

    private BigDecimal cumulativeCollection;

    private BigDecimal extendedAmount;

    private BigDecimal extendedAmount2;

    private String invoiceNo;

    private String collectionTerms;

    private String prjFinish;

    private String receivingNode;

    private BigDecimal receivingNodeMoney;

    private BigDecimal actualPayment;

    private String departmentFeedback;

    private String financialNotes;

    public String getFrId() {
        return frId;
    }

    public void setFrId(String frId) {
        this.frId = frId == null ? null : frId.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo == null ? null : workNo.trim();
    }

    public String getPrjName() {
        return prjName;
    }

    public void setPrjName(String prjName) {
        this.prjName = prjName == null ? null : prjName.trim();
    }

    public String getProductOwners() {
        return productOwners;
    }

    public void setProductOwners(String productOwners) {
        this.productOwners = productOwners == null ? null : productOwners.trim();
    }

    public String getPrjStratandendTime() {
        return prjStratandendTime;
    }

    public void setPrjStratandendTime(String prjStratandendTime) {
        this.prjStratandendTime = prjStratandendTime == null ? null : prjStratandendTime.trim();
    }

    public String getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader == null ? null : projectLeader.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public BigDecimal getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(BigDecimal contractAmount) {
        this.contractAmount = contractAmount;
    }

    public BigDecimal getContractAmount2() {
        return contractAmount2;
    }

    public void setContractAmount2(BigDecimal contractAmount2) {
        this.contractAmount2 = contractAmount2;
    }

    public BigDecimal getCumulativeCollection() {
        return cumulativeCollection;
    }

    public void setCumulativeCollection(BigDecimal cumulativeCollection) {
        this.cumulativeCollection = cumulativeCollection;
    }

    public BigDecimal getExtendedAmount() {
        return extendedAmount;
    }

    public void setExtendedAmount(BigDecimal extendedAmount) {
        this.extendedAmount = extendedAmount;
    }

    public BigDecimal getExtendedAmount2() {
        return extendedAmount2;
    }

    public void setExtendedAmount2(BigDecimal extendedAmount2) {
        this.extendedAmount2 = extendedAmount2;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo == null ? null : invoiceNo.trim();
    }

    public String getCollectionTerms() {
        return collectionTerms;
    }

    public void setCollectionTerms(String collectionTerms) {
        this.collectionTerms = collectionTerms == null ? null : collectionTerms.trim();
    }

    public String getPrjFinish() {
        return prjFinish;
    }

    public void setPrjFinish(String prjFinish) {
        this.prjFinish = prjFinish == null ? null : prjFinish.trim();
    }

    public String getReceivingNode() {
        return receivingNode;
    }

    public void setReceivingNode(String receivingNode) {
        this.receivingNode = receivingNode == null ? null : receivingNode.trim();
    }

    public BigDecimal getReceivingNodeMoney() {
        return receivingNodeMoney;
    }

    public void setReceivingNodeMoney(BigDecimal receivingNodeMoney) {
        this.receivingNodeMoney = receivingNodeMoney;
    }

    public BigDecimal getActualPayment() {
        return actualPayment;
    }

    public void setActualPayment(BigDecimal actualPayment) {
        this.actualPayment = actualPayment;
    }

    public String getDepartmentFeedback() {
        return departmentFeedback;
    }

    public void setDepartmentFeedback(String departmentFeedback) {
        this.departmentFeedback = departmentFeedback == null ? null : departmentFeedback.trim();
    }

    public String getFinancialNotes() {
        return financialNotes;
    }

    public void setFinancialNotes(String financialNotes) {
        this.financialNotes = financialNotes == null ? null : financialNotes.trim();
    }
}