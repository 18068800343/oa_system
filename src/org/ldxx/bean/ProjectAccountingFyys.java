package org.ldxx.bean;
//项目核算的费用预算
public class ProjectAccountingFyys {
	
	private String paId;
	private String classify;//分类
	private String prjDetail;//项目明细
	private String department;//部门
	private Float costAmount;//费用金额
	private String cbDesc;//备注
	
	private String omName;
	
	public String getOmName() {
		return omName;
	}
	public void setOmName(String omName) {
		this.omName = omName;
	}
	public String getPaId() {
		return paId;
	}
	public void setPaId(String paId) {
		this.paId = paId;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getPrjDetail() {
		return prjDetail;
	}
	public void setPrjDetail(String prjDetail) {
		this.prjDetail = prjDetail;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Float getCostAmount() {
		return costAmount;
	}
	public void setCostAmount(Float costAmount) {
		this.costAmount = costAmount;
	}
	public String getCbDesc() {
		return cbDesc;
	}
	public void setCbDesc(String cbDesc) {
		this.cbDesc = cbDesc;
	}

	
	
}
