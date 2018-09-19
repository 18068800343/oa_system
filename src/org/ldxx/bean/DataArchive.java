package org.ldxx.bean;

import java.util.List;

public class DataArchive {
    private String daId;

    private String daName;

    private String attendees;

    private String trainingLocation;

    private String trainingTime;

    private String credentialDesc;
    
    private List<Accessory> accessory;
    
    private List<Accessory> accessory2;

	public String getDaId() {
		return daId;
	}

	public void setDaId(String daId) {
		this.daId = daId;
	}

	public String getDaName() {
		return daName;
	}

	public void setDaName(String daName) {
		this.daName = daName;
	}

	public String getAttendees() {
		return attendees;
	}

	public void setAttendees(String attendees) {
		this.attendees = attendees;
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