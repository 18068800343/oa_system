package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.ContractWork;

public interface ContractWorkService {

	public int addContractWork(ContractWork work);
	
	public List<ContractWork> selectContractWork(String type,String status);
	
	public ContractWork selectContractWorkByNo(String no);
	
	public ContractWork getContractMoney(String no);

	public ContractWork selectContractWorkByid(String id);

	public ContractWork selectContractWorkBytaskNoAndCno(String no, String type);
}
