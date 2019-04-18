package org.ldxx.bean;

public class FinancialPayment {
    private String fpId;

    private String serialNumber;

    private String workNo;

    private String contractNumber;

    private String paymentNumber;

    private String contractName;

    private String administration;

    private Double contractAmount;

    private Double contractAmount2;

    private Double contractPayment;

    private Double collectionRatio;

    private String contractNoSplit;

    private String contractNameSplit;

    private String secondParty;

    private Double contractAmountSplit;

    private Double contractAmountSplit2;

    private Double accumulatedPayment;

    private Double invoicedAmount;

    private String invoiceNumberOther;

    private Double amountReceived;

    private Double actualPayment;

    public String getFpId() {
        return fpId;
    }

    public void setFpId(String fpId) {
        this.fpId = fpId == null ? null : fpId.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo == null ? null : workNo.trim();
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber == null ? null : contractNumber.trim();
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber == null ? null : paymentNumber.trim();
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    public String getAdministration() {
        return administration;
    }

    public void setAdministration(String administration) {
        this.administration = administration == null ? null : administration.trim();
    }

    public Double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Double contractAmount) {
        this.contractAmount = contractAmount;
    }

    public Double getContractAmount2() {
        return contractAmount2;
    }

    public void setContractAmount2(Double contractAmount2) {
        this.contractAmount2 = contractAmount2;
    }

    public Double getContractPayment() {
        return contractPayment;
    }

    public void setContractPayment(Double contractPayment) {
        this.contractPayment = contractPayment;
    }

    public Double getCollectionRatio() {
        return collectionRatio;
    }

    public void setCollectionRatio(Double collectionRatio) {
        this.collectionRatio = collectionRatio;
    }

    public String getContractNoSplit() {
        return contractNoSplit;
    }

    public void setContractNoSplit(String contractNoSplit) {
        this.contractNoSplit = contractNoSplit == null ? null : contractNoSplit.trim();
    }

    public String getContractNameSplit() {
        return contractNameSplit;
    }

    public void setContractNameSplit(String contractNameSplit) {
        this.contractNameSplit = contractNameSplit == null ? null : contractNameSplit.trim();
    }

    public String getSecondParty() {
        return secondParty;
    }

    public void setSecondParty(String secondParty) {
        this.secondParty = secondParty == null ? null : secondParty.trim();
    }

    public Double getContractAmountSplit() {
        return contractAmountSplit;
    }

    public void setContractAmountSplit(Double contractAmountSplit) {
        this.contractAmountSplit = contractAmountSplit;
    }

    public Double getContractAmountSplit2() {
        return contractAmountSplit2;
    }

    public void setContractAmountSplit2(Double contractAmountSplit2) {
        this.contractAmountSplit2 = contractAmountSplit2;
    }

    public Double getAccumulatedPayment() {
        return accumulatedPayment;
    }

    public void setAccumulatedPayment(Double accumulatedPayment) {
        this.accumulatedPayment = accumulatedPayment;
    }

    public Double getInvoicedAmount() {
        return invoicedAmount;
    }

    public void setInvoicedAmount(Double invoicedAmount) {
        this.invoicedAmount = invoicedAmount;
    }

    public String getInvoiceNumberOther() {
        return invoiceNumberOther;
    }

    public void setInvoiceNumberOther(String invoiceNumberOther) {
        this.invoiceNumberOther = invoiceNumberOther == null ? null : invoiceNumberOther.trim();
    }

    public Double getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(Double amountReceived) {
        this.amountReceived = amountReceived;
    }

    public Double getActualPayment() {
        return actualPayment;
    }

    public void setActualPayment(Double actualPayment) {
        this.actualPayment = actualPayment;
    }
}