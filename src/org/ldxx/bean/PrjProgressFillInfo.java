/**
 * <p>Title: PrjProgressFillInfo.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2018年10月23日 下午1:44:11
 */

package org.ldxx.bean;

/** 
* @ClassName: PrjProgressFillInfo 
* @Description: 进度管理详情
* @author zhaohui
* @date 2018年10月23日 下午1:44:11 
*  
*/
public class PrjProgressFillInfo {

	private String ppfId;
	private String department;
	private float money;
	private String type;//1:累计收入,2:本期收入,3:本期收款,4:累计收款,5:本期成本,6:累计成本
	private String main;//是否为主办 1：主办 0：协办
	
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getPpfId() {
		return ppfId;
	}
	public void setPpfId(String ppfId) {
		this.ppfId = ppfId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
