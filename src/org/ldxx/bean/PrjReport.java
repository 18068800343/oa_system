package org.ldxx.bean;

import java.util.List;

//项目周报/月报
public class PrjReport {
    private String prId;

    private String prjCode;//任务单号

    private String prjName;//项目名称

    private String prjLongTime;//项目工期

    private String reportTableKind;//报表性质

    private String fillTime;//日期

    private String thistimePrjText;//本期项目内容

    private String prjSafetyMaybeText;//项目安全概述

    private String prjQuatityMaybeText;//项目质量概述

    private String fbManageSituation;//分包管理情况

    private String changeSituation;//变更情况

    private String importentThings;//重大事项

    private String needCompanyCooperation;//需要公司协调

    private String otherThings;//其他事项

    private String maybeText;//概述

    private Integer prType;//报表类型(0:周报表 1:月报表)

    private List<Accessory> accessory;
    
    
    public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}

	public String getPrId() {
        return prId;
    }

    public void setPrId(String prId) {
        this.prId = prId == null ? null : prId.trim();
    }

    public String getPrjCode() {
        return prjCode;
    }

    public void setPrjCode(String prjCode) {
        this.prjCode = prjCode == null ? null : prjCode.trim();
    }

    public String getPrjName() {
        return prjName;
    }

    public void setPrjName(String prjName) {
        this.prjName = prjName == null ? null : prjName.trim();
    }

    public String getPrjLongTime() {
        return prjLongTime;
    }

    public void setPrjLongTime(String prjLongTime) {
        this.prjLongTime = prjLongTime == null ? null : prjLongTime.trim();
    }

    public String getReportTableKind() {
        return reportTableKind;
    }

    public void setReportTableKind(String reportTableKind) {
        this.reportTableKind = reportTableKind == null ? null : reportTableKind.trim();
    }

    public String getFillTime() {
        return fillTime;
    }

    public void setFillTime(String fillTime) {
        this.fillTime = fillTime == null ? null : fillTime.trim();
    }

    public String getThistimePrjText() {
        return thistimePrjText;
    }

    public void setThistimePrjText(String thistimePrjText) {
        this.thistimePrjText = thistimePrjText == null ? null : thistimePrjText.trim();
    }

    public String getPrjSafetyMaybeText() {
        return prjSafetyMaybeText;
    }

    public void setPrjSafetyMaybeText(String prjSafetyMaybeText) {
        this.prjSafetyMaybeText = prjSafetyMaybeText == null ? null : prjSafetyMaybeText.trim();
    }

    public String getPrjQuatityMaybeText() {
        return prjQuatityMaybeText;
    }

    public void setPrjQuatityMaybeText(String prjQuatityMaybeText) {
        this.prjQuatityMaybeText = prjQuatityMaybeText == null ? null : prjQuatityMaybeText.trim();
    }

    public String getFbManageSituation() {
        return fbManageSituation;
    }

    public void setFbManageSituation(String fbManageSituation) {
        this.fbManageSituation = fbManageSituation == null ? null : fbManageSituation.trim();
    }

    public String getChangeSituation() {
        return changeSituation;
    }

    public void setChangeSituation(String changeSituation) {
        this.changeSituation = changeSituation == null ? null : changeSituation.trim();
    }

    public String getImportentThings() {
        return importentThings;
    }

    public void setImportentThings(String importentThings) {
        this.importentThings = importentThings == null ? null : importentThings.trim();
    }

    public String getNeedCompanyCooperation() {
        return needCompanyCooperation;
    }

    public void setNeedCompanyCooperation(String needCompanyCooperation) {
        this.needCompanyCooperation = needCompanyCooperation == null ? null : needCompanyCooperation.trim();
    }

    public String getOtherThings() {
        return otherThings;
    }

    public void setOtherThings(String otherThings) {
        this.otherThings = otherThings == null ? null : otherThings.trim();
    }


    public String getMaybeText() {
        return maybeText;
    }

    public void setMaybeText(String maybeText) {
        this.maybeText = maybeText == null ? null : maybeText.trim();
    }


    public Integer getPrType() {
        return prType;
    }

    public void setPrType(Integer prType) {
        this.prType = prType;
    }
}