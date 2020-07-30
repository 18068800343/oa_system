package org.ldxx.bean;

import java.math.BigDecimal;
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
	private BigDecimal contractMoney;
	private BigDecimal prjMoney;
	private String prjLeader;
	private BigDecimal provisionalSum;
	private String prjStartTime;
	private String prjEndTime;
	private BigDecimal budgetMoneyAll;
	private String thisTime;
	private String prjMode;
	private String allMoney;
	private String contractIncome;//合同收入比例
	private BigDecimal allMoneyYuan;
	private BigDecimal prjThisIncomeYuan;
	private int status;
	private String infos;
	private String ygDesign;//预工可设计
	private String fristDesign;//初步设计
	private String secondDesign;//施工图设计
	private BigDecimal rate;//税率
	private BigDecimal rateMoney;//税金
	private String backState;//收回状态 收回：1
	
	private BigDecimal totalCost;//财务累计成本
	
	private String thismonthCompletecontent;//本月完成主要内容
	private String nextmoneyPlan;//下月计划
	
	private List<PrjProgressFillFb> ppfb;
	/*private List<PrjProgressFillCj> ppcj;*/
	private List<PrjProgressFillInfo> ppfi;// 累计收入
	/*private List<PrjProgressFillInfo> ppfi2;// 本期收入
	private List<PrjProgressFillInfo> ppfi3;// 本期收款
	private List<PrjProgressFillInfo> ppfi4;// 累计收款
	private List<PrjProgressFillInfo> ppfi5;// 本期成本
	private List<PrjProgressFillInfo> ppfi6;// 累计成本*/	
	
	private List<Accessory> accessory;
	private CjContract cj;
	private BigDecimal benqishouru;
	
	private BigDecimal endMoney;//结算金额
	private BigDecimal jzqnMoney;//截止上年度的收入金额
	private BigDecimal jnMoney;//本年度收入金额
	
	private BigDecimal prjEstimateMoney;//本年度收入金额
	
	private String modeStatus;
	
	public BigDecimal getPrjEstimateMoney() {
		return prjEstimateMoney;
	}
	public void setPrjEstimateMoney(BigDecimal prjEstimateMoney) {
		this.prjEstimateMoney = prjEstimateMoney;
	}
	public String getModeStatus() {
		return modeStatus;
	}
	public void setModeStatus(String modeStatus) {
		this.modeStatus = modeStatus;
	}
	public String getThismonthCompletecontent() {
		return thismonthCompletecontent;
	}
	public void setThismonthCompletecontent(String thismonthCompletecontent) {
		this.thismonthCompletecontent = thismonthCompletecontent;
	}
	public String getNextmoneyPlan() {
		return nextmoneyPlan;
	}
	public void setNextmoneyPlan(String nextmoneyPlan) {
		this.nextmoneyPlan = nextmoneyPlan;
	}
	public BigDecimal getEndMoney() {
		return endMoney;
	}
	public void setEndMoney(BigDecimal endMoney) {
		this.endMoney = endMoney;
	}
	public BigDecimal getJzqnMoney() {
		return jzqnMoney;
	}
	public void setJzqnMoney(BigDecimal jzqnMoney) {
		this.jzqnMoney = jzqnMoney;
	}
	public BigDecimal getJnMoney() {
		return jnMoney;
	}
	public void setJnMoney(BigDecimal jnMoney) {
		this.jnMoney = jnMoney;
	}
	public String getBackState() {
		return backState;
	}
	public void setBackState(String backState) {
		this.backState = backState;
	}
	public BigDecimal getBenqishouru() {
		return benqishouru;
	}
	public void setBenqishouru(BigDecimal benqishouru) {
		this.benqishouru = benqishouru;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public BigDecimal getRateMoney() {
		return rateMoney;
	}
	public void setRateMoney(BigDecimal rateMoney) {
		this.rateMoney = rateMoney;
	}
	public CjContract getCj() {
		return cj;
	}
	public void setCj(CjContract cj) {
		this.cj = cj;
	}
	public BigDecimal getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}
	public String getYgDesign() {
		return ygDesign;
	}
	public void setYgDesign(String ygDesign) {
		this.ygDesign = ygDesign;
	}
	public String getPrjMode() {
		return prjMode;
	}
	public void setPrjMode(String prjMode) {
		this.prjMode = prjMode;
	}
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
	public BigDecimal getPrjMoney() {
		return prjMoney;
	}
	public void setPrjMoney(BigDecimal prjMoney) {
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
	public BigDecimal getContractMoney() {
		return contractMoney;
	}
	public void setContractMoney(BigDecimal contractMoney) {
		this.contractMoney = contractMoney;
	}
	public String getPrjLeader() {
		return prjLeader;
	}
	public void setPrjLeader(String prjLeader) {
		this.prjLeader = prjLeader;
	}
	public BigDecimal getProvisionalSum() {
		return provisionalSum;
	}
	public void setProvisionalSum(BigDecimal provisionalSum) {
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
	public BigDecimal getBudgetMoneyAll() {
		return budgetMoneyAll;
	}
	public void setBudgetMoneyAll(BigDecimal budgetMoneyAll) {
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
	public BigDecimal getAllMoneyYuan() {
		return allMoneyYuan;
	}
	public void setAllMoneyYuan(BigDecimal allMoneyYuan) {
		this.allMoneyYuan = allMoneyYuan;
	}
	public BigDecimal getPrjThisIncomeYuan() {
		return prjThisIncomeYuan;
	}
	public void setPrjThisIncomeYuan(BigDecimal prjThisIncomeYuan) {
		this.prjThisIncomeYuan = prjThisIncomeYuan;
	}
	
}