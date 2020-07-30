package org.ldxx.service;

import java.math.BigDecimal;
import java.util.List;

import org.ldxx.bean.ContractUpdate;
import org.ldxx.bean.Task;

public interface ContractUpdateService {

	public int addContractUpdate(List<Task> task);
	
	public BigDecimal selectContractUpdateByPrjNoAndDept(String no,String dept);

	int addContractAndTaskUpdate(List<Task> task);
	
	public ContractUpdate selectGsContractMoneyByTime(String time);
	
	public ContractUpdate selectDeptContractMoneyByTime(String time,String dept);
	
	public ContractUpdate selectDeptContractMoneyByTimeAndType(String time,String dept,String type);
	
	public ContractUpdate selectDeptContractMoneyByStartAndEndTime(String start,String end,String dept);

	int addContractUpdateMainTask(List<Task> task);
	
	int addContractUpdateMainTaskchaifen(List<Task> task);
	
	public int addContractUpdate1(List<ContractUpdate> cu);
	
}
