package org.ldxx.bean;

import java.math.BigDecimal;
import java.util.List;

/**
 * 公司材料废旧品处理
 * @author hp
 *
 */
public class GsMaterialWastetreatment {
	
	private String cmwId;
	private String prjName;
	private String prjNo;
	private String applyPerson;//申请人
	private String applyDate;//申请时间
	private String dealReason;//处理原因
	private String dealMode;//处理方式
	private BigDecimal costMoney;//成本费用
	private String cmwDesc;
	private String type;//0:废旧品处理；1：退货
	private List<GsMaterialWastetreatmentCl> gsMaterialWastetreatmentCl;
	private List<outRemain> oRemain;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public List<outRemain> getoRemain() {
		return oRemain;
	}
	public void setoRemain(List<outRemain> oRemain) {
		this.oRemain = oRemain;
	}
	public List<GsMaterialWastetreatmentCl> getGsMaterialWastetreatmentCl() {
		return gsMaterialWastetreatmentCl;
	}
	public void setGsMaterialWastetreatmentCl(List<GsMaterialWastetreatmentCl> gsMaterialWastetreatmentCl) {
		this.gsMaterialWastetreatmentCl = gsMaterialWastetreatmentCl;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getPrjNo() {
		return prjNo;
	}
	public void setPrjNo(String prjNo) {
		this.prjNo = prjNo;
	}
	public String getCmwId() {
		return cmwId;
	}
	public void setCmwId(String cmwId) {
		this.cmwId = cmwId;
	}
	
	public String getApplyPerson() {
		return applyPerson;
	}
	public void setApplyPerson(String applyPerson) {
		this.applyPerson = applyPerson;
	}
	public String getDealReason() {
		return dealReason;
	}
	public void setDealReason(String dealReason) {
		this.dealReason = dealReason;
	}
	public String getDealMode() {
		return dealMode;
	}
	public void setDealMode(String dealMode) {
		this.dealMode = dealMode;
	}
	
	public BigDecimal getCostMoney() {
		return costMoney;
	}
	public void setCostMoney(BigDecimal costMoney) {
		this.costMoney = costMoney;
	}
	public String getCmwDesc() {
		return cmwDesc;
	}
	public void setCmwDesc(String cmwDesc) {
		this.cmwDesc = cmwDesc;
	}
	
}
