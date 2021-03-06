package org.ldxx.bean;

import java.util.List;

public class User {
    private String userId;

    private String username;

    private String password;
    
    private String userCode;//用户编码

    private String workId;

    private String recordNo;

    private String uName;

    private String sex;

    private String birthday;

    private String nation;

    private String marriage;

    private String politicalStatus;

    private String entryTime;

    private String address;

    private String cardId;

    private String postalCode;

    private String fixPhone;

    private String phoneNo;

    private String email;

    private String diploma;

    private String school;

    private String specialty;

    private String graduationTime;

    private String omId;

    private String dutyId;

    private String dutyName;//岗位
    
    private String position;//职称

    private String certificate;
    
    private String certificateGrade;
    
    private String deleteState;//删除状态，0：已删除；1：未删除

    private String omName;//部门
    private String dutyName2;//职务名称
    private String uPermissions;//权限编码
    
    private String userRole;
    
    private String userRoleNames;
    
    private String rtx;
    
    private List<Accessory> accessory;

    private String flowOmNo;
    
	public String getFlowOmNo() {
		return flowOmNo;
	}

	public void setFlowOmNo(String flowOmNo) {
		this.flowOmNo = flowOmNo;
	}

	public String getRtx() {
		return rtx;
	}

	public void setRtx(String rtx) {
		this.rtx = rtx;
	}

	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDeleteState() {
		return deleteState;
	}

	public void setDeleteState(String deleteState) {
		this.deleteState = deleteState;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserRoleNames() {
		return userRoleNames;
	}

	public void setUserRoleNames(String userRoleNames) {
		this.userRoleNames = userRoleNames;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getuPermissions() {
		return uPermissions;
	}

	public void setuPermissions(String uPermissions) {
		this.uPermissions = uPermissions;
	}

	public String getOmName() {
		return omName;
	}

	public void setOmName(String omName) {
		this.omName = omName;
	}

	public String getDutyName2() {
		return dutyName2;
	}

	public void setDutyName2(String dutyName2) {
		this.dutyName2 = dutyName2;
	}

	public String getCertificateGrade() {
		return certificateGrade;
	}

	public void setCertificateGrade(String certificateGrade) {
		this.certificateGrade = certificateGrade;
	}

	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    public String getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(String recordNo) {
        this.recordNo = recordNo == null ? null : recordNo.trim();
    }

    public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage == null ? null : marriage.trim();
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus == null ? null : politicalStatus.trim();
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime == null ? null : entryTime.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode == null ? null : postalCode.trim();
    }

    public String getFixPhone() {
        return fixPhone;
    }

    public void setFixPhone(String fixPhone) {
        this.fixPhone = fixPhone == null ? null : fixPhone.trim();
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma == null ? null : diploma.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty == null ? null : specialty.trim();
    }

    public String getGraduationTime() {
        return graduationTime;
    }

    public void setGraduationTime(String graduationTime) {
        this.graduationTime = graduationTime == null ? null : graduationTime.trim();
    }

    public String getOmId() {
        return omId;
    }

    public void setOmId(String omId) {
        this.omId = omId == null ? null : omId.trim();
    }

    public String getDutyId() {
        return dutyId;
    }

    public void setDutyId(String dutyId) {
        this.dutyId = dutyId == null ? null : dutyId.trim();
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName == null ? null : dutyName.trim();
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate == null ? null : certificate.trim();
    }
}