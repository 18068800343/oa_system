package org.ldxx.bean;
//公司材料退货

public class CompanyMaterialReturn {

	private String cmrId;
	private String materialName;//材料名称
	private String materialType;//材料类型
	private String materialModel;//规格型号
	private String cmrUnit;//单位
	private int dealNumber;//处理数量
	private Float cmrPrice;//采购价格
	private Float cmrMoney ;//金额
	private String applyPerson;//申请人
	private String dealReason;//处理原因
	private String dealMode;//处理方式
	private Float quasiDiscountMoney;//退货出售金额
	private Float actualDiscountMoney;//实际退货出售金额
	private Float costMoney;//成本费用
	private String cmrDesc;
	
	
	
	public String getCmrId() {
		return cmrId;
	}
	public void setCmrId(String cmrId) {
		this.cmrId = cmrId;
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
	public String getCmrUnit() {
		return cmrUnit;
	}
	public void setCmrUnit(String cmrUnit) {
		this.cmrUnit = cmrUnit;
	}
	public int getDealNumber() {
		return dealNumber;
	}
	public void setDealNumber(int dealNumber) {
		this.dealNumber = dealNumber;
	}
	public Float getCmrPrice() {
		return cmrPrice;
	}
	public void setCmrPrice(Float cmrPrice) {
		this.cmrPrice = cmrPrice;
	}
	public Float getCmrMoney() {
		return cmrMoney;
	}
	public void setCmrMoney(Float cmrMoney) {
		this.cmrMoney = cmrMoney;
	}
	public String getApplyPerson() {
		return applyPerson;
	}
	public void setApplyPerson(String applyPerson) {
		this.applyPerson = applyPerson;
	}
	public String getDealReason() {
		return dealReason;
	}
	public void setDealReason(String dealReason) {
		this.dealReason = dealReason;
	}
	public String getDealMode() {
		return dealMode;
	}
	public void setDealMode(String dealMode) {
		this.dealMode = dealMode;
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
	public Float getCostMoney() {
		return costMoney;
	}
	public void setCostMoney(Float costMoney) {
		this.costMoney = costMoney;
	}
	public String getCmrDesc() {
		return cmrDesc;
	}
	public void setCmrDesc(String cmrDesc) {
		this.cmrDesc = cmrDesc;
	}
	
}
