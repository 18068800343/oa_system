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
	private float totalAccomplish;//累计完成收入
	private float targetRevenues;//目标收入
	private String percentage;//完成百分比
	private double moneyReceipt;//已收款
	private double accruedAssets;//未收款
	private double cost;//成本
	private float newContractAmount;//新签合同额
	private float contractZdMoney;//合同暂定金
	private float contractTargetMoney;//合同目标额
	
	
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
	public float getTotalAccomplish() {
		return totalAccomplish;
	}
	public void setTotalAccomplish(float totalAccomplish) {
		this.totalAccomplish = totalAccomplish;
	}
	public float getTargetRevenues() {
		return targetRevenues;
	}
	public void setTargetRevenues(float targetRevenues) {
		this.targetRevenues = targetRevenues;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public float getNewContractAmount() {
		return newContractAmount;
	}
	public void setNewContractAmount(float newContractAmount) {
		this.newContractAmount = newContractAmount;
	}
	public float getContractZdMoney() {
		return contractZdMoney;
	}
	public void setContractZdMoney(float contractZdMoney) {
		this.contractZdMoney = contractZdMoney;
	}
	public float getContractTargetMoney() {
		return contractTargetMoney;
	}
	public void setContractTargetMoney(float contractTargetMoney) {
		this.contractTargetMoney = contractTargetMoney;
	}
	
}
