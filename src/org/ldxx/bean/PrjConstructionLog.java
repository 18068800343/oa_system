package org.ldxx.bean;
//项目施工日志
public class PrjConstructionLog {
    private String pclId;

    private String prjCode;//任务单号

    private String prjName;//项目名称

    private String prjLongTime;//项目工期

    private String materialCondition;//人机料情况

    private String constructionContent;//施工内容

    private String safetySituation;//安全情况

    private String qualityCondition;//质量情况

    private String weather;//天气

    private String temperature;//温度

    private String fillTime;//日期

    private String tomorrowPlan;//明日计划

    private String otherThings;//其他事项

    private String importentThings;//重大事项
    
    private String constructionSite1;//施工部位1
    
    private String constructionSite2;//施工部位2

    
    
    public String getConstructionSite1() {
		return constructionSite1;
	}

	public void setConstructionSite1(String constructionSite1) {
		this.constructionSite1 = constructionSite1;
	}

	public String getConstructionSite2() {
		return constructionSite2;
	}

	public void setConstructionSite2(String constructionSite2) {
		this.constructionSite2 = constructionSite2;
	}

	public String getPclId() {
        return pclId;
    }

    public void setPclId(String pclId) {
        this.pclId = pclId == null ? null : pclId.trim();
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

    public String getMaterialCondition() {
        return materialCondition;
    }

    public void setMaterialCondition(String materialCondition) {
        this.materialCondition = materialCondition == null ? null : materialCondition.trim();
    }

    public String getConstructionContent() {
        return constructionContent;
    }

    public void setConstructionContent(String constructionContent) {
        this.constructionContent = constructionContent == null ? null : constructionContent.trim();
    }

    public String getSafetySituation() {
        return safetySituation;
    }

    public void setSafetySituation(String safetySituation) {
        this.safetySituation = safetySituation == null ? null : safetySituation.trim();
    }

    public String getQualityCondition() {
        return qualityCondition;
    }

    public void setQualityCondition(String qualityCondition) {
        this.qualityCondition = qualityCondition == null ? null : qualityCondition.trim();
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather == null ? null : weather.trim();
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature == null ? null : temperature.trim();
    }

    public String getFillTime() {
        return fillTime;
    }

    public void setFillTime(String fillTime) {
        this.fillTime = fillTime == null ? null : fillTime.trim();
    }

    public String getTomorrowPlan() {
        return tomorrowPlan;
    }

    public void setTomorrowPlan(String tomorrowPlan) {
        this.tomorrowPlan = tomorrowPlan == null ? null : tomorrowPlan.trim();
    }

    public String getOtherThings() {
        return otherThings;
    }

    public void setOtherThings(String otherThings) {
        this.otherThings = otherThings == null ? null : otherThings.trim();
    }

    public String getImportentThings() {
        return importentThings;
    }

    public void setImportentThings(String importentThings) {
        this.importentThings = importentThings == null ? null : importentThings.trim();
    }
}