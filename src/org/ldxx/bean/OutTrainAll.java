package org.ldxx.bean;

import java.util.List;

public class OutTrainAll {
    private String otaId;

    private String otaTitle;

    private String trainingName;

    private String trainingLv;

    private String courseName;

    private String trainingLocation;

    private float trainingMoney;

    private String trainingDate;

    private String attendees;

    private String courseDesc;
    
    private String trainingReason;
    
    private String omId;
    
    private String omName;
    
    private List<Accessory> accessory;
    
    
    public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}

	public String getOmName() {
		return omName;
	}

	public void setOmName(String omName) {
		this.omName = omName;
	}

	public String getOmId() {
		return omId;
	}

	public void setOmId(String omId) {
		this.omId = omId;
	}

	public String getOtaId() {
        return otaId;
    }

    public void setOtaId(String otaId) {
        this.otaId = otaId == null ? null : otaId.trim();
    }

    public String getOtaTitle() {
        return otaTitle;
    }

    public void setOtaTitle(String otaTitle) {
        this.otaTitle = otaTitle == null ? null : otaTitle.trim();
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName == null ? null : trainingName.trim();
    }

    public String getTrainingLv() {
        return trainingLv;
    }

    public void setTrainingLv(String trainingLv) {
        this.trainingLv = trainingLv == null ? null : trainingLv.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getTrainingLocation() {
        return trainingLocation;
    }

    public void setTrainingLocation(String trainingLocation) {
        this.trainingLocation = trainingLocation == null ? null : trainingLocation.trim();
    }

    public float getTrainingMoney() {
        return trainingMoney;
    }

    public void setTrainingMoney(float trainingMoney) {
        this.trainingMoney = trainingMoney;
    }

    public String getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(String trainingDate) {
        this.trainingDate = trainingDate == null ? null : trainingDate.trim();
    }

    public String getAttendees() {
        return attendees;
    }

    public void setAttendees(String attendees) {
        this.attendees = attendees == null ? null : attendees.trim();
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

    
}