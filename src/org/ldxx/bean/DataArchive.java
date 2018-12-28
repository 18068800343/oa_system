package org.ldxx.bean;

import java.util.List;

public class DataArchive {
    private String daId;

    private String daName;

    private String safekeepingDepartment;
    
    private String uName;

    private String trainingLocation;

    private String trainingTime;

    private String credentialDesc;
    
    private List<Accessory> accessory;
    
    private List<Accessory> accessory2;
    
    private List<Accessory> accessory3;
    
    private String omName;
    

	public List<Accessory> getAccessory3() {
		return accessory3;
	}

	public void setAccessory3(List<Accessory> accessory3) {
		this.accessory3 = accessory3;
	}

	public String getOmName() {
		return omName;
	}

	public void setOmName(String omName) {
		this.omName = omName;
	}

	public String getDaId() {
		return daId;
	}

	public void setDaId(String daId) {
		this.daId = daId;
	}

	
	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getDaName() {
		return daName;
	}

	public void setDaName(String daName) {
		this.daName = daName;
	}

	public String getSafekeepingDepartment() {
		return safekeepingDepartment;
	}

	public void setSafekeepingDepartment(String safekeepingDepartment) {
		this.safekeepingDepartment = safekeepingDepartment;
	}

	public String getTrainingLocation() {
		return trainingLocation;
	}

	public void setTrainingLocation(String trainingLocation) {
		this.trainingLocation = trainingLocation;
	}

	public String getTrainingTime() {
		return trainingTime;
	}

	public void setTrainingTime(String trainingTime) {
		this.trainingTime = trainingTime;
	}

	public String getCredentialDesc() {
		return credentialDesc;
	}

	public void setCredentialDesc(String credentialDesc) {
		this.credentialDesc = credentialDesc;
	}

	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}

	public List<Accessory> getAccessory2() {
		return accessory2;
	}

	public void setAccessory2(List<Accessory> accessory2) {
		this.accessory2 = accessory2;
	}

    
}