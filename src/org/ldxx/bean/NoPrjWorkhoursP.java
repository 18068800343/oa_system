package org.ldxx.bean;
//非工时管理添加的人员
public class NoPrjWorkhoursP {
	
	private String pId;
	private String npId;//非项目工时管理的id
	private String pName;//人员
	private String workhours;//工时
	private String pdesc;//备注
	
	
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getNpId() {
		return npId;
	}
	public void setNpId(String npId) {
		this.npId = npId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getWorkhours() {
		return workhours;
	}
	public void setWorkhours(String workhours) {
		this.workhours = workhours;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	
	
	
	

}
