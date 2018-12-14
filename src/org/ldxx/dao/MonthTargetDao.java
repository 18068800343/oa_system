package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.MonthTarget;

public interface MonthTargetDao {

	public int addMonthTarget(@Param("target")List<MonthTarget> target);
	
	public int updateMonthTarget(@Param("target")List<MonthTarget> target);
	
	public List<MonthTarget> selectMonthTargetById(@Param("id")String tId);
	
	public int orNotSplit(@Param("id")String id);
	
	public int yearTargetCount(@Param("id")String id);
	
	public List<MonthTarget> selectMonthTargetByMonthSum(@Param("id")String id,@Param("month")int month);
	
	public List<MonthTarget> selectMonthTargetByYearAndMonth(@Param("year")String year,@Param("month")int month);
}
