package org.ldxx.bean;

import java.security.KeyStore.PrivateKeyEntry;

public class AllQuery {

	//任务单编号
	private String prjNo;
	//承接合同编号
	private String contractNo;
	//承接合同名称
	private String contractName;
	//项目业主单位
	private String ccName;
	//合同工期
	private String contractLongTime;
	
	//主办部门
	private String omName;
	//项目负责人
	private String mainPrjLeader;
	//合同金额
	private String cjmoney;
	//暂定金
	private String temporaryMoney;
	//部门所占金额
	private String departContractMoney;
	
	//累计收入
	private String iall;
	//当月收入
	private String ibq;
	//项目预算
	private String allCost;
	//累计成本
    private String leiJiChengBen;
    //已开票金额
	private String allKpMoney;
	
	//累计收款
	private String resultMoney;
	//合同状态
	private String contractStatus;
	//合同决算金额
	private String contractJueSuanMoney;
	//分包合同编号
	private String fbNo;
	//分包合同名称
	private String fbContract;
	
	
	//分包合同乙方单位
	private String fbYiName;
	//分包合同金额
	private String nowFbAllMoney;
	//分包决算金额
	private String fbJueSuanMoney;
	//分包累计付款
	private String leiJiPayMoney;
	//分包未付金额
	private String weiPayMoney;
	
	public String getFbYiName() {
		return fbYiName;
	}
	public void setFbYiName(String fbYiName) {
		this.fbYiName = fbYiName;
	}
	public String getPrjNo() {
		return prjNo;
	}
	public void setPrjNo(String prjNo) {
		this.prjNo = prjNo;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getCcName() {
		return ccName;
	}
	public void setCcName(String ccName) {
		this.ccName = ccName;
	}
	public String getContractLongTime() {
		return contractLongTime;
	}
	public void setContractLongTime(String contractLongTime) {
		this.contractLongTime = contractLongTime;
	}
	public String getOmName() {
		return omName;
	}
	public void setOmName(String omName) {
		this.omName = omName;
	}
	public String getMainPrjLeader() {
		return mainPrjLeader;
	}
	public void setMainPrjLeader(String mainPrjLeader) {
		this.mainPrjLeader = mainPrjLeader;
	}
	public String getCjmoney() {
		return cjmoney;
	}
	public void setCjmoney(String cjmoney) {
		this.cjmoney = cjmoney;
	}
	public String getTemporaryMoney() {
		return temporaryMoney;
	}
	public void setTemporaryMoney(String temporaryMoney) {
		this.temporaryMoney = temporaryMoney;
	}
	public String getDepartContractMoney() {
		return departContractMoney;
	}
	public void setDepartContractMoney(String departContractMoney) {
		this.departContractMoney = departContractMoney;
	}
	public String getIall() {
		return iall;
	}
	public void setIall(String iall) {
		this.iall = iall;
	}
	public String getIbq() {
		return ibq;
	}
	public void setIbq(String ibq) {
		this.ibq = ibq;
	}
	public String getAllCost() {
		return allCost;
	}
	public void setAllCost(String allCost) {
		this.allCost = allCost;
	}
	public String getLeiJiChengBen() {
		return leiJiChengBen;
	}
	public void setLeiJiChengBen(String leiJiChengBen) {
		this.leiJiChengBen = leiJiChengBen;
	}
	public String getAllKpMoney() {
		return allKpMoney;
	}
	public void setAllKpMoney(String allKpMoney) {
		this.allKpMoney = allKpMoney;
	}
	public String getResultMoney() {
		return resultMoney;
	}
	public void setResultMoney(String resultMoney) {
		this.resultMoney = resultMoney;
	}
	public String getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}
	public String getContractJueSuanMoney() {
		return contractJueSuanMoney;
	}
	public void setContractJueSuanMoney(String contractJueSuanMoney) {
		this.contractJueSuanMoney = contractJueSuanMoney;
	}
	public String getFbNo() {
		return fbNo;
	}
	public void setFbNo(String fbNo) {
		this.fbNo = fbNo;
	}
	public String getFbContract() {
		return fbContract;
	}
	public void setFbContract(String fbContract) {
		this.fbContract = fbContract;
	}
	public String getNowFbAllMoney() {
		return nowFbAllMoney;
	}
	public void setNowFbAllMoney(String nowFbAllMoney) {
		this.nowFbAllMoney = nowFbAllMoney;
	}
	public String getFbJueSuanMoney() {
		return fbJueSuanMoney;
	}
	public void setFbJueSuanMoney(String fbJueSuanMoney) {
		this.fbJueSuanMoney = fbJueSuanMoney;
	}
	public String getLeiJiPayMoney() {
		return leiJiPayMoney;
	}
	public void setLeiJiPayMoney(String leiJiPayMoney) {
		this.leiJiPayMoney = leiJiPayMoney;
	}
	public String getWeiPayMoney() {
		return weiPayMoney;
	}
	public void setWeiPayMoney(String weiPayMoney) {
		this.weiPayMoney = weiPayMoney;
	}
}
