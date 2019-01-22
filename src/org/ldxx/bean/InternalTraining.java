package org.ldxx.bean;

import java.util.List;

public class InternalTraining {
    private String itId;

    private String trainingMan;
    
    private String uName;

    private String department;

    private String duty;
    
    private String dutyName;

    private String courseName;

    private String trainingDate;

    private String trainingLocation;

    private float trainingMoney;

    private List<Accessory> accessory;

    private String trainingDesc;
    
    private String trainingReason;
    
    private String trainingInUser;//参加人员
    private String trainingType;//类型
    
    
	public String getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}

	public String getTrainingInUser() {
		return trainingInUser;
	}

	public void setTrainingInUser(String trainingInUser) {
		this.trainingInUser = trainingInUser;
	}

	public String getItId() {
		return itId;
	}

	public void setItId(String itId) {
		this.itId = itId;
	}

	public String getTrainingMan() {
		return trainingMan;
	}

	public void setTrainingMan(String trainingMan) {
		this.trainingMan = trainingMan;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTrainingDate() {
		return trainingDate;
	}

	public void setTrainingDate(String trainingDate) {
		this.trainingDate = trainingDate;
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

	
	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}

	public String getTrainingDesc() {
		return trainingDesc;
	}

	public void setTrainingDesc(String trainingDesc) {
		this.trainingDesc = trainingDesc;
	}

	public String getTrainingReason() {
		return trainingReason;
	}

	public void setTrainingReason(String trainingReason) {
		this.trainingReason = trainingReason;
	}

	
	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	@Override
	public String toString() {
		return "InternalTraining [itId=" + itId + ", trainingMan=" + trainingMan + ", uName=" + uName + ", department="
				+ department + ", duty=" + duty + ", dutyName=" + dutyName + ", courseName=" + courseName
				+ ", trainingDate=" + trainingDate + ", trainingLocation=" + trainingLocation + ", trainingMoney="
				+ trainingMoney + ", accessory=" + accessory + ", trainingDesc=" + trainingDesc + ", trainingReason="
				+ trainingReason + "]";
	}

}