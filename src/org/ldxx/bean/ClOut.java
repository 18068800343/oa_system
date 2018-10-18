/**
 * <p>Title: ClOut.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2018年10月13日 下午4:24:42
 */

package org.ldxx.bean;

import java.util.List;

/** 
* @ClassName: ClOut 
* @Description: 项目材料出库
* @author zhaohui
* @date 2018年10月13日 下午4:24:42 
*  
*/
public class ClOut {

	private String outId;
	private String taskNo;
	private String taskName;
	private String getTime;
	private String getPerson;
	private String infos;
	private List<ClOutInfo> cInfo;
	
	
	public List<ClOutInfo> getcInfo() {
		return cInfo;
	}
	public void setcInfo(List<ClOutInfo> cInfo) {
		this.cInfo = cInfo;
	}
	public String getOutId() {
		return outId;
	}
	public void setOutId(String outId) {
		this.outId = outId;
	}
	public String getTaskNo() {
		return taskNo;
	}
	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getGetTime() {
		return getTime;
	}
	public void setGetTime(String getTime) {
		this.getTime = getTime;
	}
	public String getGetPerson() {
		return getPerson;
	}
	public void setGetPerson(String getPerson) {
		this.getPerson = getPerson;
	}
	public String getInfos() {
		return infos;
	}
	public void setInfos(String infos) {
		this.infos = infos;
	}
	
}
