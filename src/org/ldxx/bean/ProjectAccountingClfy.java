package org.ldxx.bean;
//项目核算的材料费用
public class ProjectAccountingClfy {
	
	private String paId;
	private String materName;//材料名
	private String materType;//材料类型
	private String materMode;//材料型号
	private String materUnit;//单位
	private String materNumber;//数量
	private Float materPrice;//单价
	
	private Float materMoney;//材料费用
	
	
	
	public Float getMaterMoney() {
		return materMoney;
	}
	public void setMaterMoney(Float materMoney) {
		this.materMoney = materMoney;
	}
	public String getPaId() {
		return paId;
	}
	public void setPaId(String paId) {
		this.paId = paId;
	}
	public String getMaterName() {
		return materName;
	}
	public void setMaterName(String materName) {
		this.materName = materName;
	}
	public String getMaterType() {
		return materType;
	}
	public void setMaterType(String materType) {
		this.materType = materType;
	}
	public String getMaterMode() {
		return materMode;
	}
	public void setMaterMode(String materMode) {
		this.materMode = materMode;
	}
	public String getMaterUnit() {
		return materUnit;
	}
	public void setMaterUnit(String materUnit) {
		this.materUnit = materUnit;
	}
	public String getMaterNumber() {
		return materNumber;
	}
	public void setMaterNumber(String materNumber) {
		this.materNumber = materNumber;
	}
	public Float getMaterPrice() {
		return materPrice;
	}
	public void setMaterPrice(Float materPrice) {
		this.materPrice = materPrice;
	}

	
	
}
