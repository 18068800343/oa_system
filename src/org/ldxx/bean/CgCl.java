package org.ldxx.bean;
/**
 * 采购合同的材料信息表
 * @author hp
 *
 */
public class CgCl {

	private String cgId;
	private String clName;
	private String clType;
	private String clMode;
	private String clUnit;
	private String clNumber;
	private Double clPrice;
	private Double clMoney;
	private String clPrjSupplier;
	private String clGsSupplier;
	private String clDesc;
	
	private String clspName1;//项目部推荐供应商名称
	private String clspName2;//公司推荐供应商名称
	
	
	
	public String getClspName1() {
		return clspName1;
	}
	public void setClspName1(String clspName1) {
		this.clspName1 = clspName1;
	}
	public String getClspName2() {
		return clspName2;
	}
	public void setClspName2(String clspName2) {
		this.clspName2 = clspName2;
	}
	public String getCgId() {
		return cgId;
	}
	public void setCgId(String cgId) {
		this.cgId = cgId;
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
	
	
}
