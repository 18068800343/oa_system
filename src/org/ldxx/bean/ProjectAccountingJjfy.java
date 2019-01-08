package org.ldxx.bean;

//项目核算的间接费用
public class ProjectAccountingJjfy {
	
	private String paId;
	private String prjDetail;//项目明细
	private Float indirectMoney;//金额
	
	
	public String getPaId() {
		return paId;
	}
	public void setPaId(String paId) {
		this.paId = paId;
	}
	public String getPrjDetail() {
		return prjDetail;
	}
	public void setPrjDetail(String prjDetail) {
		this.prjDetail = prjDetail;
	}
	public Float getIndirectMoney() {
		return indirectMoney;
	}
	public void setIndirectMoney(Float indirectMoney) {
		this.indirectMoney = indirectMoney;
	}
	
	
	

}
