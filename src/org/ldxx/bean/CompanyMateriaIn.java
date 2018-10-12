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
	private String taskNo;//任务单号
	private String materialName;//材料名称
	private String materialType;//材料类型
	private String specificationModel;//规格型号
	private String cmUnit;//单位
	private String cmNumber;// 数量
	private Float cmUnitPrice;//单价
	private Float cmMoney;//金额
	private String sentDate;//收货日期
	private String sentUnit;//来货单位
	private String manufacturer;//生产厂家
	private String omId;//收货人所属部门
	private String collectPerson;//收货人
	private String demandProject;//需求项目
	private String cmDesc;//备注
	private String acceptanceOpinion;//验收及处理意见
	
	private List<Accessory> accessory;

	private String omName;//部门名称
	private String uName; //人员名称
	
	
	
	public String getOmName() {
		return omName;
	}

	public void setOmName(String omName) {
		this.omName = omName;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
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

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getSpecificationModel() {
		return specificationModel;
	}

	public void setSpecificationModel(String specificationModel) {
		this.specificationModel = specificationModel;
	}

	public String getCmUnit() {
		return cmUnit;
	}

	public void setCmUnit(String cmUnit) {
		this.cmUnit = cmUnit;
	}

	public String getCmNumber() {
		return cmNumber;
	}

	public void setCmNumber(String cmNumber) {
		this.cmNumber = cmNumber;
	}

	public Float getCmUnitPrice() {
		return cmUnitPrice;
	}

	public void setCmUnitPrice(Float cmUnitPrice) {
		this.cmUnitPrice = cmUnitPrice;
	}

	public Float getCmMoney() {
		return cmMoney;
	}

	public void setCmMoney(Float cmMoney) {
		this.cmMoney = cmMoney;
	}

	public String getSentDate() {
		return sentDate;
	}

	public void setSentDate(String sentDate) {
		this.sentDate = sentDate;
	}

	public String getSentUnit() {
		return sentUnit;
	}

	public void setSentUnit(String sentUnit) {
		this.sentUnit = sentUnit;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getOmId() {
		return omId;
	}

	public void setOmId(String omId) {
		this.omId = omId;
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
