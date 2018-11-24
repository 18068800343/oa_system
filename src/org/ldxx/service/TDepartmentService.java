package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.TDepartment;

public interface TDepartmentService {

	public int addTDepartment(List<TDepartment> td);
	
	public int updateIncome(List<TDepartment> td);
	
	public List<TDepartment> selectDepartment(String no);
	
	public int deleteDepartmentByNo(String no);
}
