package org.ldxx.bean;

public class ProjectList {
	private String plId;// 编号
	private String plUnit;// 投标部门id
	private String prjName;// 项目名
	private String prjType;// 项目类型
	private String isbiding;// 是否中标
	private String plMoney;// 中标金额
	private String zhaofile;// 招标文件
	private String zhaofileUrl;// 招标文件地址
	private String toufile;// 投标文件
	private String toufileUrl;// 投标文件地址
	private String drawing;// 图纸
	private String drawingUrl;// 图纸地址

	
	private String omName;//部门名
	private String nameFirst;//一级类型名
	
	
	
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

	public String getZhaofile() {
		return zhaofile;
	}

	public void setZhaofile(String zhaofile) {
		this.zhaofile = zhaofile;
	}

	public String getZhaofileUrl() {
		return zhaofileUrl;
	}

	public void setZhaofileUrl(String zhaofileUrl) {
		this.zhaofileUrl = zhaofileUrl;
	}

	public String getToufile() {
		return toufile;
	}

	public void setToufile(String toufile) {
		this.toufile = toufile;
	}

	public String getToufileUrl() {
		return toufileUrl;
	}

	public void setToufileUrl(String toufileUrl) {
		this.toufileUrl = toufileUrl;
	}

	public String getDrawing() {
		return drawing;
	}

	public void setDrawing(String drawing) {
		this.drawing = drawing;
	}

	public String getDrawingUrl() {
		return drawingUrl;
	}

	public void setDrawingUrl(String drawingUrl) {
		this.drawingUrl = drawingUrl;
	}

}
