package org.ldxx.service;

import java.util.List;
import java.util.Map;

import org.ldxx.bean.TDepartment;

public interface TDepartmentService {

	public int addTDepartment(List<TDepartment> td);
	
	public int updateIncome(Map<String,Object> map);
	
	public List<TDepartment> selectDepartment(String no);
	
	public int deleteDepartmentByNo(String no);
}
