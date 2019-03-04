package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.DepartmentTarget;

public interface DepartmentTargetDao {

	public int addDepartmentTarget(@Param("dTarget")List<DepartmentTarget> dTarget);
	
	public int updateDepartmentTarget(@Param("dTarget")List<DepartmentTarget> dTarget);
	
	public List<DepartmentTarget> selectDepartmentTarget(@Param("id")String otId);
	
	public int orNotSplit(@Param("id")String otId);
	
	public List<DepartmentTarget> selectDepartmentTargetByOmId(@Param("id")String id);
	
	public DepartmentTarget selectDepartmentTargetByOmIdAndYear(@Param("omId")String id,@Param("year")String year);

	public DepartmentTarget selectDepartmentTargetByIdAndOmId(@Param("id")String id,@Param("omId")String omId);
	
	public DepartmentTarget selectDepartmentTargetByYearAndOmId(@Param("year")String year,@Param("omId")String omId);

	public int countDepartmentTarget(@Param("omId")String omId);
}
