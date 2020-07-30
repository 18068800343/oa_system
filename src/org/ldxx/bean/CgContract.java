package org.ldxx.bean;

import java.math.BigDecimal;
import java.util.List;

/**
 * 采购合同
 * 
 * @author hp
 *
 */
public class CgContract {
	private String cgId;//编号
	private String contractName;// 采购合同名称
	private String cgNo;//采购合同编号
	private String cgdNo;//采购单号
	private String workNo;// 任务单号
	private String prjName;//项目名称
	private String isProgram;// 是否代购
	private String programType;// 代购类型
	private String cgcType;// 采购合同类型
	private BigDecimal programMoney;// 代购金额
	private BigDecimal cgContractMoney;// 采购合同金额
	private String contractNameJia;// 合同甲方名称
	private String contractNameYi;// 乙方
	private String payMode;// 付款方式
	private String contractSignTime;// 采购合同签订时间
	private String contractSummary;// 采购合同概述
	private String workContent;// 主要概况及工作内容
	private String makeTime; //当前时间
	private String history;//历史状态
	private String fbNo;//关联的分保合同编号
	private String cgDepartment;//采购部门
	private BigDecimal freight;//运费
	private String borrowNo;//借款合同号
	
	private BigDecimal shuilv;//税率
	private BigDecimal shuijin;//税金
	private String cancelReason;//终止原因
	    
	private List<Accessory> accessory;
	private List<Accessory> accessory1;

	private String spName;// 乙方单位名称
	private List<CgCl> cgcl;//采购材料
	
	private String startername;
	
	private String starterName;//发起人
    private String status;//审批状态
    private String doDate;//审批状态
	
    
    
	public String getDoDate() {
		return doDate;
	}

	public void setDoDate(String doDate) {
		this.doDate = doDate;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getStartername() {
		return startername;
	}

	public void setStartername(String startername) {
		this.startername = startername;
	}

	public BigDecimal getShuilv() {
		return shuilv;
	}

	public void setShuilv(BigDecimal shuilv) {
		this.shuilv = shuilv;
	}

	public BigDecimal getShuijin() {
		return shuijin;
	}

	public void setShuijin(BigDecimal shuijin) {
		this.shuijin = shuijin;
	}

	public String getBorrowNo() {
		return borrowNo;
	}

	public void setBorrowNo(String borrowNo) {
		this.borrowNo = borrowNo;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public String getCgDepartment() {
		return cgDepartment;
	}

	public void setCgDepartment(String cgDepartment) {
		this.cgDepartment = cgDepartment;
	}

	public List<CgCl> getCgcl() {
		return cgcl;
	}

	public void setCgcl(List<CgCl> cgcl) {
		this.cgcl = cgcl;
	}

	public String getFbNo() {
		return fbNo;
	}

	public void setFbNo(String fbNo) {
		this.fbNo = fbNo;
	}

	public List<Accessory> getAccessory1() {
		return accessory1;
	}

	public void setAccessory1(List<Accessory> accessory1) {
		this.accessory1 = accessory1;
	}

	public String getProgramType() {
		return programType;
	}

	public void setProgramType(String programType) {
		this.programType = programType;
	}

	public String getCgdNo() {
		return cgdNo;
	}

	public void setCgdNo(String cgdNo) {
		this.cgdNo = cgdNo;
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

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getCgNo() {
		return cgNo;
	}

	public void setCgNo(String cgNo) {
		this.cgNo = cgNo;
	}

	public String getCgId() {
		return cgId;
	}

	public void setCgId(String cgId) {
		this.cgId = cgId;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getWorkNo() {
		return workNo;
	}

	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}

	public String getIsProgram() {
		return isProgram;
	}

	public void setIsProgram(String isProgram) {
		this.isProgram = isProgram;
	}

	public String getCgcType() {
		return cgcType;
	}

	public void setCgcType(String cgcType) {
		this.cgcType = cgcType;
	}

	public BigDecimal getProgramMoney() {
		return programMoney;
	}

	public void setProgramMoney(BigDecimal programMoney) {
		this.programMoney = programMoney;
	}

	public BigDecimal getCgContractMoney() {
		return cgContractMoney;
	}

	public void setCgContractMoney(BigDecimal cgContractMoney) {
		this.cgContractMoney = cgContractMoney;
	}

	public String getContractNameJia() {
		return contractNameJia;
	}

	public void setContractNameJia(String contractNameJia) {
		this.contractNameJia = contractNameJia;
	}

	public String getContractNameYi() {
		return contractNameYi;
	}

	public void setContractNameYi(String contractNameYi) {
		this.contractNameYi = contractNameYi;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getContractSignTime() {
		return contractSignTime;
	}

	public void setContractSignTime(String contractSignTime) {
		this.contractSignTime = contractSignTime;
	}

	public String getContractSummary() {
		return contractSummary;
	}

	public void setContractSummary(String contractSummary) {
		this.contractSummary = contractSummary;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	public String getStarterName() {
		return starterName;
	}

	public void setStarterName(String starterName) {
		this.starterName = starterName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
