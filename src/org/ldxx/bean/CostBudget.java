package org.ldxx.bean;
/**
 * 费用预算
 * @author hp
 *
 */
public class CostBudget {
	
	private String cbId;
	private String classify;//分类
	private String prjDetail;//项目明细
	private String department;//部门
	private String costAmount;//费用金额
	private String cbDesc;//备注
	
	private String name2;//部门名称
	
	
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCbId() {
		return cbId;
	}
	public void setCbId(String cbId) {
		this.cbId = cbId;
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
	public String getCostAmount() {
		return costAmount;
	}
	public void setCostAmount(String costAmount) {
		this.costAmount = costAmount;
	}
	public String getCbDesc() {
		return cbDesc;
	}
	public void setCbDesc(String cbDesc) {
		this.cbDesc = cbDesc;
	}

}
