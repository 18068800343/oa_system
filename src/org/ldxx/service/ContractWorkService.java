package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.ContractWork;

public interface ContractWorkService {

	public int addContractWork(ContractWork work);
	
	public List<ContractWork> selectContractWork(String type);
}
