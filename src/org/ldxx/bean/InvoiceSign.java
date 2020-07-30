package org.ldxx.bean;

import java.math.BigDecimal;

public class InvoiceSign {
    private String isId;

    private String invoiceDate;

    private BigDecimal invoiceMoney;

    private String invoiceType;

    private String invoiceNo;

    private String productOwners;

    private String taxpayerNo;

    private String prjName;

    private String workNo;

    private String companyManager;

    private String ticketDate;

    private String invoiceSign;

    private String phone;

    private String signDate;

    public String getIsId() {
        return isId;
    }

    public void setIsId(String isId) {
        this.isId = isId == null ? null : isId.trim();
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate == null ? null : invoiceDate.trim();
    }

    public BigDecimal getInvoiceMoney() {
        return invoiceMoney;
    }

    public void setInvoiceMoney(BigDecimal invoiceMoney) {
        this.invoiceMoney = invoiceMoney;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType == null ? null : invoiceType.trim();
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo == null ? null : invoiceNo.trim();
    }

    public String getProductOwners() {
        return productOwners;
    }

    public void setProductOwners(String productOwners) {
        this.productOwners = productOwners == null ? null : productOwners.trim();
    }

    public String getTaxpayerNo() {
        return taxpayerNo;
    }

    public void setTaxpayerNo(String taxpayerNo) {
        this.taxpayerNo = taxpayerNo == null ? null : taxpayerNo.trim();
    }

    public String getPrjName() {
        return prjName;
    }

    public void setPrjName(String prjName) {
        this.prjName = prjName == null ? null : prjName.trim();
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo == null ? null : workNo.trim();
    }

    public String getCompanyManager() {
        return companyManager;
    }

    public void setCompanyManager(String companyManager) {
        this.companyManager = companyManager == null ? null : companyManager.trim();
    }

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate == null ? null : ticketDate.trim();
    }

    public String getInvoiceSign() {
        return invoiceSign;
    }

    public void setInvoiceSign(String invoiceSign) {
        this.invoiceSign = invoiceSign == null ? null : invoiceSign.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate == null ? null : signDate.trim();
    }
}