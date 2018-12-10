package org.ldxx.bean;

import java.util.List;

public class ProjectList {
	private String plId;// 编号
	private String plUnit;// 投标部门id
	private String prjName;// 项目名
	private String prjType;// 项目类型
	private String isbiding;// 是否中标
	private String plMoney;// 中标金额

	
	private String omName;//部门名
	private String nameFirst;//一级类型名
	
	private List<Accessory> accessory1;
	private List<Accessory> accessory2;
	private List<Accessory> accessory3;
	
	
	public List<Accessory> getAccessory1() {
		return accessory1;
	}

	public void setAccessory1(List<Accessory> accessory1) {
		this.accessory1 = accessory1;
	}

	public List<Accessory> getAccessory2() {
		return accessory2;
	}

	public void setAccessory2(List<Accessory> accessory2) {
		this.accessory2 = accessory2;
	}

	public List<Accessory> getAccessory3() {
		return accessory3;
	}

	public void setAccessory3(List<Accessory> accessory3) {
		this.accessory3 = accessory3;
	}

	public String getNameFirst() {
		return nameFirst;
	}

	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}

	public String getOmName() {
		return omName;
	}

	public void setOmName(String omName) {
		this.omName = omName;
	}

	public String getPrjType() {
		return prjType;
	}

	public void setPrjType(String prjType) {
		this.prjType = prjType;
	}


	public String getPlId() {
		return plId;
	}

	public void setPlId(String plId) {
		this.plId = plId;
	}

	public String getPlUnit() {
		return plUnit;
	}

	public void setPlUnit(String plUnit) {
		this.plUnit = plUnit;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getIsbiding() {
		return isbiding;
	}

	public void setIsbiding(String isbiding) {
		this.isbiding = isbiding;
	}

	public String getPlMoney() {
		return plMoney;
	}

	public void setPlMoney(String plMoney) {
		this.plMoney = plMoney;
	}
	

}
