/**
 * <p>Title: wasteDispose.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2018年10月22日 下午4:02:20
 */

package org.ldxx.bean;

import java.util.List;

/** 
* @ClassName: wasteDispose 
* @Description: 项目废旧品
* @author zhaohui
* @date 2018年10月22日 下午4:02:20 
*  
*/
public class WasteDispose {

	private String wpId;
	private String cgNo;
	private String cgName;
	private String taskNo;
	private String pickProject;
	private String wastePerson;
	private String wasteTime;
	private String wasteReason;
	private String wasteType;
	private Double wasteMoney;
	private String wasteDesc;
	private List<WasteDisposeCl> wdc;
	private List<outRemain> oRemain;
	
	
	public List<outRemain> getoRemain() {
		return oRemain;
	}
	public void setoRemain(List<outRemain> oRemain) {
		this.oRemain = oRemain;
	}
	public List<WasteDisposeCl> getWdc() {
		return wdc;
	}
	public void setWdc(List<WasteDisposeCl> wdc) {
		this.wdc = wdc;
	}
	public String getWpId() {
		return wpId;
	}
	public void setWpId(String wpId) {
		this.wpId = wpId;
	}
	public String getCgNo() {
		return cgNo;
	}
	public void setCgNo(String cgNo) {
		this.cgNo = cgNo;
	}
	public String getCgName() {
		return cgName;
	}
	public void setCgName(String cgName) {
		this.cgName = cgName;
	}
	public String getTaskNo() {
		return taskNo;
	}
	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}
	public String getPickProject() {
		return pickProject;
	}
	public void setPickProject(String pickProject) {
		this.pickProject = pickProject;
	}
	public String getWastePerson() {
		return wastePerson;
	}
	public void setWastePerson(String wastePerson) {
		this.wastePerson = wastePerson;
	}
	public String getWasteTime() {
		return wasteTime;
	}
	public void setWasteTime(String wasteTime) {
		this.wasteTime = wasteTime;
	}
	public String getWasteReason() {
		return wasteReason;
	}
	public void setWasteReason(String wasteReason) {
		this.wasteReason = wasteReason;
	}
	public String getWasteType() {
		return wasteType;
	}
	public void setWasteType(String wasteType) {
		this.wasteType = wasteType;
	}
	public Double getWasteMoney() {
		return wasteMoney;
	}
	public void setWasteMoney(Double wasteMoney) {
		this.wasteMoney = wasteMoney;
	}
	public String getWasteDesc() {
		return wasteDesc;
	}
	public void setWasteDesc(String wasteDesc) {
		this.wasteDesc = wasteDesc;
	}
	
}
