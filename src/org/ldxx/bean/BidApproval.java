package org.ldxx.bean;
//投标审批单
public class BidApproval {
	private String baId;
	private String prjName;//项目名称
	private String prjNo;//项目编号
	private String ownerUnit;//业主单位id
	private String prjType;//项目类型
	private String bidder;//投标人
	private String pretrialSubmissionTime;//资格预审递交时间
	private String fieldTime;//现场考察时间
	private String pretenderMeetingTime;//标前会时间
	private String submissionTime;//投标文件递交时间
	private String projectApplicants;//项目报名人员
	private String purchaseTenderPersonnel;//项目购买标书人员
	private String prjStates;//项目跟踪状态
	private String businessPeople;//商务负责人
	private String bidPeople;//报价负责人
	private String nextDepartment;//下一步
	private String xbDepartment;//协作部门
	private String fileLevel;
	private String fgLindao;
	private String tbPeople;
	private String tbUname;
	private String ccName;//业主单位名称
	private String omName;//协作单位名称
	private String zhongbiao;
	private String bdNo;//标段编号
	
	
	public String getBdNo() {
		return bdNo;
	}
	public void setBdNo(String bdNo) {
		this.bdNo = bdNo;
	}
	public String getTbUname() {
		return tbUname;
	}
	public void setTbUname(String tbUname) {
		this.tbUname = tbUname;
	}
	public String getZhongbiao() {
		return zhongbiao;
	}
	public void setZhongbiao(String zhongbiao) {
		this.zhongbiao = zhongbiao;
	}
	public String getOmName() {
		return omName;
	}
	public void setOmName(String omName) {
		this.omName = omName;
	}
	public String getTbPeople() {
		return tbPeople;
	}
	public void setTbPeople(String tbPeople) {
		this.tbPeople = tbPeople;
	}
	public String getXbDepartment() {
		return xbDepartment;
	}
	public void setXbDepartment(String xbDepartment) {
		this.xbDepartment = xbDepartment;
	}
	public String getFileLevel() {
		return fileLevel;
	}
	public void setFileLevel(String fileLevel) {
		this.fileLevel = fileLevel;
	}
	public String getFgLindao() {
		return fgLindao;
	}
	public void setFgLindao(String fgLindao) {
		this.fgLindao = fgLindao;
	}
	public String getCcName() {
		return ccName;
	}
	public void setCcName(String ccName) {
		this.ccName = ccName;
	}
	public String getBusinessPeople() {
		return businessPeople;
	}
	public void setBusinessPeople(String businessPeople) {
		this.businessPeople = businessPeople;
	}
	public String getBidPeople() {
		return bidPeople;
	}
	public void setBidPeople(String bidPeople) {
		this.bidPeople = bidPeople;
	}
	public String getNextDepartment() {
		return nextDepartment;
	}
	public void setNextDepartment(String nextDepartment) {
		this.nextDepartment = nextDepartment;
	}
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
