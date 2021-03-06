package org.ldxx.bean;

import java.math.BigDecimal;
import java.util.List;

public class AlreadyRenling {
	
	private String rId;
	private String cNo;//合同编号
	private String cName;//合同名
	private String tNo;//任务单号
	private String tName;//项目名
	private String thisPerson;//确认人
	private String skNo;//收款编号
	private String kpNo;//发票申请编号
	private String fpNo;//发票编号
	private String fpDesc;//发票摘要
	private String mainDepartment;//主部门
	private String fkDanwei;//付款单位
	private BigDecimal comeAllMoney;//到账总金额
	private BigDecimal skQuerenMoney;//本次确认金额
	private String querenDate;//确认时间
	private String daozhangDate;//到账时间
	private BigDecimal fpMoney;//发票金额
	private String kpDate;//开票日期
	private String fpShuoming;//认领但未开票需要填写说明
	private String makeTime;//填报时间
	
	private String status;
	private BigDecimal yirenlingallFpMoney;//已认领的发票金额总和
	private List<AlreadySkOmInfo> asoList;
	
	
	
	public String getMakeTime() {
		return makeTime;
	}
	public void setMakeTime(String makeTime) {
		this.makeTime = makeTime;
	}
	public String getFpShuoming() {
		return fpShuoming;
	}
	public void setFpShuoming(String fpShuoming) {
		this.fpShuoming = fpShuoming;
	}
	public BigDecimal getYirenlingallFpMoney() {
		return yirenlingallFpMoney;
	}
	public void setYirenlingallFpMoney(BigDecimal yirenlingallFpMoney) {
		this.yirenlingallFpMoney = yirenlingallFpMoney;
	}
	public List<AlreadySkOmInfo> getAsoList() {
		return asoList;
	}
	public void setAsoList(List<AlreadySkOmInfo> asoList) {
		this.asoList = asoList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getrId() {
		return rId;
	}
	public void setrId(String rId) {
		this.rId = rId;
	}
	public String getcNo() {
		return cNo;
	}
	public void setcNo(String cNo) {
		this.cNo = cNo;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String gettNo() {
		return tNo;
	}
	public void settNo(String tNo) {
		this.tNo = tNo;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String getThisPerson() {
		return thisPerson;
	}
	public void setThisPerson(String thisPerson) {
		this.thisPerson = thisPerson;
	}
	public String getSkNo() {
		return skNo;
	}
	public void setSkNo(String skNo) {
		this.skNo = skNo;
	}
	
	public String getKpNo() {
		return kpNo;
	}
	public void setKpNo(String kpNo) {
		this.kpNo = kpNo;
	}
	public String getFpNo() {
		return fpNo;
	}
	public void setFpNo(String fpNo) {
		this.fpNo = fpNo;
	}
	public String getMainDepartment() {
		return mainDepartment;
	}
	public void setMainDepartment(String mainDepartment) {
		this.mainDepartment = mainDepartment;
	}
	public String getFkDanwei() {
		return fkDanwei;
	}
	public void setFkDanwei(String fkDanwei) {
		this.fkDanwei = fkDanwei;
	}
	public BigDecimal getComeAllMoney() {
		return comeAllMoney;
	}
	public void setComeAllMoney(BigDecimal comeAllMoney) {
		this.comeAllMoney = comeAllMoney;
	}
	public BigDecimal getSkQuerenMoney() {
		return skQuerenMoney;
	}
	public void setSkQuerenMoney(BigDecimal skQuerenMoney) {
		this.skQuerenMoney = skQuerenMoney;
	}
	public String getFpDesc() {
		return fpDesc;
	}
	public void setFpDesc(String fpDesc) {
		this.fpDesc = fpDesc;
	}
	public String getQuerenDate() {
		return querenDate;
	}
	public void setQuerenDate(String querenDate) {
		this.querenDate = querenDate;
	}
	public String getDaozhangDate() {
		return daozhangDate;
	}
	public void setDaozhangDate(String daozhangDate) {
		this.daozhangDate = daozhangDate;
	}
	public BigDecimal getFpMoney() {
		return fpMoney;
	}
	public void setFpMoney(BigDecimal fpMoney) {
		this.fpMoney = fpMoney;
	}
	public String getKpDate() {
		return kpDate;
	}
	public void setKpDate(String kpDate) {
		this.kpDate = kpDate;
	}

}
