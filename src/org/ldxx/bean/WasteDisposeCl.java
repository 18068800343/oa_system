/**
 * <p>Title: wasteDisposeCl.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2018年10月22日 下午4:05:15
 */

package org.ldxx.bean;

/** 
* @ClassName: wasteDisposeCl 
* @Description: 废旧品材料表
* @author zhaohui
* @date 2018年10月22日 下午4:05:15 
*  
*/
public class WasteDisposeCl {

	private String wpId;
	private String materialName;
	private String materialType;
	private String specificationModel;
	private String cmoUnit;
	private int cmoNumber;
	private Double cmoUnitPrice;
	private Double cmoMoney;
	private Double wasteWantMoney;
	private Double wasteActualMoney;
	public String getWpId() {
		return wpId;
	}
	public void setWpId(String wpId) {
		this.wpId = wpId;
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
	public String getCmoUnit() {
		return cmoUnit;
	}
	public void setCmoUnit(String cmoUnit) {
		this.cmoUnit = cmoUnit;
	}
	public int getCmoNumber() {
		return cmoNumber;
	}
	public void setCmoNumber(int cmoNumber) {
		this.cmoNumber = cmoNumber;
	}
	public Double getCmoUnitPrice() {
		return cmoUnitPrice;
	}
	public void setCmoUnitPrice(Double cmoUnitPrice) {
		this.cmoUnitPrice = cmoUnitPrice;
	}
	public Double getCmoMoney() {
		return cmoMoney;
	}
	public void setCmoMoney(Double cmoMoney) {
		this.cmoMoney = cmoMoney;
	}
	public Double getWasteWantMoney() {
		return wasteWantMoney;
	}
	public void setWasteWantMoney(Double wasteWantMoney) {
		this.wasteWantMoney = wasteWantMoney;
	}
	public Double getWasteActualMoney() {
		return wasteActualMoney;
	}
	public void setWasteActualMoney(Double wasteActualMoney) {
		this.wasteActualMoney = wasteActualMoney;
	}
	
}
