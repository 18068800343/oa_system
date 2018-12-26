package org.ldxx.service;

import org.ldxx.bean.ContractReason;

public interface ContractReasonService {

	public ContractReason selectContractReasonById(String id);
	
	public int addContractReason(ContractReason cr);
	
	public int updateContractReasonById(ContractReason cr);
}
