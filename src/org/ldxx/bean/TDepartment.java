package org.ldxx.bean;

import java.math.BigDecimal;

/** 
* @ClassName: TDepartment 
* @Description: 检测2部项目部门表
* @author zhaohui
* @date 2018年11月21日 下午4:17:26 
*  
*/
public class TDepartment {

	private String tNo;
	private String dName;
	private BigDecimal dMoney;
	private BigDecimal dIncome;
	private String date;
	private String tName;
	private String id;
	
	private String omId;
	private BigDecimal dIncome2;
	
	
	
	public String getOmId() {
		return omId;
	}
	public void setOmId(String omId) {
		this.omId = omId;
	}
	public BigDecimal getdIncome2() {
		return dIncome2;
	}
	public void setdIncome2(BigDecimal dIncome2) {
		this.dIncome2 = dIncome2;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String gettNo() {
		return tNo;
	}
	public void settNo(String tNo) {
		this.tNo = tNo;
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
	public BigDecimal getdIncome() {
		return dIncome;
	}
	public void setdIncome(BigDecimal dIncome) {
		this.dIncome = dIncome;
	}
	
}
