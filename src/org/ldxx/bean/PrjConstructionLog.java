package org.ldxx.bean;

import java.util.List;

//项目施工日志
public class PrjConstructionLog {
    private String pclId;

    private String prjCode;//任务单号

    private String prjName;//项目名称

    private String prjLongTime;//项目工期

    private String weather;//天气
    
    private String temperature;//温度
    
    private String fillTime;//日期

    private List<PrjConstructionLogInfo> prjLogInfo;
    
    private List<Accessory> accessory;
    
	

	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}

	public List<PrjConstructionLogInfo> getPrjLogInfo() {
		return prjLogInfo;
	}

	public void setPrjLogInfo(List<PrjConstructionLogInfo> prjLogInfo) {
		this.prjLogInfo = prjLogInfo;
	}

	public String getPclId() {
		return pclId;
	}

	public void setPclId(String pclId) {
		this.pclId = pclId;
	}

	public String getPrjCode() {
		return prjCode;
	}

	public void setPrjCode(String prjCode) {
		this.prjCode = prjCode;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getPrjLongTime() {
		return prjLongTime;
	}

	public void setPrjLongTime(String prjLongTime) {
		this.prjLongTime = prjLongTime;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getFillTime() {
		return fillTime;
	}

	public void setFillTime(String fillTime) {
		this.fillTime = fillTime;
	}
    
    
}