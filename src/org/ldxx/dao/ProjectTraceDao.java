package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ProjectTrace;

public interface ProjectTraceDao {

	public int addProjectTrace(@Param("trace")ProjectTrace trace);
	
	public int deleteProjectTrace(@Param("id")String id);
	
	public int updateProjectTrace(@Param("trace")ProjectTrace trace);
	
	public List<ProjectTrace> selectProjectTrace(@Param("status")String status);
	
	public ProjectTrace selectProjectTraceById(@Param("id")String id);

	public ProjectTrace selectprjStatesByname(@Param("prjName")String prjName);//通过项目名查找项目跟踪状态

	public int dateCount(@Param("time")String time);
	
	public ProjectTrace selectProjectTraceByNo(@Param("no")String no);
	
	public ProjectTrace selectProjectTraceByName(@Param("name")String name);
}
