package org.ldxx.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.ldxx.bean.ProjectTraceLog;
import org.ldxx.service.ProjectTraceLogService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("traceLog")
public class ProjectTraceLogController {

	@Autowired
	private ProjectTraceLogService pservice;
	
	@RequestMapping("/addProjectTraceLogBySave")
	@ResponseBody
	public int addProjectTraceLogBySave(ProjectTraceLog traceLog,HttpServletRequest request){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		traceLog.setPtlId(id);
		String name=(String) request.getSession().getAttribute("name");
		traceLog.setPtlName(name);
		int i=pservice.addProjectTraceLog(traceLog);
		return i; 
	}
	
	
	@RequestMapping("/addProjectTraceLogBySubmit")
	@ResponseBody
	public int addProjectTraceLogBySubmit(ProjectTraceLog traceLog,HttpServletRequest request){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		traceLog.setPtlId(id);
		String name=(String) request.getSession().getAttribute("name");
		traceLog.setPtlName(name);
		int i=pservice.addProjectTraceLog(traceLog);
		return i; 
	}
	
	@RequestMapping("/deleteProjectTraceLog")
	@ResponseBody
	public int deleteProjectTraceLog(String id){
		int i=pservice.deleteProjectTraceLog(id);
		return i; 
	}
	
	@RequestMapping("/updateProjectTraceLogBySave")
	@ResponseBody
	public int updateProjectTraceLogBySave(ProjectTraceLog traceLog,HttpServletRequest request){
		String name=(String) request.getSession().getAttribute("name");
		traceLog.setPtlName(name);
		int i=pservice.updateProjectTraceLog(traceLog);
		return i; 
	}
	
	
	@RequestMapping("/updateProjectTraceLogBySubmit")
	@ResponseBody
	public int updateProjectTraceLogBySubmit(ProjectTraceLog traceLog,HttpServletRequest request){
		String name=(String) request.getSession().getAttribute("name");
		traceLog.setPtlName(name);
		int i=pservice.updateProjectTraceLog(traceLog);
		return i; 
	}
	
	@RequestMapping("/selectProjectTraceLog")
	@ResponseBody
	public List<ProjectTraceLog> selectProjectTraceLog(String status){
		List<ProjectTraceLog> list=pservice.selectProjectTraceLog(status);
		return list; 
	}
	
}
