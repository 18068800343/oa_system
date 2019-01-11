package org.ldxx.bean;

public class CompanyCost {

	private String id;
	private String xuhao;
	private String prjName;
	private String taskCode;
	private String departId;
	private String departName;
	private Double money;
	private String date;
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXuhao() {
		return xuhao;
	}
	public void setXuhao(String xuhao) {
		this.xuhao = xuhao;
	}
	public String getTaskCode() {
		return taskCode;
	}
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public String getDepartId() {
		return departId;
	}
	public void setDepartId(String departId) {
		this.departId = departId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
