package org.ldxx.bean;
//人员工时表
public class PrjWorkingHoursP {
	
	private String gsId;
	private String prjGsId;//项目工时id
	private String name;//人员
	private String type;//分类
	private String workingHours;//工时
	
	
	public String getGsId() {
		return gsId;
	}
	public void setGsId(String gsId) {
		this.gsId = gsId;
	}
	public String getPrjGsId() {
		return prjGsId;
	}
	public void setPrjGsId(String prjGsId) {
		this.prjGsId = prjGsId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}
	
	
}
