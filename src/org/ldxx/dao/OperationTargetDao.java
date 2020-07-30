package org.ldxx.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.OperationTarget;

public interface OperationTargetDao {

	public int addOperationTarget(@Param("target")OperationTarget target);
	
	public int deleteOperationTargetById(@Param("id")String id);
	
	public int updateOperationTarget(@Param("target")OperationTarget target);
	
	public List<OperationTarget> selectOperationTarget();
	
	public int countByYear(@Param("year")String year,@Param("id")String id);
	
	public BigDecimal getSumCostByYear(@Param("year")String year);
	
	public OperationTarget selectOperationTargetByYear(@Param("year")String year);
	
	public String selectGsOperationTargetByTime(@Param("time")String time);
	
	public String selectBmOperationTargetByTime(@Param("time")String time);
	
	public int countOperationTarget();
	
}
