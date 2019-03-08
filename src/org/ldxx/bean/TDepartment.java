package org.ldxx.bean;

/** 
* @ClassName: TDepartment 
* @Description: 检测2部项目部门表
* @author zhaohui
* @date 2018年11月21日 下午4:17:26 
*  
*/
public class TDepartment {

	private String tNo;
	private String dName;
	private float dMoney;
	private float dIncome;
	private String date;
	private String tName;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String gettNo() {
		return tNo;
	}
	public void settNo(String tNo) {
		this.tNo = tNo;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public float getdMoney() {
		return dMoney;
	}
	public void setdMoney(float dMoney) {
		this.dMoney = dMoney;
	}
	public float getdIncome() {
		return dIncome;
	}
	public void setdIncome(float dIncome) {
		this.dIncome = dIncome;
	}
	
}
