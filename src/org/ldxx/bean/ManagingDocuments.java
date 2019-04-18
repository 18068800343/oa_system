package org.ldxx.bean;

import java.util.List;

//经营文档资料
public class ManagingDocuments {
	private String mdId;
	private String prjName;//项目名称
	private String prjNo;//任务单号
	private String prjArea;//项目地区
	private String prjType;//项目类型
	private String fillInOne;//填报人
	private String keyWord;//关键词
	private String biddingAgent;//招标代理
	private String prjBidTime;//项目投标时间
	private String isBidding;//是否中标
	private String numberParticipatingUnits;//参与开标单位数量
	private String offer;//本公司报价
	private String biddingPrjManager;//中标项目经理
	private String prjGeneral;//项目总工
	private String prjStartTime;//项目工起期
	private String prjEndTime;//项目工止期
	private String biddingPrice;//中标价
	private String biddingUnit;//中标单位
	private Double bidPriceLimit;//投标限价
	private Double prjBudgetPrice;//项目预算价
	private String bidEvaluationMethod;//评标办法
	private List<ManagingDocumentsTenderer> managingDocumentsTenderer;//招标人
	
	private int fileLength;
	private List<Accessory> accessory1;//招标文件
    private List<Accessory> accessory2;//招标图纸
    private List<Accessory> accessory3;//投标文件（技术+商务）
    private List<Accessory> accessory4;//中标通知书（原件由经营部存档）
    private List<Accessory> accessory5;//开标记录
    private List<Accessory> accessory6;
	
	
	public int getFileLength() {
		return fileLength;
	}
	public void setFileLength(int fileLength) {
		this.fileLength = fileLength;
	}
	public List<Accessory> getAccessory1() {
		return accessory1;
	}
	public void setAccessory1(List<Accessory> accessory1) {
		this.accessory1 = accessory1;
	}
	public List<Accessory> getAccessory2() {
		return accessory2;
	}
	public void setAccessory2(List<Accessory> accessory2) {
		this.accessory2 = accessory2;
	}
	public List<Accessory> getAccessory3() {
		return accessory3;
	}
	public void setAccessory3(List<Accessory> accessory3) {
		this.accessory3 = accessory3;
	}
	public List<Accessory> getAccessory4() {
		return accessory4;
	}
	public void setAccessory4(List<Accessory> accessory4) {
		this.accessory4 = accessory4;
	}
	public List<Accessory> getAccessory5() {
		return accessory5;
	}
	public void setAccessory5(List<Accessory> accessory5) {
		this.accessory5 = accessory5;
	}
	public List<Accessory> getAccessory6() {
		return accessory6;
	}
	public void setAccessory6(List<Accessory> accessory6) {
		this.accessory6 = accessory6;
	}
	public String getMdId() {
		return mdId;
	}
	public void setMdId(String mdId) {
		this.mdId = mdId;
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
	public String getFillInOne() {
		return fillInOne;
	}
	public void setFillInOne(String fillInOne) {
		this.fillInOne = fillInOne;
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
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getBiddingAgent() {
		return biddingAgent;
	}
	public void setBiddingAgent(String biddingAgent) {
		this.biddingAgent = biddingAgent;
	}
	public String getPrjBidTime() {
		return prjBidTime;
	}
	public void setPrjBidTime(String prjBidTime) {
		this.prjBidTime = prjBidTime;
	}
	public String getNumberParticipatingUnits() {
		return numberParticipatingUnits;
	}
	public void setNumberParticipatingUnits(String numberParticipatingUnits) {
		this.numberParticipatingUnits = numberParticipatingUnits;
	}
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	public String getIsBidding() {
		return isBidding;
	}
	public void setIsBidding(String isBidding) {
		this.isBidding = isBidding;
	}
	public String getBiddingPrjManager() {
		return biddingPrjManager;
	}
	public void setBiddingPrjManager(String biddingPrjManager) {
		this.biddingPrjManager = biddingPrjManager;
	}
	public String getPrjGeneral() {
		return prjGeneral;
	}
	public void setPrjGeneral(String prjGeneral) {
		this.prjGeneral = prjGeneral;
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
	public String getBiddingPrice() {
		return biddingPrice;
	}
	public void setBiddingPrice(String biddingPrice) {
		this.biddingPrice = biddingPrice;
	}
	public String getBiddingUnit() {
		return biddingUnit;
	}
	public void setBiddingUnit(String biddingUnit) {
		this.biddingUnit = biddingUnit;
	}
	public Double getBidPriceLimit() {
		return bidPriceLimit;
	}
	public void setBidPriceLimit(Double bidPriceLimit) {
		this.bidPriceLimit = bidPriceLimit;
	}
	public Double getPrjBudgetPrice() {
		return prjBudgetPrice;
	}
	public void setPrjBudgetPrice(Double prjBudgetPrice) {
		this.prjBudgetPrice = prjBudgetPrice;
	}
	public String getBidEvaluationMethod() {
		return bidEvaluationMethod;
	}
	public void setBidEvaluationMethod(String bidEvaluationMethod) {
		this.bidEvaluationMethod = bidEvaluationMethod;
	}
	public List<ManagingDocumentsTenderer> getManagingDocumentsTenderer() {
		return managingDocumentsTenderer;
	}
	public void setManagingDocumentsTenderer(List<ManagingDocumentsTenderer> managingDocumentsTenderer) {
		this.managingDocumentsTenderer = managingDocumentsTenderer;
	}
	
	
	
	
}
