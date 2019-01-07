package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ContractWork;

public interface ContractWorkService {

	public int addContractWork(ContractWork work);
	
	public List<ContractWork> selectContractWork(String type,String status);
	
	public ContractWork selectContractWorkByNo(String no);
	
	public ContractWork getContractMoney(String no);

	public ContractWork selectContractWorkByid(String id);

	public ContractWork selectContractWorkBytaskNoAndCno(String no, String type);
	
	public int updateContractWork2(ContractWork work);
	
	public int updateContractWork3(ContractWork work);

	public List<ContractWork> selectContractWorkByprjNo(String pNo,String type);
}
