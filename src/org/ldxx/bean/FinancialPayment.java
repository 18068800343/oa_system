package org.ldxx.bean;

import java.math.BigDecimal;

public class FinancialPayment {
    private String fpId;

    private String serialNumber;

    private String workNo;

    private String contractNumber;

    private String paymentNumber;

    private String contractName;

    private String administration;

    private BigDecimal contractAmount;

    private BigDecimal contractAmount2;

    private BigDecimal contractPayment;

    private BigDecimal collectionRatio;

    private String contractNoSplit;

    private String contractNameSplit;

    private String secondParty;

    private BigDecimal contractAmountSplit;

    private BigDecimal contractAmountSplit2;

    private BigDecimal accumulatedPayment;

    private BigDecimal invoicedAmount;

    private String invoiceNumberOther;

    private BigDecimal amountReceived;

    private BigDecimal actualPayment;

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

    public BigDecimal getContractPayment() {
        return contractPayment;
    }

    public void setContractPayment(BigDecimal contractPayment) {
        this.contractPayment = contractPayment;
    }

    public BigDecimal getCollectionRatio() {
        return collectionRatio;
    }

    public void setCollectionRatio(BigDecimal collectionRatio) {
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

    public BigDecimal getContractAmountSplit() {
        return contractAmountSplit;
    }

    public void setContractAmountSplit(BigDecimal contractAmountSplit) {
        this.contractAmountSplit = contractAmountSplit;
    }

    public BigDecimal getContractAmountSplit2() {
        return contractAmountSplit2;
    }

    public void setContractAmountSplit2(BigDecimal contractAmountSplit2) {
        this.contractAmountSplit2 = contractAmountSplit2;
    }

    public BigDecimal getAccumulatedPayment() {
        return accumulatedPayment;
    }

    public void setAccumulatedPayment(BigDecimal accumulatedPayment) {
        this.accumulatedPayment = accumulatedPayment;
    }

    public BigDecimal getInvoicedAmount() {
        return invoicedAmount;
    }

    public void setInvoicedAmount(BigDecimal invoicedAmount) {
        this.invoicedAmount = invoicedAmount;
    }

    public String getInvoiceNumberOther() {
        return invoiceNumberOther;
    }

    public void setInvoiceNumberOther(String invoiceNumberOther) {
        this.invoiceNumberOther = invoiceNumberOther == null ? null : invoiceNumberOther.trim();
    }

    public BigDecimal getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(BigDecimal amountReceived) {
        this.amountReceived = amountReceived;
    }

    public BigDecimal getActualPayment() {
        return actualPayment;
    }

    public void setActualPayment(BigDecimal actualPayment) {
        this.actualPayment = actualPayment;
    }
}