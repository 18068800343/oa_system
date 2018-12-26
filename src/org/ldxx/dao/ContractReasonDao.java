package org.ldxx.dao;


import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ContractReason;

public interface ContractReasonDao {

	public ContractReason selectContractReasonById(@Param("id")String id);
	
	public int addContractReason(@Param("cr")ContractReason cr);
	
	public int updateContractReasonById(@Param("cr")ContractReason cr);
}
