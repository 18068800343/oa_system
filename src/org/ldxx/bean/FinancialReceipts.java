package org.ldxx.bean;

import java.math.BigDecimal;

/** 
* @ClassName: FinancialReceipts 
* @Description: 财务收款
* @author zhaohui
* @date 2018年11月6日 下午2:26:12 
*  
*/
public class FinancialReceipts {

	private String frId;
	private String prjName;
	private String prjNo;
	private String year;
	private String yezhu;
	private String startTime;
	private String endTime;
	private String prjLeader;
	private String htContract;
	private String contractNo;
	private BigDecimal contractMoney;
	private BigDecimal contractMoneyEnd;
	private BigDecimal totalMoney;
	private BigDecimal kpMoney;
	private String fpNo;
	private String collectionTerms;
	private String prjPlan;
	private BigDecimal resultMoney;
	private String departmentInfo;
	private String financeInfo;
	private String status;
	private String receiptTime;
	
	
	public String getReceiptTime() {
		return receiptTime;
	}
	public void setReceiptTime(String receiptTime) {
		this.receiptTime = receiptTime;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFrId() {
		return frId;
	}
	public void setFrId(String frId) {
		this.frId = frId;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getPrjNo() {
		return prjNo;
	}
	public void setPrjNo(String prjNo) {
		this.prjNo = prjNo;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getYezhu() {
		return yezhu;
	}
	public void setYezhu(String yezhu) {
		this.yezhu = yezhu;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getPrjLeader() {
		return prjLeader;
	}
	public void setPrjLeader(String prjLeader) {
		this.prjLeader = prjLeader;
	}
	public String getHtContract() {
		return htContract;
	}
	public void setHtContract(String htContract) {
		this.htContract = htContract;
	}
	public BigDecimal getContractMoney() {
		return contractMoney;
	}
	public void setContractMoney(BigDecimal contractMoney) {
		this.contractMoney = contractMoney;
	}
	public BigDecimal getContractMoneyEnd() {
		return contractMoneyEnd;
	}
	public void setContractMoneyEnd(BigDecimal contractMoneyEnd) {
		this.contractMoneyEnd = contractMoneyEnd;
	}
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
	public BigDecimal getKpMoney() {
		return kpMoney;
	}
	public void setKpMoney(BigDecimal kpMoney) {
		this.kpMoney = kpMoney;
	}
	public String getFpNo() {
		return fpNo;
	}
	public void setFpNo(String fpNo) {
		this.fpNo = fpNo;
	}
	public String getCollectionTerms() {
		return collectionTerms;
	}
	public void setCollectionTerms(String collectionTerms) {
		this.collectionTerms = collectionTerms;
	}
	public String getPrjPlan() {
		return prjPlan;
	}
	public void setPrjPlan(String prjPlan) {
		this.prjPlan = prjPlan;
	}
	public BigDecimal getResultMoney() {
		return resultMoney;
	}
	public void setResultMoney(BigDecimal resultMoney) {
		this.resultMoney = resultMoney;
	}
	public String getDepartmentInfo() {
		return departmentInfo;
	}
	public void setDepartmentInfo(String departmentInfo) {
		this.departmentInfo = departmentInfo;
	}
	public String getFinanceInfo() {
		return financeInfo;
	}
	public void setFinanceInfo(String financeInfo) {
		this.financeInfo = financeInfo;
	}
	
	
}
