package org.ldxx.dao;


import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ContractUpdate;

public interface ContractUpdateDao {

	public int addContractUpdate(@Param("cu")ContractUpdate cu);
	
	public int updateContractUpdate(@Param("cu")ContractUpdate cu);
	
	public ContractUpdate selectContractUpdateByPrjNoAndDept(@Param("no")String no,@Param("dept")String dept);
}
