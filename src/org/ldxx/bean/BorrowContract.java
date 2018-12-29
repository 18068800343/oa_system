package org.ldxx.bean;

import java.util.List;

//借款合同金额
public class BorrowContract {
	private String bId;// 编号
	private String bNo;// 借款合同号
	private String unitJia;// 甲方
	private String unitYi;// 乙方
	private String ccName;// 乙方单位名称
	private String cjNo;// 主合同号
	private String fbNo;// 分包合同号
	private Float thisBorrowMoney;// 本次借款金额
	private String interestPaymentMethod;// 利息支付方式
	private String rate;//利率
	private String borrowTime;// 借款开始时间
	private String borrowEndTime;// 借款结束时间
	private Float accumulatedBorrowingMoney;// 乙方累计借款额
	private String borrowingPurposes;// 借款用途
	private String makeTime; // 当前时间
	private String history;// 历史状态

	private List<Accessory> accessory;
	private List<Accessory> accessory2;

	
	public String getBorrowEndTime() {
		return borrowEndTime;
	}

	public void setBorrowEndTime(String borrowEndTime) {
		this.borrowEndTime = borrowEndTime;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public List<Accessory> getAccessory2() {
		return accessory2;
	}

	public void setAccessory2(List<Accessory> accessory2) {
		this.accessory2 = accessory2;
	}

	public String getCcName() {
		return ccName;
	}

	public void setCcName(String ccName) {
		this.ccName = ccName;
	}

	public String getbId() {
		return bId;
	}

	public String getMakeTime() {
		return makeTime;
	}

	public void setMakeTime(String makeTime) {
		this.makeTime = makeTime;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public String getbNo() {
		return bNo;
	}

	public void setbNo(String bNo) {
		this.bNo = bNo;
	}

	public String getUnitJia() {
		return unitJia;
	}

	public void setUnitJia(String unitJia) {
		this.unitJia = unitJia;
	}

	public String getUnitYi() {
		return unitYi;
	}

	public void setUnitYi(String unitYi) {
		this.unitYi = unitYi;
	}

	public String getCjNo() {
		return cjNo;
	}

	public void setCjNo(String cjNo) {
		this.cjNo = cjNo;
	}

	public String getFbNo() {
		return fbNo;
	}

	public void setFbNo(String fbNo) {
		this.fbNo = fbNo;
	}

	public Float getThisBorrowMoney() {
		return thisBorrowMoney;
	}

	public void setThisBorrowMoney(Float thisBorrowMoney) {
		this.thisBorrowMoney = thisBorrowMoney;
	}

	public String getInterestPaymentMethod() {
		return interestPaymentMethod;
	}

	public void setInterestPaymentMethod(String interestPaymentMethod) {
		this.interestPaymentMethod = interestPaymentMethod;
	}

	public String getBorrowTime() {
		return borrowTime;
	}

	public void setBorrowTime(String borrowTime) {
		this.borrowTime = borrowTime;
	}

	public Float getAccumulatedBorrowingMoney() {
		return accumulatedBorrowingMoney;
	}

	public void setAccumulatedBorrowingMoney(Float accumulatedBorrowingMoney) {
		this.accumulatedBorrowingMoney = accumulatedBorrowingMoney;
	}

	public String getBorrowingPurposes() {
		return borrowingPurposes;
	}

	public void setBorrowingPurposes(String borrowingPurposes) {
		this.borrowingPurposes = borrowingPurposes;
	}

	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}

}
