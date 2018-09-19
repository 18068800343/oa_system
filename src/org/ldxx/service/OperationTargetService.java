package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.OperationTarget;

public interface OperationTargetService {

	public int addOperationTarget(OperationTarget target);
	
	public int deleteOperationTargetById(String id);
	
	public int updateOperationTarget(OperationTarget target);
	
	public List<OperationTarget> selectOperationTarget();
}
