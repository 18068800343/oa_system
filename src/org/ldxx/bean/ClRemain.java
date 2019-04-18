/**
 * <p>Title: ClRemain.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2018年10月18日 下午1:43:54
 */

package org.ldxx.bean;

/** 
* @ClassName: ClRemain 
* @Description: 材料结余表
* @author zhaohui
* @date 2018年10月18日 下午1:43:54 
*  
*/
public class ClRemain {
	
	private String crId;	
	private String gsOutId;
	private String materialName;
	private String materialType;
	private String specificationModel;
	private String cmoUnit;
	private int cmoNumber;
	private int remainNumber;
	private Double cmoUnitPrice;
	private Double cmoMoney;
	private String pickDate;
	private outRemain outRemain;
	private String oldClId;//入库的材料id
	
	
	public String getOldClId() {
		return oldClId;
	}
	public void setOldClId(String oldClId) {
		this.oldClId = oldClId;
	}
	public outRemain getOutRemain() {
		return outRemain;
	}
	public void setOutRemain(outRemain outRemain) {
		this.outRemain = outRemain;
	}
	public String getCrId() {
		return crId;
	}
	public void setCrId(String crId) {
		this.crId = crId;
	}
	public String getGsOutId() {
		return gsOutId;
	}
	public void setGsOutId(String gsOutId) {
		this.gsOutId = gsOutId;
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
	public int getRemainNumber() {
		return remainNumber;
	}
	public void setRemainNumber(int remainNumber) {
		this.remainNumber = remainNumber;
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
	public String getPickDate() {
		return pickDate;
	}
	public void setPickDate(String pickDate) {
		this.pickDate = pickDate;
	}

}
