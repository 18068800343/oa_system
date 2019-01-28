package org.ldxx.bean;

public class FbContractDoAppointScore {
    private String fcdId;

    private String taskListCode;//任务单号

    private String cjContractCode;//承接合同号

    private String cjContractName;//承接合同名称

    private String fbContractCode;//分包合同编号

    private String fbContractName;//分包合同名称

    private String fbDepartment;//分包单位

    private String actualChargePerson;//实际负责人

    private String scoreMaterialSituation;//人员、材料和设备配置情况

    private String scoreManageAbility;//施工经验、施工组织管理能力

    private String scoreQualityControl;//质量控制

    private String scoreCompanyReputation;//企业信誉

    private String scoreJinduControl;//进度控制

    /*private String safetyCivilizationEnvironment;//安全文明与环保*/
    
    private String allScore;//综合评价
    
    private String thisYear;//年份

    
    public String getThisYear() {
		return thisYear;
	}

	public void setThisYear(String thisYear) {
		this.thisYear = thisYear;
	}

	public String getFcdId() {
        return fcdId;
    }

    public void setFcdId(String fcdId) {
        this.fcdId = fcdId == null ? null : fcdId.trim();
    }

    public String getTaskListCode() {
        return taskListCode;
    }

    public void setTaskListCode(String taskListCode) {
        this.taskListCode = taskListCode == null ? null : taskListCode.trim();
    }

    public String getCjContractCode() {
        return cjContractCode;
    }

    public void setCjContractCode(String cjContractCode) {
        this.cjContractCode = cjContractCode == null ? null : cjContractCode.trim();
    }

    public String getCjContractName() {
        return cjContractName;
    }

    public void setCjContractName(String cjContractName) {
        this.cjContractName = cjContractName == null ? null : cjContractName.trim();
    }

    public String getFbContractCode() {
        return fbContractCode;
    }

    public void setFbContractCode(String fbContractCode) {
        this.fbContractCode = fbContractCode == null ? null : fbContractCode.trim();
    }

    public String getFbContractName() {
        return fbContractName;
    }

    public void setFbContractName(String fbContractName) {
        this.fbContractName = fbContractName == null ? null : fbContractName.trim();
    }

    public String getFbDepartment() {
        return fbDepartment;
    }

    public void setFbDepartment(String fbDepartment) {
        this.fbDepartment = fbDepartment == null ? null : fbDepartment.trim();
    }

    public String getActualChargePerson() {
        return actualChargePerson;
    }

    public void setActualChargePerson(String actualChargePerson) {
        this.actualChargePerson = actualChargePerson == null ? null : actualChargePerson.trim();
    }

    public String getScoreMaterialSituation() {
        return scoreMaterialSituation;
    }

    public void setScoreMaterialSituation(String scoreMaterialSituation) {
        this.scoreMaterialSituation = scoreMaterialSituation == null ? null : scoreMaterialSituation.trim();
    }

    public String getScoreManageAbility() {
        return scoreManageAbility;
    }

    public void setScoreManageAbility(String scoreManageAbility) {
        this.scoreManageAbility = scoreManageAbility == null ? null : scoreManageAbility.trim();
    }

    public String getScoreQualityControl() {
        return scoreQualityControl;
    }

    public void setScoreQualityControl(String scoreQualityControl) {
        this.scoreQualityControl = scoreQualityControl == null ? null : scoreQualityControl.trim();
    }

    public String getScoreCompanyReputation() {
        return scoreCompanyReputation;
    }

    public void setScoreCompanyReputation(String scoreCompanyReputation) {
        this.scoreCompanyReputation = scoreCompanyReputation == null ? null : scoreCompanyReputation.trim();
    }

    public String getScoreJinduControl() {
        return scoreJinduControl;
    }

    public void setScoreJinduControl(String scoreJinduControl) {
        this.scoreJinduControl = scoreJinduControl == null ? null : scoreJinduControl.trim();
    }

    public String getAllScore() {
        return allScore;
    }

    public void setAllScore(String allScore) {
        this.allScore = allScore == null ? null : allScore.trim();
    }
}