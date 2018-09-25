package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CjContract;

public interface CjContractDao {

	public int addCjContract(@Param("cj")CjContract cj);
	
	public int updateCjContract(@Param("cj")CjContract cj);
	
	public List<CjContract> selectCjContractByStatus(@Param("status")String status);
	
	public CjContract selectCjContractById(@Param("id")String id);
	
	public int deleteCjContract(@Param("id")String id);
}
