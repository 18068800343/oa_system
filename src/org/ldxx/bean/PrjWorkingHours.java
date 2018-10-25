package org.ldxx.bean;

import java.util.List;

/**
 * 项目工时管理
 * @author hp
 *
 */
public class PrjWorkingHours {
	
	private String pwhId;
	private String prjName;//项目名
	private String prjNo;//任务单号
	private String contractMoney;//合同额
	private String designInput;//设计院手动输入
	private String prjUnit;//项目管理单位
	private String attendanceTime;//考勤时间
	private String prjType;//项目类型
	private String personDynamics;//人员动态
	private String attendanceDesc;//考勤情况概述
	private List<Accessory> accessory;
	private List<PrjWorkingHoursP> prjWorkingHoursP;//人员工时表

	
	
	public List<Accessory> getAccessory() {
		return accessory;
	}

	public void setAccessory(List<Accessory> accessory) {
		this.accessory = accessory;
	}

	public String getPwhId() {
		return pwhId;
	}

	public void setPwhId(String pwhId) {
		this.pwhId = pwhId;
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

	public String getContractMoney() {
		return contractMoney;
	}

	public void setContractMoney(String contractMoney) {
		this.contractMoney = contractMoney;
	}

	public String getDesignInput() {
		return designInput;
	}

	public void setDesignInput(String designInput) {
		this.designInput = designInput;
	}

	public String getPrjUnit() {
		return prjUnit;
	}

	public void setPrjUnit(String prjUnit) {
		this.prjUnit = prjUnit;
	}

	public String getAttendanceTime() {
		return attendanceTime;
	}

	public void setAttendanceTime(String attendanceTime) {
		this.attendanceTime = attendanceTime;
	}

	public String getPrjType() {
		return prjType;
	}

	public void setPrjType(String prjType) {
		this.prjType = prjType;
	}

	public String getPersonDynamics() {
		return personDynamics;
	}

	public void setPersonDynamics(String personDynamics) {
		this.personDynamics = personDynamics;
	}

	public String getAttendanceDesc() {
		return attendanceDesc;
	}

	public void setAttendanceDesc(String attendanceDesc) {
		this.attendanceDesc = attendanceDesc;
	}

	public List<PrjWorkingHoursP> getPrjWorkingHoursP() {
		return prjWorkingHoursP;
	}

	public void setPrjWorkingHoursP(List<PrjWorkingHoursP> prjWorkingHoursP) {
		this.prjWorkingHoursP = prjWorkingHoursP;
	}

	
}
