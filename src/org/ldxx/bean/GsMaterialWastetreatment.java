package org.ldxx.bean;
/**
 * 公司材料废旧品处理
 * @author hp
 *
 */
public class GsMaterialWastetreatment {
	
	private String cmwId;
	private String materialName;//材料名称
	private String materialType;//材料类型
	private String materialModel;//规格型号
	private String cmwUnit;//单位
	private int dealNumber;//处理数量
	private Float cmwPrice;//采购价格
	private Float cmwMoney ;//金额
	private String applyPerson;//申请人
	private String dealReason;//处理原因
	private String dealMode;//处理方式
	private Float quasiDiscountMoney;//拟折价出售金额
	private Float actualDiscountMoney;//实际折价出售金额
	private Float costMoney;//成本费用
	private String cmwDesc;
	
	
	
	public String getCmwId() {
		return cmwId;
	}
	public void setCmwId(String cmwId) {
		this.cmwId = cmwId;
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
	public String getCmwUnit() {
		return cmwUnit;
	}
	public void setCmwUnit(String cmwUnit) {
		this.cmwUnit = cmwUnit;
	}
	public int getDealNumber() {
		return dealNumber;
	}
	public void setDealNumber(int dealNumber) {
		this.dealNumber = dealNumber;
	}
	public Float getCmwPrice() {
		return cmwPrice;
	}
	public void setCmwPrice(Float cmwPrice) {
		this.cmwPrice = cmwPrice;
	}
	public Float getCmwMoney() {
		return cmwMoney;
	}
	public void setCmwMoney(Float cmwMoney) {
		this.cmwMoney = cmwMoney;
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
	public String getCmwDesc() {
		return cmwDesc;
	}
	public void setCmwDesc(String cmwDesc) {
		this.cmwDesc = cmwDesc;
	}
	
}
