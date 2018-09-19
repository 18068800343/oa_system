package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.ProjectTrace;

public interface ProjectTraceService {

	public int addProjectTrace(ProjectTrace trace);
	
	public int deleteProjectTrace(String id);
	
	public int updateProjectTrace(ProjectTrace trace);
	
	public List<ProjectTrace> selectProjectTrace(String status);
	
	public ProjectTrace selectProjectTraceById(String id,String status);
}
