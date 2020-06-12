package org.ldxx.bean;

import java.util.List;

/** 
* @ClassName: CjContract 
* @Description: 承接合同
* @author zhaohui
* @date 2018年9月25日 上午11:00:21 
*  
*/
public class CjContract {

	private String cjId;
	private String taskCode;
	private String contractName;
	private String contractNo;
	private String prjName;
	private String prjType;
	private String contractNameJia;//甲方id
	private String ccName;//甲方名称
	private String contractNameYi;
	private String contractStartTime;
	private String contractEndTime;
	private String yiCjDepartment;//乙方承接部门id
	private String omName;//乙方承接部门名称
	private String contractLongTime;
	private String receieveMoneyCondition;
	private Double contractMoney;
	private Double contractMoneyLast;
	private Double temporaryMoney;
	private String contractSignTime;
	private String workInfo;
	private String mainDepartment;
	private String name;
	private Double mainDepartmentMoney;
	private String assistDepartment1;
	private String name2;
	private Double assistDepartment1Money;
	private String assistDepartment2;
	private String name3;
	private Double assistDepartment2Money;
	private String assistDepartment3;
	private String name4;
	private Double assistDepartment3Money;
	private List<Accessory> accessory;
	private List<Accessory> accessory2;//法律顾问签字
	private List<CjSplitMoney> cjSplitMoney;//承接合同拆分金额
	private Integer splitState;//拆分合同金额状态0：未拆分，1:已拆分
	private List<CjDeptSplitMoney> cjDeptSplitMoney;//承接合同部门拆分金额
	private List<Task> chaiFenXinXiArray;
	private String jyms;//经营模式
	private Double sm;//根据承接合同查出来的累计分包金额
	private String cancelReason;//承接合同取消原因
	
	private String starterName;//发起人
    private String status;//审批状态
    private String doDate;//审批状态
    
    private Double contractMoneyOld;//原合同金额
    private String oldCjId;//上次的ID
    private String tijiaoViews;//上次的ID
    private String oldCjFileName;//上次的ID
    private List<Accessory> accessory3;//法律顾问签字
    
    
	public List<Accessory> getAccessory3() {
		return accessory3;
	}
	public void setAccessory3(List<Accessory> accessory3) {
		this.accessory3 = accessory3;
	}
	public String getOldCjFileName() {
		return oldCjFileName;
	}
	public void setOldCjFileName(String oldCjFileName) {
		this.oldCjFileName = oldCjFileName;
	}
	public String getTijiaoViews() {
		return tijiaoViews;
	}
	public void setTijiaoViews(String tijiaoViews) {
		this.tijiaoViews = tijiaoViews;
	}
	public String getOldCjId() {
		return oldCjId;
	}
	public void setOldCjId(String oldCjId) {
		this.oldCjId = oldCjId;
	}
	public Double getContractMoneyOld() {
		return contractMoneyOld;
	}
	public void setContractMoneyOld(Double contractMoneyOld) {
		this.contractMoneyOld = contractMoneyOld;
	}
	public Double getContractMoneyLast() {
		return contractMoneyLast;
	}
	public void setContractMoneyLast(Double contractMoneyLast) {
		this.contractMoneyLast = contractMoneyLast;
	}
	public String getDoDate() {
		return doDate;
	}
	public void setDoDate(String doDate) {
		this.doDate = doDate;
	}
	public String getCancelReason() {
		return cancelReason;
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
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	public Double getSm() {
		return sm;
	}
	public void setSm(Double sm) {
		this.sm = sm;
	}
	public String getJyms() {
		return jyms;
	}
	public void setJyms(String jyms) {
		this.jyms = jyms;
	}
	public List<Task> getChaiFenXinXiArray() {
		return chaiFenXinXiArray;
	}
	public void setChaiFenXinXiArray(List<Task> chaiFenXinXiArray) {
		this.chaiFenXinXiArray = chaiFenXinXiArray;
	}
	public List<CjDeptSplitMoney> getCjDeptSplitMoney() {
		return cjDeptSplitMoney;
	}
	public void setCjDeptSplitMoney(List<CjDeptSplitMoney> cjDeptSplitMoney) {
		this.cjDeptSplitMoney = cjDeptSplitMoney;
	}
	public List<Accessory> getAccessory2() {
		return accessory2;
	}
	public void setAccessory2(List<Accessory> accessory2) {
		this.accessory2 = accessory2;
	}
	public Integer getSplitState() {
		return splitState;
	}
	public void setSplitState(Integer splitState) {
		this.splitState = splitState;
	}
	public List<CjSplitMoney> getCjSplitMoney() {
		return cjSplitMoney;
	}
	public void setCjSplitMoney(List<CjSplitMoney> cjSplitMoney) {
		this.cjSplitMoney = cjSplitMoney;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getName3() {
		return name3;
	}
	public void setName3(String name3) {
		this.name3 = name3;
	}
	public String getName4() {
		return name4;
	}
	public void setName4(String name4) {
		this.name4 = name4;
	}
	public String getOmName() {
		return omName;
	}
	public void setOmName(String omName) {
		this.omName = omName;
	}
	public String getCcName() {
		return ccName;
	}
	public void setCcName(String ccName) {
		this.ccName = ccName;
	}
	public List<Accessory> getAccessory() {
		return accessory;
	}
	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}
	public String getCjId() {
		return cjId;
	}
	public void setCjId(String cjId) {
		this.cjId = cjId;
	}
	public String getTaskCode() {
		return taskCode;
	}
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getPrjType() {
		return prjType;
	}
	public void setPrjType(String prjType) {
		this.prjType = prjType;
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
	public String getContractStartTime() {
		return contractStartTime;
	}
	public void setContractStartTime(String contractStartTime) {
		this.contractStartTime = contractStartTime;
	}
	public String getContractEndTime() {
		return contractEndTime;
	}
	public void setContractEndTime(String contractEndTime) {
		this.contractEndTime = contractEndTime;
	}
	public String getYiCjDepartment() {
		return yiCjDepartment;
	}
	public void setYiCjDepartment(String yiCjDepartment) {
		this.yiCjDepartment = yiCjDepartment;
	}
	public String getContractLongTime() {
		return contractLongTime;
	}
	public void setContractLongTime(String contractLongTime) {
		this.contractLongTime = contractLongTime;
	}
	public String getReceieveMoneyCondition() {
		return receieveMoneyCondition;
	}
	public void setReceieveMoneyCondition(String receieveMoneyCondition) {
		this.receieveMoneyCondition = receieveMoneyCondition;
	}
	public Double getContractMoney() {
		return contractMoney;
	}
	public void setContractMoney(Double contractMoney) {
		this.contractMoney = contractMoney;
	}
	public Double getTemporaryMoney() {
		return temporaryMoney;
	}
	public void setTemporaryMoney(Double temporaryMoney) {
		this.temporaryMoney = temporaryMoney;
	}
	public String getContractSignTime() {
		return contractSignTime;
	}
	public void setContractSignTime(String contractSignTime) {
		this.contractSignTime = contractSignTime;
	}
	public String getWorkInfo() {
		return workInfo;
	}
	public void setWorkInfo(String workInfo) {
		this.workInfo = workInfo;
	}
	public String getMainDepartment() {
		return mainDepartment;
	}
	public void setMainDepartment(String mainDepartment) {
		this.mainDepartment = mainDepartment;
	}
	public Double getMainDepartmentMoney() {
		return mainDepartmentMoney;
	}
	public void setMainDepartmentMoney(Double mainDepartmentMoney) {
		this.mainDepartmentMoney = mainDepartmentMoney;
	}
	public String getAssistDepartment1() {
		return assistDepartment1;
	}
	public void setAssistDepartment1(String assistDepartment1) {
		this.assistDepartment1 = assistDepartment1;
	}
	public Double getAssistDepartment1Money() {
		return assistDepartment1Money;
	}
	public void setAssistDepartment1Money(Double assistDepartment1Money) {
		this.assistDepartment1Money = assistDepartment1Money;
	}
	public String getAssistDepartment2() {
		return assistDepartment2;
	}
	public void setAssistDepartment2(String assistDepartment2) {
		this.assistDepartment2 = assistDepartment2;
	}
	public Double getAssistDepartment2Money() {
		return assistDepartment2Money;
	}
	public void setAssistDepartment2Money(Double assistDepartment2Money) {
		this.assistDepartment2Money = assistDepartment2Money;
	}
	public String getAssistDepartment3() {
		return assistDepartment3;
	}
	public void setAssistDepartment3(String assistDepartment3) {
		this.assistDepartment3 = assistDepartment3;
	}
	public Double getAssistDepartment3Money() {
		return assistDepartment3Money;
	}
	public void setAssistDepartment3Money(Double assistDepartment3Money) {
		this.assistDepartment3Money = assistDepartment3Money;
	}
	@Override
	public String toString() {
		return "CjContract [cjId=" + cjId + ", taskCode=" + taskCode + ", contractName=" + contractName + ", prjName="
				+ prjName + ", prjType=" + prjType + ", contractNameJia=" + contractNameJia + ", contractNameYi="
				+ contractNameYi + ", contractStartTime=" + contractStartTime + ", contractEndTime=" + contractEndTime
				+ ", yiCjDepartment=" + yiCjDepartment + ", contractLongTime=" + contractLongTime
				+ ", receieveMoneyCondition=" + receieveMoneyCondition + ", contractMoney=" + contractMoney
				+ ", temporaryMoney=" + temporaryMoney + ", contractSignTime=" + contractSignTime + ", workInfo="
				+ workInfo + ", mainDepartment=" + mainDepartment + ", mainDepartmentMoney=" + mainDepartmentMoney
				+ ", assistDepartment1=" + assistDepartment1 + ", assistDepartment1Money=" + assistDepartment1Money
				+ ", assistDepartment2=" + assistDepartment2 + ", assistDepartment2Money=" + assistDepartment2Money
				+ ", assistDepartment3=" + assistDepartment3 + ", assistDepartment3Money=" + assistDepartment3Money
				+ "]";
	}
	
	
	
}
