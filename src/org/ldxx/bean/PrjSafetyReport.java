package org.ldxx.bean;

/** 
* @ClassName: PrjSafetyReport 
* @Description: 质量安全项目报表
* @author zhaohui
* @date 2019年1月2日 下午5:33:40 
*  
*/
public class PrjSafetyReport {
	
	private String prjNo;
	private String prjName;
	private String prjType2;
	private String uName;//项目负责人
	private String importance;//重要度
	private String allMoney;//进度
	private String fristDesign;//初步设计
	private String secondDesign;//施工图设计
	
	
	public String getFristDesign() {
		return fristDesign;
	}
	public void setFristDesign(String fristDesign) {
		this.fristDesign = fristDesign;
	}
	public String getSecondDesign() {
		return secondDesign;
	}
	public void setSecondDesign(String secondDesign) {
		this.secondDesign = secondDesign;
	}
	public String getPrjNo() {
		return prjNo;
	}
	public void setPrjNo(String prjNo) {
		this.prjNo = prjNo;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getPrjType2() {
		return prjType2;
	}
	public void setPrjType2(String prjType2) {
		this.prjType2 = prjType2;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getImportance() {
		return importance;
	}
	public void setImportance(String importance) {
		this.importance = importance;
	}
	public String getAllMoney() {
		return allMoney;
	}
	public void setAllMoney(String allMoney) {
		this.allMoney = allMoney;
	}
	
}
