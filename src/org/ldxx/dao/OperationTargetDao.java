package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.OperationTarget;

public interface OperationTargetDao {

	public int addOperationTarget(@Param("target")OperationTarget target);
	
	public int deleteOperationTargetById(@Param("id")String id);
	
	public int updateOperationTarget(@Param("target")OperationTarget target);
	
	public List<OperationTarget> selectOperationTarget();
	
	public int countByYear(@Param("year")String year,@Param("id")String id);
}
