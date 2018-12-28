package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ProjectTraceLog;

public interface ProjectTraceLogDao {

	public int addProjectTraceLog(@Param("traceLog")ProjectTraceLog traceLog);
	
	public int deleteProjectTraceLog(@Param("id")String id);
	
	public int updateProjectTraceLog(@Param("traceLog")ProjectTraceLog traceLog);
	
	public List<ProjectTraceLog> selectProjectTraceLog();

	public ProjectTraceLog selectProjectTraceLogById(@Param("id")String id);
}
