package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.DepartmentTarget2;

public interface DepartmentTarget2Dao {

	List<DepartmentTarget2> getcontractUpdatebyomIdAndyear(@Param("year")String year,@Param("omId") String omId);
	
	List<DepartmentTarget2> getTask2byomNameAndyear(@Param("year")String year,@Param("omName") String omName);
	
	List<DepartmentTarget2> getcjcontractUpdatebyomIdAndyear(@Param("year")String year,@Param("omId") String omId);

	List<DepartmentTarget2> getprjProgressFillbyomIdAndyear(@Param("year")String year,@Param("omId") String omId);
	
	List<DepartmentTarget2> gettDepartmentIncomebyomNameAndyear(@Param("year")String year,@Param("omName") String omName);
	
	List<DepartmentTarget2> getcompanyCostbyomNameAndyear(@Param("year")String year,@Param("omName") String omName);
}
