package org.ldxx.bean;

/** 
* @ClassName: CompanyManage 
* @Description: 公司经营情况
* @author zhaohui
* @date 2018年12月10日 下午1:37:40 
*  
*/
public class CompanyManage {

	private String departmentName;
	private double totalAccomplish;//累计完成收入
	private double targetRevenues;//目标收入
	private String percentage;//完成百分比
	private double moneyReceipt;//已收款
	private double accruedAssets;//未收款
	private double cost;//成本
	private Double newContractAmount;//新签合同额
	private double contractZdMoney;//合同暂定金
	private double contractTargetMoney;//合同目标额
	
	
	public double getMoneyReceipt() {
		return moneyReceipt;
	}
	public void setMoneyReceipt(double moneyReceipt) {
		this.moneyReceipt = moneyReceipt;
	}
	public double getAccruedAssets() {
		return accruedAssets;
	}
	public void setAccruedAssets(double accruedAssets) {
		this.accruedAssets = accruedAssets;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public double getTotalAccomplish() {
		return totalAccomplish;
	}
	public void setTotalAccomplish(double totalAccomplish) {
		this.totalAccomplish = totalAccomplish;
	}
	public double getTargetRevenues() {
		return targetRevenues;
	}
	public void setTargetRevenues(double targetRevenues) {
		this.targetRevenues = targetRevenues;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public Double getNewContractAmount() {
		return newContractAmount;
	}
	public void setNewContractAmount(Double newContractAmount) {
		this.newContractAmount = newContractAmount;
	}
	public double getContractZdMoney() {
		return contractZdMoney;
	}
	public void setContractZdMoney(double contractZdMoney) {
		this.contractZdMoney = contractZdMoney;
	}
	public double getContractTargetMoney() {
		return contractTargetMoney;
	}
	public void setContractTargetMoney(double contractTargetMoney) {
		this.contractTargetMoney = contractTargetMoney;
	}
	
}
