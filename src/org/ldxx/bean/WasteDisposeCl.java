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
	private float cmoUnitPrice;
	private float cmoMoney;
	private float wasteWantMoney;
	private float wasteActualMoney;
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
	public float getCmoUnitPrice() {
		return cmoUnitPrice;
	}
	public void setCmoUnitPrice(float cmoUnitPrice) {
		this.cmoUnitPrice = cmoUnitPrice;
	}
	public float getCmoMoney() {
		return cmoMoney;
	}
	public void setCmoMoney(float cmoMoney) {
		this.cmoMoney = cmoMoney;
	}
	public float getWasteWantMoney() {
		return wasteWantMoney;
	}
	public void setWasteWantMoney(float wasteWantMoney) {
		this.wasteWantMoney = wasteWantMoney;
	}
	public float getWasteActualMoney() {
		return wasteActualMoney;
	}
	public void setWasteActualMoney(float wasteActualMoney) {
		this.wasteActualMoney = wasteActualMoney;
	}
	
}
