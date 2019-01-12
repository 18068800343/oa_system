package org.ldxx.service;

import org.ldxx.bean.ContractUpdate;

public interface ContractUpdateService {

	public int addContractUpdate(ContractUpdate cu);
	
	public int updateContractUpdate(ContractUpdate cu);
	
	public float selectContractUpdateByPrjNoAndDept(String no,String dept);
}
