package org.ldxx.bean;

import java.util.List;

//开标记录
public class OpeningRecord {
	private String orId;
	private String prjName;//项目名称
	private String prjNo;//投标审批单号
	private String prjArea;//项目地区
	private String prjType;//项目类型
	private Float ownerControlledPrice;//业主控制价(项目限价)
	private Float bidEvaluationBenchmarkPrice;//评标基准价
	private String bidOpeningTime;//开标时间
	private String percentageFluctuation;//基准价折扣率
	private String winningUnit;//中标单位
	private String bidProjectManager;//中标项目经理
	private Float bidPrice;//中标价格
	private String floatingMediumPrice;//中标价折扣率
	private String recordDate;//记录日期
	private String conclusion;//总结
	private String unitReasonBid;//废标单位原因
	private String tenderer;//招标人
	private String bidEvaluationMethod;//评标办法
	private String thisInUnit;//本次参投单位
	private Float companyOffer;//公司报价
	private String companyDiscountRate;//公司报价折扣率
	private Float calculateCost;//测算成本
	private Float actualCost;//实际成本
	
	
	private List<OpeningInformation> openingInformation;
	
	private List<Accessory> accessory;
	
	
	
	public Float getCompanyOffer() {
		return companyOffer;
	}
	public void setCompanyOffer(Float companyOffer) {
		this.companyOffer = companyOffer;
	}
	public List<Accessory> getAccessory() {
		return accessory;
	}
	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}
	public String getTenderer() {
		return tenderer;
	}
	public void setTenderer(String tenderer) {
		this.tenderer = tenderer;
	}
	public String getBidEvaluationMethod() {
		return bidEvaluationMethod;
	}
	public void setBidEvaluationMethod(String bidEvaluationMethod) {
		this.bidEvaluationMethod = bidEvaluationMethod;
	}
	public String getThisInUnit() {
		return thisInUnit;
	}
	public void setThisInUnit(String thisInUnit) {
		this.thisInUnit = thisInUnit;
	}
	public String getCompanyDiscountRate() {
		return companyDiscountRate;
	}
	public void setCompanyDiscountRate(String companyDiscountRate) {
		this.companyDiscountRate = companyDiscountRate;
	}
	public Float getCalculateCost() {
		return calculateCost;
	}
	public void setCalculateCost(Float calculateCost) {
		this.calculateCost = calculateCost;
	}
	public Float getActualCost() {
		return actualCost;
	}
	public void setActualCost(Float actualCost) {
		this.actualCost = actualCost;
	}
	public List<OpeningInformation> getOpeningInformation() {
		return openingInformation;
	}
	public void setOpeningInformation(List<OpeningInformation> openingInformation) {
		this.openingInformation = openingInformation;
	}
	public Float getOwnerControlledPrice() {
		return ownerControlledPrice;
	}
	public void setOwnerControlledPrice(Float ownerControlledPrice) {
		this.ownerControlledPrice = ownerControlledPrice;
	}
	public Float getBidEvaluationBenchmarkPrice() {
		return bidEvaluationBenchmarkPrice;
	}
	public void setBidEvaluationBenchmarkPrice(Float bidEvaluationBenchmarkPrice) {
		this.bidEvaluationBenchmarkPrice = bidEvaluationBenchmarkPrice;
	}
	public Float getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(Float bidPrice) {
		this.bidPrice = bidPrice;
	}
	public String getOrId() {
		return orId;
	}
	public void setOrId(String orId) {
		this.orId = orId;
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
	public String getPrjArea() {
		return prjArea;
	}
	public void setPrjArea(String prjArea) {
		this.prjArea = prjArea;
	}
	public String getPrjType() {
		return prjType;
	}
	public void setPrjType(String prjType) {
		this.prjType = prjType;
	}
	public String getBidOpeningTime() {
		return bidOpeningTime;
	}
	public void setBidOpeningTime(String bidOpeningTime) {
		this.bidOpeningTime = bidOpeningTime;
	}
	public String getPercentageFluctuation() {
		return percentageFluctuation;
	}
	public void setPercentageFluctuation(String percentageFluctuation) {
		this.percentageFluctuation = percentageFluctuation;
	}
	public String getWinningUnit() {
		return winningUnit;
	}
	public void setWinningUnit(String winningUnit) {
		this.winningUnit = winningUnit;
	}
	public String getBidProjectManager() {
		return bidProjectManager;
	}
	public void setBidProjectManager(String bidProjectManager) {
		this.bidProjectManager = bidProjectManager;
	}
	public String getFloatingMediumPrice() {
		return floatingMediumPrice;
	}
	public void setFloatingMediumPrice(String floatingMediumPrice) {
		this.floatingMediumPrice = floatingMediumPrice;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getConclusion() {
		return conclusion;
	}
	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	public String getUnitReasonBid() {
		return unitReasonBid;
	}
	public void setUnitReasonBid(String unitReasonBid) {
		this.unitReasonBid = unitReasonBid;
	}
}
