package org.ldxx.bean;

public class CompanyMaterialInCl {
	private String clId;
	private String gsInId;
	private String clName;
	private String clType;
	private String clMode;
	private String clUnit;
	private String clNumber;
	private Double  clPrice;
	private Double  clMoney;			//金额=数量*单价
	private String clPrjSupplier;
	private String clGsSupplier;
	private String clDesc;
	private String clComeUnit;		//来货单位
	private String clManufacturer;	//生产厂家
	private String clRemain;//材料剩余数量
	
	private String clspNamexm;//项目部推荐供应商名称
	private String clspNamegs;//公司推荐供应商名称
	private String taskNo;				//任务单号
	private String demandProject;		//需求项目
	
	private outRemain outRemain;
	
	
	
	public outRemain getOutRemain() {
		return outRemain;
	}
	public void setOutRemain(outRemain outRemain) {
		this.outRemain = outRemain;
	}
	public String getClRemain() {
		return clRemain;
	}
	public void setClRemain(String clRemain) {
		this.clRemain = clRemain;
	}
	public String getClId() {
		return clId;
	}
	public void setClId(String clId) {
		this.clId = clId;
	}
	public String getTaskNo() {
		return taskNo;
	}
	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}
	public String getDemandProject() {
		return demandProject;
	}
	public void setDemandProject(String demandProject) {
		this.demandProject = demandProject;
	}
	public String getGsInId() {
		return gsInId;
	}
	public void setGsInId(String gsInId) {
		this.gsInId = gsInId;
	}
	public String getClName() {
		return clName;
	}
	public void setClName(String clName) {
		this.clName = clName;
	}
	public String getClType() {
		return clType;
	}
	public void setClType(String clType) {
		this.clType = clType;
	}
	public String getClMode() {
		return clMode;
	}
	public void setClMode(String clMode) {
		this.clMode = clMode;
	}
	public String getClUnit() {
		return clUnit;
	}
	public void setClUnit(String clUnit) {
		this.clUnit = clUnit;
	}
	public String getClNumber() {
		return clNumber;
	}
	public void setClNumber(String clNumber) {
		this.clNumber = clNumber;
	}
	public Double getClPrice() {
		return clPrice;
	}
	public void setClPrice(Double clPrice) {
		this.clPrice = clPrice;
	}
	public Double getClMoney() {
		return clMoney;
	}
	public void setClMoney(Double clMoney) {
		this.clMoney = clMoney;
	}
	public String getClPrjSupplier() {
		return clPrjSupplier;
	}
	public void setClPrjSupplier(String clPrjSupplier) {
		this.clPrjSupplier = clPrjSupplier;
	}
	public String getClGsSupplier() {
		return clGsSupplier;
	}
	public void setClGsSupplier(String clGsSupplier) {
		this.clGsSupplier = clGsSupplier;
	}
	public String getClDesc() {
		return clDesc;
	}
	public void setClDesc(String clDesc) {
		this.clDesc = clDesc;
	}
	public String getClComeUnit() {
		return clComeUnit;
	}
	public void setClComeUnit(String clComeUnit) {
		this.clComeUnit = clComeUnit;
	}
	public String getClManufacturer() {
		return clManufacturer;
	}
	public void setClManufacturer(String clManufacturer) {
		this.clManufacturer = clManufacturer;
	}
	public String getClspNamexm() {
		return clspNamexm;
	}
	public void setClspNamexm(String clspNamexm) {
		this.clspNamexm = clspNamexm;
	}
	public String getClspNamegs() {
		return clspNamegs;
	}
	public void setClspNamegs(String clspNamegs) {
		this.clspNamegs = clspNamegs;
	}
	
	

}
