package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.ContractReason;

public interface ContractReasonService {

	public ContractReason selectContractReasonById(String id);
	
	public int addContractReason(ContractReason cr);
}
