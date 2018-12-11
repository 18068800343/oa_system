package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.DepartmentTarget;

public interface DepartmentTargetService {

	public int addDepartmentTarget(List<DepartmentTarget> dTarget);
	
	public int updateDepartmentTarget(List<DepartmentTarget> dTarget);
	
	public List<DepartmentTarget> selectDepartmentTarget(String otId);
	
	public int orNotSplit(String otId);
	
	public List<DepartmentTarget> selectDepartmentTargetByOmId(String id);
	
	public DepartmentTarget selectDepartmentTargetByOmIdAndYear(String id,String year);
}
