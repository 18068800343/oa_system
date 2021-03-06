package org.ldxx.bean;

import java.math.BigDecimal;

/** 
* @ClassName: Task2 
* @Description: 检测2部
* @author zhaohui
* @date 2018年11月21日 下午4:16:08 
*  
*/
public class Task2 {

	private String tId;
	private String tNo;
	private String tName;
	private String tType;
	private String tDate;//填报日期
	private String tDesc;//备注
	private String dName;//部门
	private String omId;//部门id
	private BigDecimal dMoney;//金额
	private BigDecimal dIncome;//部门总收入
	
	private BigDecimal dMoney2;//
	
	
	public BigDecimal getdMoney2() {
		return dMoney2;
	}
	public void setdMoney2(BigDecimal dMoney2) {
		this.dMoney2 = dMoney2;
	}
	public String getOmId() {
		return omId;
	}
	public void setOmId(String omId) {
		this.omId = omId;
	}
	public BigDecimal getdIncome() {
		return dIncome;
	}
	public void setdIncome(BigDecimal dIncome) {
		this.dIncome = dIncome;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public BigDecimal getdMoney() {
		return dMoney;
	}
	public void setdMoney(BigDecimal dMoney) {
		this.dMoney = dMoney;
	}
	public String gettDesc() {
		return tDesc;
	}
	public void settDesc(String tDesc) {
		this.tDesc = tDesc;
	}
	public String gettDate() {
		return tDate;
	}
	public void settDate(String tDate) {
		this.tDate = tDate;
	}
	public String gettId() {
		return tId;
	}
	public void settId(String tId) {
		this.tId = tId;
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
	public String gettType() {
		return tType;
	}
	public void settType(String tType) {
		this.tType = tType;
	}
	
	
}
