package org.ldxx.bean;

import java.math.BigDecimal;
import java.util.List;

public class Task {
    private String prjId;

    private String prjType2;

    private String prjNo;
    
    private String mainPrjNo;

    private String mainPrjName;//主任务单名称,非数据库对应属性
    
    private String mainPrjId;//主任务单主键,非数据库对应属性
    
    private String prjName;
    
    private String prjArea;

    private String prjManagementModel;

    private String prjCompany;
    
    private String prjCompany1;
    
    private String prjSource;

    private String prjOwnerUnit;

    private String workContent;

    private BigDecimal prjEstimateMoney;
    
    private BigDecimal prjEstimateMoneyLast;
    
    //第一次新建任务单时候不会随其他改变的任务单金额，
	private BigDecimal prjEstimateMoneyOld;

    private BigDecimal contractMoney;
    
    private BigDecimal contractMoneyLast;

    private BigDecimal provisionalSum;
    
    private BigDecimal guanliMoney;//管理费

    private String prjStartTime;

    private String prjEndTime;

    private String mainDepartment;
    
    private String mainDepartmentLast;

    private BigDecimal mainDepartmentMoney;
    
    private BigDecimal mainDepartmentMoneyLast;
    
    private String mainDepartmentCost;
    
    private String mainDepartmentCostLast;
    
    private String mainPrjLeader;
    private String mainPrjLeaderName;
    
    private String mainEngineer;
    private String mainEngineerName;
    
    private String mainOther;
    private String mainOtherName;

    private String assistDepartment1;
    
    private String assistDepartment1Last;

    private BigDecimal assistDepartment1Money;
    
    private BigDecimal assistDepartment1MoneyLast;
    
    private String assistDepartment1Cost;
    
    private String assistDepartment1CostLast;
    
    private String assist1PrjLeader;
    private String assist1PrjLeaderName;
    
    private String assist1Engineer;
    private String assist1EngineerName;
    
    private String assist1Other;
    private String assist1OtherName;
    
    private String assistDepartment2;
    
    private String assistDepartment2Last;

    private BigDecimal assistDepartment2Money;
    
    private BigDecimal assistDepartment2MoneyLast;
    
    private String assistDepartment2Cost;
    
    private String assistDepartment2CostLast;
    
    private String assist2PrjLeader;
    private String assist2PrjLeaderName;
    
    private String assist2Engineer;
    private String assist2EngineerName;
    
    private String assist2Other;
    private String assist2OtherName;

    private String assistDepartment3;
    
    private String assistDepartment3Last;

    private BigDecimal assistDepartment3Money;
    
    private BigDecimal assistDepartment3MoneyLast;
    
    private String assistDepartment3Cost;
    
    private String assistDepartment3CostLast;
    
    private String assist3PrjLeader;
    private String assist3PrjLeaderName;
    
    private String assist3Engineer;
    private String assist3EngineerName;
    
    private String assist3Other;
    private String assist3OtherName;

    private String importance;
    
    private List<Enterprise> enterprise;
    
    private List<CjContract> cj;
    //合同信息
    private String cjId;
    private String contractName;
    private String contractNo;
    private String contractMoneyCj;
    private String temporaryMoney;
    
    private String omName;//主办部门
    private String name1;//协办部门1
    private String name2;//协办部门2
    private String name3;//协办部门3
    private String chaifenOmno;//拆分时主任务单部门,非数据库对应属性
    private String makeTime;
    
    private String ccName;
    
    private PrjCompanyVo prjCompanyVo;
    
    private BigDecimal yugongkebili;
    
    private BigDecimal chushebili;
    
    private BigDecimal shishebili;
    
    private List<Task> taskChildren;
    
    private String tongjiMoney;
    
    private String jsState;//结算状态（0:全部结算，1:部分结算，2:未结算）
    private int fileLength;//判断经营文档文档是否归档,非数据库对应属性；0：未归档，1：已归档
    private int fileLengthSG;//判断施工文档文档是否归档,非数据库对应属性；0：未归档，1：已归档
    private int fileLengthJC;//判断检测文档文档是否归档,非数据库对应属性；0：未归档，1：已归档
    private int fileLengthSJ;//判断设计文档文档是否归档,非数据库对应属性；0：未归档，1：已归档
    private int fileLengthKJ;//判断科技文档文档是否归档,非数据库对应属性；0：未归档，1：已归档
    
    private String lxTime;//立项时间
    private String xgDodate;//最新修改立项时间
    
    private String stopReason;//终于原因
    private String starterName;//发起人
    private String status;//审批状态
    
    private BigDecimal contractMoneyOld;//原合同金额
    
    private String tijiaoViews;//原合同金额

	public String getTijiaoViews() {
		return tijiaoViews;
	}

	public void setTijiaoViews(String tijiaoViews) {
		this.tijiaoViews = tijiaoViews;
	}

	public BigDecimal getContractMoneyOld() {
		return contractMoneyOld;
	}

	public void setContractMoneyOld(BigDecimal contractMoneyOld) {
		this.contractMoneyOld = contractMoneyOld;
	}

	public BigDecimal getPrjEstimateMoneyLast() {
		return prjEstimateMoneyLast;
	}

	public void setPrjEstimateMoneyLast(BigDecimal prjEstimateMoneyLast) {
		this.prjEstimateMoneyLast = prjEstimateMoneyLast;
	}

	public BigDecimal getContractMoneyLast() {
		return contractMoneyLast;
	}

	public void setContractMoneyLast(BigDecimal contractMoneyLast) {
		this.contractMoneyLast = contractMoneyLast;
	}

	public String getMainDepartmentLast() {
		return mainDepartmentLast;
	}

	public void setMainDepartmentLast(String mainDepartmentLast) {
		this.mainDepartmentLast = mainDepartmentLast;
	}

	public BigDecimal getMainDepartmentMoneyLast() {
		return mainDepartmentMoneyLast;
	}

	public void setMainDepartmentMoneyLast(BigDecimal mainDepartmentMoneyLast) {
		this.mainDepartmentMoneyLast = mainDepartmentMoneyLast;
	}

	public String getMainDepartmentCostLast() {
		return mainDepartmentCostLast;
	}

	public void setMainDepartmentCostLast(String mainDepartmentCostLast) {
		this.mainDepartmentCostLast = mainDepartmentCostLast;
	}

	public String getAssistDepartment1Last() {
		return assistDepartment1Last;
	}

	public void setAssistDepartment1Last(String assistDepartment1Last) {
		this.assistDepartment1Last = assistDepartment1Last;
	}

	public BigDecimal getAssistDepartment1MoneyLast() {
		return assistDepartment1MoneyLast;
	}

	public void setAssistDepartment1MoneyLast(BigDecimal assistDepartment1MoneyLast) {
		this.assistDepartment1MoneyLast = assistDepartment1MoneyLast;
	}

	public String getAssistDepartment1CostLast() {
		return assistDepartment1CostLast;
	}

	public void setAssistDepartment1CostLast(String assistDepartment1CostLast) {
		this.assistDepartment1CostLast = assistDepartment1CostLast;
	}

	public String getAssistDepartment2Last() {
		return assistDepartment2Last;
	}

	public void setAssistDepartment2Last(String assistDepartment2Last) {
		this.assistDepartment2Last = assistDepartment2Last;
	}

	public BigDecimal getAssistDepartment2MoneyLast() {
		return assistDepartment2MoneyLast;
	}

	public void setAssistDepartment2MoneyLast(BigDecimal assistDepartment2MoneyLast) {
		this.assistDepartment2MoneyLast = assistDepartment2MoneyLast;
	}

	public String getAssistDepartment2CostLast() {
		return assistDepartment2CostLast;
	}

	public void setAssistDepartment2CostLast(String assistDepartment2CostLast) {
		this.assistDepartment2CostLast = assistDepartment2CostLast;
	}

	public String getAssistDepartment3Last() {
		return assistDepartment3Last;
	}

	public void setAssistDepartment3Last(String assistDepartment3Last) {
		this.assistDepartment3Last = assistDepartment3Last;
	}

	public BigDecimal getAssistDepartment3MoneyLast() {
		return assistDepartment3MoneyLast;
	}

	public void setAssistDepartment3MoneyLast(BigDecimal assistDepartment3MoneyLast) {
		this.assistDepartment3MoneyLast = assistDepartment3MoneyLast;
	}

	public String getAssistDepartment3CostLast() {
		return assistDepartment3CostLast;
	}

	public void setAssistDepartment3CostLast(String assistDepartment3CostLast) {
		this.assistDepartment3CostLast = assistDepartment3CostLast;
	}

	public String getXgDodate() {
		return xgDodate;
	}

	public void setXgDodate(String xgDodate) {
		this.xgDodate = xgDodate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStarterName() {
		return starterName;
	}

	public void setStarterName(String starterName) {
		this.starterName = starterName;
	}

	public String getStopReason() {
		return stopReason;
	}

	public void setStopReason(String stopReason) {
		this.stopReason = stopReason;
	}

	public BigDecimal getGuanliMoney() {
		return guanliMoney;
	}

	public void setGuanliMoney(BigDecimal guanliMoney) {
		this.guanliMoney = guanliMoney;
	}

	public String getLxTime() {
		return lxTime;
	}

	public void setLxTime(String lxTime) {
		this.lxTime = lxTime;
	}

	public String getMainEngineerName() {
		return mainEngineerName;
	}

	public void setMainEngineerName(String mainEngineerName) {
		this.mainEngineerName = mainEngineerName;
	}

	public String getMainOtherName() {
		return mainOtherName;
	}

	public void setMainOtherName(String mainOtherName) {
		this.mainOtherName = mainOtherName;
	}

	public String getAssist1PrjLeaderName() {
		return assist1PrjLeaderName;
	}

	public void setAssist1PrjLeaderName(String assist1PrjLeaderName) {
		this.assist1PrjLeaderName = assist1PrjLeaderName;
	}

	public String getAssist1EngineerName() {
		return assist1EngineerName;
	}

	public void setAssist1EngineerName(String assist1EngineerName) {
		this.assist1EngineerName = assist1EngineerName;
	}

	public String getAssist1OtherName() {
		return assist1OtherName;
	}

	public void setAssist1OtherName(String assist1OtherName) {
		this.assist1OtherName = assist1OtherName;
	}

	public String getAssist2PrjLeaderName() {
		return assist2PrjLeaderName;
	}

	public void setAssist2PrjLeaderName(String assist2PrjLeaderName) {
		this.assist2PrjLeaderName = assist2PrjLeaderName;
	}

	public String getAssist2EngineerName() {
		return assist2EngineerName;
	}

	public void setAssist2EngineerName(String assist2EngineerName) {
		this.assist2EngineerName = assist2EngineerName;
	}

	public String getAssist2OtherName() {
		return assist2OtherName;
	}

	public void setAssist2OtherName(String assist2OtherName) {
		this.assist2OtherName = assist2OtherName;
	}

	public String getAssist3PrjLeaderName() {
		return assist3PrjLeaderName;
	}

	public void setAssist3PrjLeaderName(String assist3PrjLeaderName) {
		this.assist3PrjLeaderName = assist3PrjLeaderName;
	}

	public String getAssist3EngineerName() {
		return assist3EngineerName;
	}

	public void setAssist3EngineerName(String assist3EngineerName) {
		this.assist3EngineerName = assist3EngineerName;
	}

	public String getAssist3OtherName() {
		return assist3OtherName;
	}

	public void setAssist3OtherName(String assist3OtherName) {
		this.assist3OtherName = assist3OtherName;
	}

	public String getCjId() {
		return cjId;
	}

	public void setCjId(String cjId) {
		this.cjId = cjId;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getContractMoneyCj() {
		return contractMoneyCj;
	}

	public void setContractMoneyCj(String contractMoneyCj) {
		this.contractMoneyCj = contractMoneyCj;
	}

	public String getTemporaryMoney() {
		return temporaryMoney;
	}

	public void setTemporaryMoney(String temporaryMoney) {
		this.temporaryMoney = temporaryMoney;
	}

	public int getFileLengthSG() {
		return fileLengthSG;
	}

	public void setFileLengthSG(int fileLengthSG) {
		this.fileLengthSG = fileLengthSG;
	}

	public int getFileLengthJC() {
		return fileLengthJC;
	}

	public void setFileLengthJC(int fileLengthJC) {
		this.fileLengthJC = fileLengthJC;
	}

	public int getFileLengthSJ() {
		return fileLengthSJ;
	}

	public void setFileLengthSJ(int fileLengthSJ) {
		this.fileLengthSJ = fileLengthSJ;
	}

	public int getFileLengthKJ() {
		return fileLengthKJ;
	}

	public void setFileLengthKJ(int fileLengthKJ) {
		this.fileLengthKJ = fileLengthKJ;
	}

	public int getFileLength() {
		return fileLength;
	}

	public void setFileLength(int fileLength) {
		this.fileLength = fileLength;
	}

	public String getJsState() {
		return jsState;
	}

	public void setJsState(String jsState) {
		this.jsState = jsState;
	}

	public String getTongjiMoney() {
		return tongjiMoney;
	}

	public void setTongjiMoney(String tongjiMoney) {
		this.tongjiMoney = tongjiMoney;
	}

	public List<Task> getTaskChildren() {
		return taskChildren;
	}

	public void setTaskChildren(List<Task> taskChildren) {
		this.taskChildren = taskChildren;
	}

	public String getMainPrjName() {
		return mainPrjName;
	}

	public void setMainPrjName(String mainPrjName) {
		this.mainPrjName = mainPrjName;
	}

	public String getMainPrjId() {
		return mainPrjId;
	}

	public void setMainPrjId(String mainPrjId) {
		this.mainPrjId = mainPrjId;
	}

	public String getChaifenOmno() {
		return chaifenOmno;
	}

	public void setChaifenOmno(String chaifenOmno) {
		this.chaifenOmno = chaifenOmno;
	}

	public BigDecimal getYugongkebili() {
		return yugongkebili;
	}

	public void setYugongkebili(BigDecimal yugongkebili) {
		this.yugongkebili = yugongkebili;
	}

	public BigDecimal getChushebili() {
		return chushebili;
	}

	public void setChushebili(BigDecimal chushebili) {
		this.chushebili = chushebili;
	}

	public BigDecimal getShishebili() {
		return shishebili;
	}

	public void setShishebili(BigDecimal shishebili) {
		this.shishebili = shishebili;
	}

	public String getMainPrjNo() {
		return mainPrjNo;
	}

	public void setMainPrjNo(String mainPrjNo) {
		this.mainPrjNo = mainPrjNo;
	}

	public String getMainDepartmentCost() {
		return mainDepartmentCost;
	}

	public void setMainDepartmentCost(String mainDepartmentCost) {
		this.mainDepartmentCost = mainDepartmentCost;
	}

	public String getAssistDepartment1Cost() {
		return assistDepartment1Cost;
	}

	public void setAssistDepartment1Cost(String assistDepartment1Cost) {
		this.assistDepartment1Cost = assistDepartment1Cost;
	}

	public String getAssistDepartment2Cost() {
		return assistDepartment2Cost;
	}

	public void setAssistDepartment2Cost(String assistDepartment2Cost) {
		this.assistDepartment2Cost = assistDepartment2Cost;
	}

	public String getAssistDepartment3Cost() {
		return assistDepartment3Cost;
	}

	public void setAssistDepartment3Cost(String assistDepartment3Cost) {
		this.assistDepartment3Cost = assistDepartment3Cost;
	}

	public PrjCompanyVo getPrjCompanyVo() {
		return prjCompanyVo;
	}

	public void setPrjCompanyVo(PrjCompanyVo prjCompanyVo) {
		this.prjCompanyVo = prjCompanyVo;
	}

	public String getMainPrjLeaderName() {
		return mainPrjLeaderName;
	}

	public void setMainPrjLeaderName(String mainPrjLeaderName) {
		this.mainPrjLeaderName = mainPrjLeaderName;
	}

	public List<CjContract> getCj() {
		return cj;
	}

	public void setCj(List<CjContract> cj) {
		this.cj = cj;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}

	public String getPrjArea() {
		return prjArea;
	}

	public void setPrjArea(String prjArea) {
		this.prjArea = prjArea;
	}

	public String getPrjSource() {
		return prjSource;
	}

	public void setPrjSource(String prjSource) {
		this.prjSource = prjSource;
	}

	public String getMainPrjLeader() {
		return mainPrjLeader;
	}

	public void setMainPrjLeader(String mainPrjLeader) {
		this.mainPrjLeader = mainPrjLeader;
	}

	public String getMainEngineer() {
		return mainEngineer;
	}

	public void setMainEngineer(String mainEngineer) {
		this.mainEngineer = mainEngineer;
	}

	public String getMainOther() {
		return mainOther;
	}

	public void setMainOther(String mainOther) {
		this.mainOther = mainOther;
	}

	public String getAssist1PrjLeader() {
		return assist1PrjLeader;
	}

	public void setAssist1PrjLeader(String assist1PrjLeader) {
		this.assist1PrjLeader = assist1PrjLeader;
	}

	public String getAssist1Engineer() {
		return assist1Engineer;
	}

	public void setAssist1Engineer(String assist1Engineer) {
		this.assist1Engineer = assist1Engineer;
	}

	public String getAssist1Other() {
		return assist1Other;
	}

	public void setAssist1Other(String assist1Other) {
		this.assist1Other = assist1Other;
	}

	public String getAssist2PrjLeader() {
		return assist2PrjLeader;
	}

	public void setAssist2PrjLeader(String assist2PrjLeader) {
		this.assist2PrjLeader = assist2PrjLeader;
	}

	public String getAssist2Engineer() {
		return assist2Engineer;
	}

	public void setAssist2Engineer(String assist2Engineer) {
		this.assist2Engineer = assist2Engineer;
	}

	public String getAssist2Other() {
		return assist2Other;
	}

	public void setAssist2Other(String assist2Other) {
		this.assist2Other = assist2Other;
	}

	public String getAssist3PrjLeader() {
		return assist3PrjLeader;
	}

	public void setAssist3PrjLeader(String assist3PrjLeader) {
		this.assist3PrjLeader = assist3PrjLeader;
	}

	public String getAssist3Engineer() {
		return assist3Engineer;
	}

	public void setAssist3Engineer(String assist3Engineer) {
		this.assist3Engineer = assist3Engineer;
	}

	public String getAssist3Other() {
		return assist3Other;
	}

	public void setAssist3Other(String assist3Other) {
		this.assist3Other = assist3Other;
	}

	public String getCcName() {
		return ccName;
	}

	public void setCcName(String ccName) {
		this.ccName = ccName;
	}

	public String getMakeTime() {
		return makeTime;
	}

	public void setMakeTime(String makeTime) {
		this.makeTime = makeTime;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
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

	public String getOmName() {
		return omName;
	}

	public void setOmName(String omName) {
		this.omName = omName;
	}

	public List<Enterprise> getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(List<Enterprise> enterprise) {
		this.enterprise = enterprise;
	}

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}


	public String getPrjType2() {
		return prjType2;
	}

	public void setPrjType2(String prjType2) {
		this.prjType2 = prjType2;
	}

	public String getPrjNo() {
		return prjNo;
	}

	public void setPrjNo(String prjNo) {
		this.prjNo = prjNo;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getPrjManagementModel() {
		return prjManagementModel;
	}

	public void setPrjManagementModel(String prjManagementModel) {
		this.prjManagementModel = prjManagementModel;
	}

	public String getPrjCompany() {
		return prjCompany;
	}

	public void setPrjCompany(String prjCompany) {
		this.prjCompany = prjCompany;
	}


	public String getPrjOwnerUnit() {
		return prjOwnerUnit;
	}

	public void setPrjOwnerUnit(String prjOwnerUnit) {
		this.prjOwnerUnit = prjOwnerUnit;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	public BigDecimal getPrjEstimateMoney() {
		return prjEstimateMoney;
	}

	public void setPrjEstimateMoney(BigDecimal prjEstimateMoney) {
		this.prjEstimateMoney = prjEstimateMoney;
	}

	public BigDecimal getContractMoney() {
		return contractMoney;
	}

	public void setContractMoney(BigDecimal contractMoney) {
		this.contractMoney = contractMoney;
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

	public String getMainDepartment() {
		return mainDepartment;
	}

	public void setMainDepartment(String mainDepartment) {
		this.mainDepartment = mainDepartment;
	}

	public BigDecimal getMainDepartmentMoney() {
		return mainDepartmentMoney;
	}

	public void setMainDepartmentMoney(BigDecimal mainDepartmentMoney) {
		this.mainDepartmentMoney = mainDepartmentMoney;
	}

	public String getAssistDepartment1() {
		return assistDepartment1;
	}

	public void setAssistDepartment1(String assistDepartment1) {
		this.assistDepartment1 = assistDepartment1;
	}

	public BigDecimal getAssistDepartment1Money() {
		return assistDepartment1Money;
	}

	public void setAssistDepartment1Money(BigDecimal assistDepartment1Money) {
		this.assistDepartment1Money = assistDepartment1Money;
	}

	public String getAssistDepartment2() {
		return assistDepartment2;
	}

	public void setAssistDepartment2(String assistDepartment2) {
		this.assistDepartment2 = assistDepartment2;
	}

	public BigDecimal getAssistDepartment2Money() {
		return assistDepartment2Money;
	}

	public void setAssistDepartment2Money(BigDecimal assistDepartment2Money) {
		this.assistDepartment2Money = assistDepartment2Money;
	}

	public String getAssistDepartment3() {
		return assistDepartment3;
	}

	public void setAssistDepartment3(String assistDepartment3) {
		this.assistDepartment3 = assistDepartment3;
	}

	public BigDecimal getAssistDepartment3Money() {
		return assistDepartment3Money;
	}

	public void setAssistDepartment3Money(BigDecimal assistDepartment3Money) {
		this.assistDepartment3Money = assistDepartment3Money;
	}

	
	public String getPrjCompany1() {
		return prjCompany1;
	}

	public void setPrjCompany1(String prjCompany1) {
		this.prjCompany1 = prjCompany1;
	}

	public BigDecimal getPrjEstimateMoneyOld() {
		return prjEstimateMoneyOld;
	}

	public void setPrjEstimateMoneyOld(BigDecimal prjEstimateMoneyOld) {
		this.prjEstimateMoneyOld = prjEstimateMoneyOld;
	}
	
	@Override
	public String toString() {
		return "Task [prjId=" + prjId + ", prjType2=" + prjType2 + ", prjNo=" + prjNo
				+ ", prjName=" + prjName + ", prjManagementModel=" + prjManagementModel + ", prjCompany=" + prjCompany
				+  ", prjOwnerUnit=" + prjOwnerUnit + ", workContent=" + workContent
				+ ", prjEstimateMoney=" + prjEstimateMoney + ", contractMoney=" + contractMoney + ", provisionalSum="
				+ provisionalSum + ", prjStartTime=" + prjStartTime + ", prjEndTime=" + prjEndTime + ", mainDepartment="
				+ mainDepartment + ", mainDepartmentMoney=" + mainDepartmentMoney + ", assistDepartment1="
				+ assistDepartment1 + ", assistDepartment1Money=" + assistDepartment1Money + ", assistDepartment2="
				+ assistDepartment2 + ", assistDepartment2Money=" + assistDepartment2Money + ", assistDepartment3="
				+ assistDepartment3 + ", assistDepartment3Money=" + assistDepartment3Money + ", enterprise="
				+ enterprise + "]";
	}


}