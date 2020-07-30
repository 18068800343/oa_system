package org.ldxx.bean;

import java.math.BigDecimal;

/** 
* @ClassName: CompanyManage 
* @Description: 公司经营情况
* @author zhaohui
* @date 2018年12月10日 下午1:37:40 
*  
*/
public class CompanyManage {

	private String departmentName;
	private BigDecimal totalAccomplish;//累计完成收入
	private BigDecimal targetRevenues;//目标收入
	private String percentage;//完成百分比
	private BigDecimal moneyReceipt;//已收款
	private BigDecimal accruedAssets;//未收款
	private BigDecimal cost;//成本
	private BigDecimal newContractAmount;//新签合同额
	private BigDecimal contractZdMoney;//合同暂定金
	private BigDecimal contractTargetMoney;//合同目标额
	
	
	public BigDecimal getMoneyReceipt() {
		return moneyReceipt;
	}
	public void setMoneyReceipt(BigDecimal moneyReceipt) {
		this.moneyReceipt = moneyReceipt;
	}
	public BigDecimal getAccruedAssets() {
		return accruedAssets;
	}
	public void setAccruedAssets(BigDecimal accruedAssets) {
		this.accruedAssets = accruedAssets;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public BigDecimal getTotalAccomplish() {
		return totalAccomplish;
	}
	public void setTotalAccomplish(BigDecimal totalAccomplish) {
		this.totalAccomplish = totalAccomplish;
	}
	public BigDecimal getTargetRevenues() {
		return targetRevenues;
	}
	public void setTargetRevenues(BigDecimal targetRevenues) {
		this.targetRevenues = targetRevenues;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public BigDecimal getNewContractAmount() {
		return newContractAmount;
	}
	public void setNewContractAmount(BigDecimal newContractAmount) {
		this.newContractAmount = newContractAmount;
	}
	public BigDecimal getContractZdMoney() {
		return contractZdMoney;
	}
	public void setContractZdMoney(BigDecimal contractZdMoney) {
		this.contractZdMoney = contractZdMoney;
	}
	public BigDecimal getContractTargetMoney() {
		return contractTargetMoney;
	}
	public void setContractTargetMoney(BigDecimal contractTargetMoney) {
		this.contractTargetMoney = contractTargetMoney;
	}
	
}
