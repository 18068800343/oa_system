package org.ldxx.bean;

import java.util.List;

public class OutTrain {
    private String otId;

    private String otTitle;

    private String proposer;
    
    private String uName;

    private String proposerDepartment;

    private String dutyId;

    private String otDate;

    private String applicationDate;

    private String courseName;

    private String trainingLocation;

    private float trainingMoney;
    
    private String courseDesc;
    
    private String trainingReason;

    private List<Accessory> accessory;
    
    
    
	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getOtId() {
		return otId;
	}

	public void setOtId(String otId) {
		this.otId = otId;
	}

	public String getOtTitle() {
		return otTitle;
	}

	public void setOtTitle(String otTitle) {
		this.otTitle = otTitle;
	}

	public String getProposer() {
		return proposer;
	}

	public void setProposer(String proposer) {
		this.proposer = proposer;
	}

	public String getProposerDepartment() {
		return proposerDepartment;
	}

	public void setProposerDepartment(String proposerDepartment) {
		this.proposerDepartment = proposerDepartment;
	}

	public String getDutyId() {
		return dutyId;
	}

	public void setDutyId(String dutyId) {
		this.dutyId = dutyId;
	}

	public String getOtDate() {
		return otDate;
	}

	public void setOtDate(String otDate) {
		this.otDate = otDate;
	}

	public String getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTrainingLocation() {
		return trainingLocation;
	}

	public void setTrainingLocation(String trainingLocation) {
		this.trainingLocation = trainingLocation;
	}

	public float getTrainingMoney() {
		return trainingMoney;
	}

	public void setTrainingMoney(float trainingMoney) {
		this.trainingMoney = trainingMoney;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	public String getTrainingReason() {
		return trainingReason;
	}

	public void setTrainingReason(String trainingReason) {
		this.trainingReason = trainingReason;
	}

	@Override
	public String toString() {
		return "OutTrain [otId=" + otId + ", otTitle=" + otTitle + ", proposer=" + proposer + ", uName=" + uName
				+ ", proposerDepartment=" + proposerDepartment + ", dutyId=" + dutyId + ", otDate=" + otDate
				+ ", applicationDate=" + applicationDate + ", courseName=" + courseName + ", trainingLocation="
				+ trainingLocation + ", trainingMoney=" + trainingMoney + ", courseDesc=" + courseDesc
				+ ", trainingReason=" + trainingReason + "]";
	}

	

	
}