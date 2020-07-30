package org.ldxx.bean;

import java.math.BigDecimal;

//废旧品材料信息
public class GsMaterialWastetreatmentCl {
	private String cwmclId;
	private String materialName;//材料名称
	private String materialType;//材料类型
	private String materialModel;//规格型号
	private String unit;//单位
	private int dealNumber;//处理数量
	private BigDecimal price;//采购单价
	private BigDecimal money ;//金额
	private BigDecimal quasiDiscountMoney;//拟折价出售金额
	private BigDecimal actualDiscountMoney;//实际折价出售金额
	
	
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public BigDecimal getQuasiDiscountMoney() {
		return quasiDiscountMoney;
	}
	public void setQuasiDiscountMoney(BigDecimal quasiDiscountMoney) {
		this.quasiDiscountMoney = quasiDiscountMoney;
	}
	public BigDecimal getActualDiscountMoney() {
		return actualDiscountMoney;
	}
	public void setActualDiscountMoney(BigDecimal actualDiscountMoney) {
		this.actualDiscountMoney = actualDiscountMoney;
	}
	
	
	
	
	

	
}
