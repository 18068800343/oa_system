package org.ldxx.bean;

import java.util.List;

//非工时管理
public class NoPrjWorkhours {

	private String npId;
	private String npName;//工时名称
	private String npDepartment;//部门
	private String omName;
	private String makeTime;//填报时间
	private String makePerson;//填报人
	
	private List<NoPrjWorkhoursP> noPrjWorkhoursP;
	
	
	public String getOmName() {
		return omName;
	}
	public void setOmName(String omName) {
		this.omName = omName;
	}
	public List<NoPrjWorkhoursP> getNoPrjWorkhoursP() {
		return noPrjWorkhoursP;
	}
	public void setNoPrjWorkhoursP(List<NoPrjWorkhoursP> noPrjWorkhoursP) {
		this.noPrjWorkhoursP = noPrjWorkhoursP;
	}
	public String getNpId() {
		return npId;
	}
	public void setNpId(String npId) {
		this.npId = npId;
	}
	public String getNpName() {
		return npName;
	}
	public void setNpName(String npName) {
		this.npName = npName;
	}
	public String getNpDepartment() {
		return npDepartment;
	}
	public void setNpDepartment(String npDepartment) {
		this.npDepartment = npDepartment;
	}
	public String getMakeTime() {
		return makeTime;
	}
	public void setMakeTime(String makeTime) {
		this.makeTime = makeTime;
	}
	public String getMakePerson() {
		return makePerson;
	}
	public void setMakePerson(String makePerson) {
		this.makePerson = makePerson;
	}
	
	
	
}
