package org.ldxx.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.OperationTarget;

public interface OperationTargetDao {

	public int addOperationTarget(@Param("target")OperationTarget target);
	
	public int deleteOperationTargetById(@Param("id")String id);
	
	public int updateOperationTarget(@Param("target")OperationTarget target);
	
	public List<OperationTarget> selectOperationTarget();
	
	public int countByYear(@Param("year")String year,@Param("id")String id);
	
	public float getSumCostByYear(@Param("year")String year);
	
	public OperationTarget selectOperationTargetByYear(@Param("year")String year);
	
	public String selectGsOperationTargetByTime(@Param("time")String time);
	
	public String selectBmOperationTargetByTime(@Param("time")String time);
	
	public int countOperationTarget();
	
}
