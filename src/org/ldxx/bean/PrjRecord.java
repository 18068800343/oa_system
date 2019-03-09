package org.ldxx.bean;

/** 
* @ClassName: PrjRecord 
* @Description: 项目档案
* @author 
* @date 2019年3月8日 下午5:47:49 
*  
*/
public class PrjRecord {

	private String id;
	private String prjName;
	private String prjNo;
	private String prjType;
	private String scDept;
	private int scStatus;
	private String jyDept;
	private int jyStatus;
	
	
	public int getScStatus() {
		return scStatus;
	}
	public void setScStatus(int scStatus) {
		this.scStatus = scStatus;
	}
	public int getJyStatus() {
		return jyStatus;
	}
	public void setJyStatus(int jyStatus) {
		this.jyStatus = jyStatus;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getPrjNo() {
		return prjNo;
	}
	public void setPrjNo(String prjNo) {
		this.prjNo = prjNo;
	}
	public String getPrjType() {
		return prjType;
	}
	public void setPrjType(String prjType) {
		this.prjType = prjType;
	}
	public String getScDept() {
		return scDept;
	}
	public void setScDept(String scDept) {
		this.scDept = scDept;
	}
	public String getJyDept() {
		return jyDept;
	}
	public void setJyDept(String jyDept) {
		this.jyDept = jyDept;
	}
	
}
