package org.ldxx.bean;

import java.util.List;

/** 
* @ClassName: PrjProgressFill
* @Description: 进度管理
* @author zhaohui
* @date 2018年10月23日 下午1:44:11 
*  
*/
public class PrjProgressFill {
    
	private String ppfId;
	private String prjName;
	private String taskNo;
	private String prjType;
	private float contractMoney;
	private String prjLeader;
	private float provisionalSum;
	private String prjStartTime;
	private String prjEndTime;
	private float budgetMoneyAll;
	private String thisTime;
	private String allMoney;
	private float allCost;
	private float prjThisIncome;
	
	private List<PrjProgressFillInfo> ppfi;// 累计收入
	private List<PrjProgressFillInfo> ppfi2;// 本期收入
	private List<PrjProgressFillInfo> ppfi3;// 本期收款
	private List<PrjProgressFillInfo> ppfi4;// 累计收款
	private List<PrjProgressFillInfo> ppfi5;// 本期成本
	private List<PrjProgressFillInfo> ppfi6;// 累计成本
	private List<Accessory> accessory;
	
	
	public List<PrjProgressFillInfo> getPpfi() {
		return ppfi;
	}
	public void setPpfi(List<PrjProgressFillInfo> ppfi) {
		this.ppfi = ppfi;
	}
	public List<PrjProgressFillInfo> getPpfi2() {
		return ppfi2;
	}
	public void setPpfi2(List<PrjProgressFillInfo> ppfi2) {
		this.ppfi2 = ppfi2;
	}
	public List<PrjProgressFillInfo> getPpfi3() {
		return ppfi3;
	}
	public void setPpfi3(List<PrjProgressFillInfo> ppfi3) {
		this.ppfi3 = ppfi3;
	}
	public List<PrjProgressFillInfo> getPpfi4() {
		return ppfi4;
	}
	public void setPpfi4(List<PrjProgressFillInfo> ppfi4) {
		this.ppfi4 = ppfi4;
	}
	public List<PrjProgressFillInfo> getPpfi5() {
		return ppfi5;
	}
	public void setPpfi5(List<PrjProgressFillInfo> ppfi5) {
		this.ppfi5 = ppfi5;
	}
	public List<PrjProgressFillInfo> getPpfi6() {
		return ppfi6;
	}
	public void setPpfi6(List<PrjProgressFillInfo> ppfi6) {
		this.ppfi6 = ppfi6;
	}
	public List<Accessory> getAccessory() {
		return accessory;
	}
	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}
	public String getPpfId() {
		return ppfId;
	}
	public void setPpfId(String ppfId) {
		this.ppfId = ppfId;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getTaskNo() {
		return taskNo;
	}
	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}
	public String getPrjType() {
		return prjType;
	}
	public void setPrjType(String prjType) {
		this.prjType = prjType;
	}
	public float getContractMoney() {
		return contractMoney;
	}
	public void setContractMoney(float contractMoney) {
		this.contractMoney = contractMoney;
	}
	public String getPrjLeader() {
		return prjLeader;
	}
	public void setPrjLeader(String prjLeader) {
		this.prjLeader = prjLeader;
	}
	public float getProvisionalSum() {
		return provisionalSum;
	}
	public void setProvisionalSum(float provisionalSum) {
		this.provisionalSum = provisionalSum;
	}
	public String getPrjStartTime() {
		return prjStartTime;
	}
	public void setPrjStartTime(String prjStartTime) {
		this.prjStartTime = prjStartTime;
	}
	public String getPrjEndTime() {
		return prjEndTime;
	}
	public void setPrjEndTime(String prjEndTime) {
		this.prjEndTime = prjEndTime;
	}
	public float getBudgetMoneyAll() {
		return budgetMoneyAll;
	}
	public void setBudgetMoneyAll(float budgetMoneyAll) {
		this.budgetMoneyAll = budgetMoneyAll;
	}
	public String getThisTime() {
		return thisTime;
	}
	public void setThisTime(String thisTime) {
		this.thisTime = thisTime;
	}
	public String getAllMoney() {
		return allMoney;
	}
	public void setAllMoney(String allMoney) {
		this.allMoney = allMoney;
	}
	public float getAllCost() {
		return allCost;
	}
	public void setAllCost(float allCost) {
		this.allCost = allCost;
	}
	public float getPrjThisIncome() {
		return prjThisIncome;
	}
	public void setPrjThisIncome(float prjThisIncome) {
		this.prjThisIncome = prjThisIncome;
	}
	
}