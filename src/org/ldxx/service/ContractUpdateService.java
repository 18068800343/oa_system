package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Task;

public interface ContractUpdateService {

	public int addContractUpdate(List<Task> task);
	
	public float selectContractUpdateByPrjNoAndDept(String no,String dept);

	int addContractAndTaskUpdate(List<Task> task);
	
}
