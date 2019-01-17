package org.ldxx.bean;

//废旧品材料信息
public class GsMaterialWastetreatmentCl {
	private String cwmclId;
	private String materialName;//材料名称
	private String materialType;//材料类型
	private String materialModel;//规格型号
	private String unit;//单位
	private int dealNumber;//处理数量
	private Float price;//采购单价
	private Float money ;//金额
	private Float quasiDiscountMoney;//拟折价出售金额
	private Float actualDiscountMoney;//实际折价出售金额
	
	
	public String getCwmclId() {
		return cwmclId;
	}
	public void setCwmclId(String cwmclId) {
		this.cwmclId = cwmclId;
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
	public String getMaterialModel() {
		return materialModel;
	}
	public void setMaterialModel(String materialModel) {
		this.materialModel = materialModel;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getDealNumber() {
		return dealNumber;
	}
	public void setDealNumber(int dealNumber) {
		this.dealNumber = dealNumber;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getMoney() {
		return money;
	}
	public void setMoney(Float money) {
		this.money = money;
	}
	public Float getQuasiDiscountMoney() {
		return quasiDiscountMoney;
	}
	public void setQuasiDiscountMoney(Float quasiDiscountMoney) {
		this.quasiDiscountMoney = quasiDiscountMoney;
	}
	public Float getActualDiscountMoney() {
		return actualDiscountMoney;
	}
	public void setActualDiscountMoney(Float actualDiscountMoney) {
		this.actualDiscountMoney = actualDiscountMoney;
	}
	
	
	
	
	

	
}
