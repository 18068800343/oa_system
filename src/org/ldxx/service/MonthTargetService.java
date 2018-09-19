package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.MonthTarget;

public interface MonthTargetService {

	public int addMonthTarget(List<MonthTarget> target);
	
	public int updateMonthTarget(List<MonthTarget> target);
	
	public List<MonthTarget> selectMonthTargetById(String tId); 
	
	public int orNotSplit(String id);
	
	public int ifTarget(String id);
	
	public List<MonthTarget> selectMonthTargetByMonthSum(String id,int month);
}
