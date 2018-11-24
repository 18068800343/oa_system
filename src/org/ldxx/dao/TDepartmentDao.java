package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.TDepartment;

public interface TDepartmentDao {

	public int addTDepartment(@Param("td")List<TDepartment> td);
	
	public int updateIncome(@Param("td")List<TDepartment> td);
	
	public List<TDepartment> selectDepartment(@Param("no")String no);
	
	public int deleteDepartmentByNo(@Param("no")String no);
}
