package org.ldxx.bean;
//开标记录得分信息表
public class OpeningInformation {
	private String oiId;
	private String entityName;//单位名称
	private String businessOffer;//商务标报价
	private String businessMark;//商务标得分
	private String technicalMark;//技术标得分
	private String totalScore;//总分
	private String priceRatio;//报价比例
	private String ranking;//名次
	public String getOiId() {
		return oiId;
	}
	public void setOiId(String oiId) {
		this.oiId = oiId;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getBusinessOffer() {
		return businessOffer;
	}
	public void setBusinessOffer(String businessOffer) {
		this.businessOffer = businessOffer;
	}
	public String getBusinessMark() {
		return businessMark;
	}
	public void setBusinessMark(String businessMark) {
		this.businessMark = businessMark;
	}
	public String getTechnicalMark() {
		return technicalMark;
	}
	public void setTechnicalMark(String technicalMark) {
		this.technicalMark = technicalMark;
	}
	public String getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}
	public String getPriceRatio() {
		return priceRatio;
	}
	public void setPriceRatio(String priceRatio) {
		this.priceRatio = priceRatio;
	}
	public String getRanking() {
		return ranking;
	}
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
}
