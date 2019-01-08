package org.ldxx.bean;
//开标记录得分信息表
public class OpeningInformation {
	private String oiId;
	private String bdNo;
	private String entityName;//单位名称
	private String businessOffer;//报价
	private String businessMark;//报价得分(A)
	private String technicalMark;//第一信封得分(B)
	private String totalScore;//总得分  (A+B)
	private String ranking;//名次
	
	
	public String getBdNo() {
		return bdNo;
	}
	public void setBdNo(String bdNo) {
		this.bdNo = bdNo;
	}
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
	public String getRanking() {
		return ranking;
	}
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
}
