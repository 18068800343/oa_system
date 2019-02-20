package org.ldxx.bean;

/** 
* @ClassName: WxCost 
* @Description: 外协费用
* @author aa
* @date 2019年2月20日 下午2:25:44 
*  
*/
public class WxCost {

	private String wxId;
	private String prjName;
	private String prjNo;
	private String wxName;
	private double wxCost;
	
	public String getWxId() {
		return wxId;
	}
	public void setWxId(String wxId) {
		this.wxId = wxId;
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
	public String getWxName() {
		return wxName;
	}
	public void setWxName(String wxName) {
		this.wxName = wxName;
	}
	public double getWxCost() {
		return wxCost;
	}
	public void setWxCost(double wxCost) {
		this.wxCost = wxCost;
	}
	
}
