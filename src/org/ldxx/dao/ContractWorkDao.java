package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ContractWork;

public interface ContractWorkDao {

	public int addContractWork(@Param("work")ContractWork work);
	
	public List<ContractWork> selectContractWork(@Param("type")String type);
}
