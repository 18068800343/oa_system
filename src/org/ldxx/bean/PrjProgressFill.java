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
	private float prjMoney;
	private String prjLeader;
	private float provisionalSum;
	private String prjStartTime;
	private String prjEndTime;
	private float budgetMoneyAll;
	private String thisTime;
	private String allMoney;
	private String contractIncome;//合同收入比例
	private float allMoneyYuan;
	private float prjThisIncomeYuan;
	private int status;
	private String infos;
	private String fristDesign;//初步设计
	private String secondDesign;//施工图设计
	
	private List<PrjProgressFillFb> ppfb;
	/*private List<PrjProgressFillCj> ppcj;*/
	private List<PrjProgressFillInfo> ppfi;// 累计收入
	/*private List<PrjProgressFillInfo> ppfi2;// 本期收入
	private List<PrjProgressFillInfo> ppfi3;// 本期收款
	private List<PrjProgressFillInfo> ppfi4;// 累计收款
	private List<PrjProgressFillInfo> ppfi5;// 本期成本
	private List<PrjProgressFillInfo> ppfi6;// 累计成本*/	
	
	private List<Accessory> accessory;
	
	
	public String getContractIncome() {
		return contractIncome;
	}
	public void setContractIncome(String contractIncome) {
		this.contractIncome = contractIncome;
	}
	public String getFristDesign() {
		return fristDesign;
	}
	public void setFristDesign(String fristDesign) {
		this.fristDesign = fristDesign;
	}
	public String getSecondDesign() {
		return secondDesign;
	}
	public void setSecondDesign(String secondDesign) {
		this.secondDesign = secondDesign;
	}
	public float getPrjMoney() {
		return prjMoney;
	}
	public void setPrjMoney(float prjMoney) {
		this.prjMoney = prjMoney;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getInfos() {
		return infos;
	}
	public void setInfos(String infos) {
		this.infos = infos;
	}
	public List<PrjProgressFillInfo> getPpfi() {
		return ppfi;
	}
	public void setPpfi(List<PrjProgressFillInfo> ppfi) {
		this.ppfi = ppfi;
	}
	public List<PrjProgressFillFb> getPpfb() {
		return ppfb;
	}
	public void setPpfb(List<PrjProgressFillFb> ppfb) {
		this.ppfb = ppfb;
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
	public float getAllMoneyYuan() {
		return allMoneyYuan;
	}
	public void setAllMoneyYuan(float allMoneyYuan) {
		this.allMoneyYuan = allMoneyYuan;
	}
	public float getPrjThisIncomeYuan() {
		return prjThisIncomeYuan;
	}
	public void setPrjThisIncomeYuan(float prjThisIncomeYuan) {
		this.prjThisIncomeYuan = prjThisIncomeYuan;
	}
	
}