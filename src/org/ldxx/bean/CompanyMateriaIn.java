package org.ldxx.bean;

import java.util.List;

/**
 *  公司材料入库
 * @author hp
 *
 */
public class CompanyMateriaIn {

	private String cmId;
	private String cgNo;				//采购合同号
	private String cgName;				//采购合同名
	private String taskNo;				//任务单号
	private String demandProject;		//需求项目
	private String sentDate;			//收货日期
	private String collectPerson;		//公司材料收货人
	private String cmDesc;				//备注
	private String acceptanceOpinion;	//验收及处理意见
	private String freight;				//运费
	private String OutState;			//出库状态；0:未出库;1：公司出库;2:项目出库;3::结余转出
	private String getPerson;//项目材料收货人
	private String getInfos;//项目验收及意见
	private String getStatus;//收货状态 0：未确认收货 1：确认收货
	private String remainType;//结余状态 0 未结余 1 已结余
	
	private List<Accessory> accessory;
	private List<CompanyMaterialInCl> gsInCl;//公司材料信息
	

	

	public String getGetInfos() {
		return getInfos;
	}

	public void setGetInfos(String getInfos) {
		this.getInfos = getInfos;
	}

	public String getGetPerson() {
		return getPerson;
	}

	public void setGetPerson(String getPerson) {
		this.getPerson = getPerson;
	}

	public String getGetStatus() {
		return getStatus;
	}

	public void setGetStatus(String getStatus) {
		this.getStatus = getStatus;
	}

	public String getRemainType() {
		return remainType;
	}

	public void setRemainType(String remainType) {
		this.remainType = remainType;
	}

	public List<CompanyMaterialInCl> getGsInCl() {
		return gsInCl;
	}

	public void setGsInCl(List<CompanyMaterialInCl> gsInCl) {
		this.gsInCl = gsInCl;
	}

	public String getOutState() {
		return OutState;
	}

	public void setOutState(String outState) {
		OutState = outState;
	}

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
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
