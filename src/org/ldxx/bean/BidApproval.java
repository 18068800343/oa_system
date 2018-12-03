package org.ldxx.bean;
//投标审批单
public class BidApproval {
	private String baId;
	private String prjName;//项目名称
	private String prjNo;//项目编号
	private String ownerUnit;//业主单位
	private String prjType;//项目类型
	private String bidder;//投标人
	private String pretrialSubmissionTime;//资格预审递交时间
	private String fieldTime;//现场考察时间
	private String pretenderMeetingTime;//标前会时间
	private String submissionTime;//投标文件递交时间
	private String projectApplicants;//项目报名人员
	private String purchaseTenderPersonnel;//项目购买标书人员
	private String prjStates;//项目跟踪状态
	
	
	
	public String getPrjStates() {
		return prjStates;
	}
	public void setPrjStates(String prjStates) {
		this.prjStates = prjStates;
	}
	public String getPretrialSubmissionTime() {
		return pretrialSubmissionTime;
	}
	public void setPretrialSubmissionTime(String pretrialSubmissionTime) {
		this.pretrialSubmissionTime = pretrialSubmissionTime;
	}
	public String getBaId() {
		return baId;
	}
	public void setBaId(String baId) {
		this.baId = baId;
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
	public String getOwnerUnit() {
		return ownerUnit;
	}
	public void setOwnerUnit(String ownerUnit) {
		this.ownerUnit = ownerUnit;
	}
	public String getPrjType() {
		return prjType;
	}
	public void setPrjType(String prjType) {
		this.prjType = prjType;
	}
	public String getBidder() {
		return bidder;
	}
	public void setBidder(String bidder) {
		this.bidder = bidder;
	}
	public String getFieldTime() {
		return fieldTime;
	}
	public void setFieldTime(String fieldTime) {
		this.fieldTime = fieldTime;
	}
	public String getPretenderMeetingTime() {
		return pretenderMeetingTime;
	}
	public void setPretenderMeetingTime(String pretenderMeetingTime) {
		this.pretenderMeetingTime = pretenderMeetingTime;
	}
	public String getSubmissionTime() {
		return submissionTime;
	}
	public void setSubmissionTime(String submissionTime) {
		this.submissionTime = submissionTime;
	}
	public String getProjectApplicants() {
		return projectApplicants;
	}
	public void setProjectApplicants(String projectApplicants) {
		this.projectApplicants = projectApplicants;
	}
	public String getPurchaseTenderPersonnel() {
		return purchaseTenderPersonnel;
	}
	public void setPurchaseTenderPersonnel(String purchaseTenderPersonnel) {
		this.purchaseTenderPersonnel = purchaseTenderPersonnel;
	}
}
