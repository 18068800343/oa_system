package org.ldxx.bean;

import java.util.List;

//开标记录
public class OpeningRecord {
	private String orId;
	private String prjName;//项目名称
	private String prjNo;//投标审批单号
	private String prjArea;//项目地区
	private String prjType;//项目类型
	private Float ownerControlledPrice;//业主控制价
	private Float bidEvaluationBenchmarkPrice;//评标基准价
	private String bidOpeningTime;//开标时间
	private String percentageFluctuation;//基准价下浮比例
	private String winningUnit;//中标单位
	private String bidProjectManager;//中标项目经理
	private Float bidPrice;//中标价格
	private String floatingMediumPrice;//中标价下浮率
	private String recordDate;//记录日期
	private String conclusion;//总结
	private String unitReasonBid;//废标单位原因
	
	private List<OpeningInformation> openingInformation;
	
	
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
