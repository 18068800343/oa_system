package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.TDepartment;

public interface TDepartmentDao {

	public int addTDepartment(@Param("td")List<TDepartment> td);
	
	public int addTDepartmentIncome(@Param("td")TDepartment td);
	
	public int addTDepartmentOne(@Param("td")TDepartment td);
	
	public int updateIncome(@Param("td")List<TDepartment> td);
	
	public int updateIncomeOne(@Param("t")TDepartment t);
	
	public List<TDepartment> selectDepartment(@Param("no")String no);
	
	public List<TDepartment> selectDepartmentIncome();
	
	public int selectDepartmentCountByTNoAndDepart(@Param("no")String no,@Param("depart")String depart);
	
	public int deleteDepartmentByNo(@Param("no")String no);
	
	public int deleteDepartmentInComeById(@Param("id")String id);

	public List<TDepartment> getDistinctDepartmentIncome();

	public TDepartment getDistinctDepartmentIncomeByNo(@Param("no")String no);

	public int isCountBytNoAndDate(@Param("no")String no, @Param("date1")String date1);

	public int updateTDepartmentIncomeBytNoAndDate(@Param("t")TDepartment tDepartment2);
}
