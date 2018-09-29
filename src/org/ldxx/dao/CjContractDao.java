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
	
	public List<CjContract> selectIdAndName();
	
	public List<CjContract> selectContractNoById(@Param("id")String id);
	
	public List<CjContract> selectContractByTaskNo(@Param("no")String no);
	
	public List<CjContract> selectCjByName(@Param("name")String name);
	
	public List<CjContract> selectCjByNo(@Param("no")String no);
	
	public List<CjContract> selectCjHistory(@Param("no")String no);
}
