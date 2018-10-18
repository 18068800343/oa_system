package org.ldxx.bean;

import java.util.List;

/**
 *  公司材料入库
 * @author hp
 *
 */
public class CompanyMateriaIn {

	private String cmId;
	private String cgNo;//采购合同号
	private String cgName;//采购合同名
	private String taskNo;//任务单号
	private String demandProject;//需求项目
	private String sentDate;//收货日期
	private String collectPerson;//收货人
	private String cmDesc;//备注
	private String acceptanceOpinion;//验收及处理意见
	private String buyNo;
	
	private List<Accessory> accessory;

	

	public String getBuyNo() {
		return buyNo;
	}

	public void setBuyNo(String buyNo) {
		this.buyNo = buyNo;
	}

	public String getCgName() {
		return cgName;
	}

	public void setCgName(String cgName) {
		this.cgName = cgName;
	}


	public String getCmId() {
		return cmId;
	}

	public void setCmId(String cmId) {
		this.cmId = cmId;
	}

	public String getCgNo() {
		return cgNo;
	}

	public void setCgNo(String cgNo) {
		this.cgNo = cgNo;
	}

	public String getTaskNo() {
		return taskNo;
	}

	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}


	public String getSentDate() {
		return sentDate;
	}

	public void setSentDate(String sentDate) {
		this.sentDate = sentDate;
	}



	public String getCollectPerson() {
		return collectPerson;
	}

	public void setCollectPerson(String collectPerson) {
		this.collectPerson = collectPerson;
	}

	public String getDemandProject() {
		return demandProject;
	}

	public void setDemandProject(String demandProject) {
		this.demandProject = demandProject;
	}

	public String getCmDesc() {
		return cmDesc;
	}

	public void setCmDesc(String cmDesc) {
		this.cmDesc = cmDesc;
	}

	public String getAcceptanceOpinion() {
		return acceptanceOpinion;
	}

	public void setAcceptanceOpinion(String acceptanceOpinion) {
		this.acceptanceOpinion = acceptanceOpinion;
	}


	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}
	
	
}
