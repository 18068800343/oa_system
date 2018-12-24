package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.ProjectTraceLog;

public interface ProjectTraceLogService {
	
	public int addProjectTraceLog(ProjectTraceLog traceLog);
	
	public int deleteProjectTraceLog(String id);
	
	public int updateProjectTraceLog(ProjectTraceLog traceLog);
	
	public List<ProjectTraceLog> selectProjectTraceLog(String status);

	public ProjectTraceLog selectProjectTraceLogById(String id);
}
