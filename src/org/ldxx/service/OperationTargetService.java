package org.ldxx.service;

import java.util.List;
import java.util.Map;

import org.ldxx.bean.OperationTarget;

public interface OperationTargetService {

	public int addOperationTarget(OperationTarget target);
	
	public int deleteOperationTargetById(String id);
	
	public int updateOperationTarget(OperationTarget target);
	
	public List<OperationTarget> selectOperationTarget();
	
	public float getSumCostByYear(String year);
	
	public OperationTarget selectOperationTargetByYear(String year);
	
	public String selectGsOperationTargetByTime(String time);
	
	public String selectBmOperationTargetByTime(String time);
	
	public int countOperationTarget();
}
