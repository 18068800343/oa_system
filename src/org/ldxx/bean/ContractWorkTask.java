package org.ldxx.bean;

import java.math.BigDecimal;
import java.util.List;

public class ContractWorkTask {
    private String cwId;
    private BigDecimal endMoney;
    private BigDecimal prjEstimateMoney;
    private String prjId;
    private String prjNO;
    private String mainDepartment;
    private BigDecimal mainDepartmentMoney;
    private String mainDepartmentCost;
    
    private String assistDepartment1;
    private BigDecimal assistDepartment1Money;
    private String assistDepartment1Cost;
    
    private String assistDepartment2;
    private BigDecimal assistDepartment2Money;
    private String assistDepartment2Cost;

    private String assistDepartment3;
    private BigDecimal assistDepartment3Money;
    private String assistDepartment3Cost;
    
    private String omName;//主办部门
    private String name1;//协办部门1
    private String name2;//协办部门2
    private String name3;//协办部门3
    
    
    
	public String getOmName() {
		return omName;
	}

	public void setOmName(String omName) {
		this.omName = omName;
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

	public BigDecimal getPrjEstimateMoney() {
		return prjEstimateMoney;
	}

	public String getPrjNO() {
		return prjNO;
	}

	public void setPrjNO(String prjNO) {
		this.prjNO = prjNO;
	}

	public void setPrjEstimateMoney(BigDecimal prjEstimateMoney) {
		this.prjEstimateMoney = prjEstimateMoney;
	}

	public String getCwId() {
		return cwId;
	}

	public void setCwId(String cwId) {
		this.cwId = cwId;
	}

	

	public BigDecimal getEndMoney() {
		return endMoney;
	}

	public void setEndMoney(BigDecimal endMoney) {
		this.endMoney = endMoney;
	}

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
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

	public String getMainDepartmentCost() {
		return mainDepartmentCost;
	}

	public void setMainDepartmentCost(String mainDepartmentCost) {
		this.mainDepartmentCost = mainDepartmentCost;
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

	public String getAssistDepartment1Cost() {
		return assistDepartment1Cost;
	}

	public void setAssistDepartment1Cost(String assistDepartment1Cost) {
		this.assistDepartment1Cost = assistDepartment1Cost;
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

	public String getAssistDepartment2Cost() {
		return assistDepartment2Cost;
	}

	public void setAssistDepartment2Cost(String assistDepartment2Cost) {
		this.assistDepartment2Cost = assistDepartment2Cost;
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

	public String getAssistDepartment3Cost() {
		return assistDepartment3Cost;
	}

	public void setAssistDepartment3Cost(String assistDepartment3Cost) {
		this.assistDepartment3Cost = assistDepartment3Cost;
	}



}