package org.ldxx.bean;

/**
 * 预算主材料表
 * @author hp
 *
 */
public class BudgetMainMaterial {
	
	private String bId;
	private String materName;//材料名
	private String materType;//材料类型
	private String materMode;//材料型号
	private String materUnit;//单位
	private String materNumber;//预算数量
	private String materPrice;//单价
	private String department;//bumen
	
	private String sjMaterNumber;//清单数量
	
	private String clomName;//部门名称
	
	
	public String getSjMaterNumber() {
		return sjMaterNumber;
	}
	public void setSjMaterNumber(String sjMaterNumber) {
		this.sjMaterNumber = sjMaterNumber;
	}
	public String getClomName() {
		return clomName;
	}
	public void setClomName(String clomName) {
		this.clomName = clomName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getbId() {
		return bId;
	}
	public void setbId(String bId) {
		this.bId = bId;
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
	public String getMaterPrice() {
		return materPrice;
	}
	public void setMaterPrice(String materPrice) {
		this.materPrice = materPrice;
	}
	
	
	

}
