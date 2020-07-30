package org.ldxx.bean;

import java.math.BigDecimal;
import java.util.List;

public class OutTrainAll {
    private String otaId;

    private String otaTitle;

    private String trainingName;

    private String trainingLv;

    private String courseName;

    private String trainingLocation;

    private BigDecimal trainingMoney;

    private String trainingDate;
    
    private String trainingDateEnd;

    private String attendees;

    private String courseDesc;
    
    private String trainingReason;
    
    private String omId;
    
    private String omName;
    private String trainingType;//类型
    private String director;//负责人
    private List<Accessory> accessory;
    
    
    public String getTrainingDateEnd() {
		return trainingDateEnd;
	}

	public void setTrainingDateEnd(String trainingDateEnd) {
		this.trainingDateEnd = trainingDateEnd;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}

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

    public BigDecimal getTrainingMoney() {
        return trainingMoney;
    }

    public void setTrainingMoney(BigDecimal trainingMoney) {
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