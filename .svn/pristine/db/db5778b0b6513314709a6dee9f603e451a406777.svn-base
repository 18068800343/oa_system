package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.ProjectTraceLog;
import org.ldxx.dao.ProjectTraceLogDao;
import org.ldxx.service.ProjectTraceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTraceLogServiceImpl  implements ProjectTraceLogService{

	@Autowired
	private ProjectTraceLogDao pdao; 
	
	@Override
	public int addProjectTraceLog(ProjectTraceLog traceLog) {
		return pdao.addProjectTraceLog(traceLog);
	}

	@Override
	public int deleteProjectTraceLog(String id) {
		return pdao.deleteProjectTraceLog(id);
	}

	@Override
	public int updateProjectTraceLog(ProjectTraceLog traceLog) {
		return pdao.updateProjectTraceLog(traceLog);
	}

	@Override
	public List<ProjectTraceLog> selectProjectTraceLog(String status) {
		return pdao.selectProjectTraceLog(status);
	}

}
