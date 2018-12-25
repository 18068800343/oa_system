package org.ldxx.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.ProjectTraceLog;
import org.ldxx.bean.User;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.ProjectTraceLogService;
import org.ldxx.util.FlowUtill;
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
	@Autowired
	private OrganizationManagementService oService;
	
	@RequestMapping("/addProjectTraceLogBySave")
	@ResponseBody
	public int addProjectTraceLogBySave(ProjectTraceLog traceLog,HttpServletRequest request,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		traceLog.setPtlId(id);
		String name=(String) request.getSession().getAttribute("name");
		traceLog.setPtlName(name);
		int i=pservice.addProjectTraceLog(traceLog);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(traceLog.getSponsorDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(traceLog.getPrjName()+"项目跟踪日志申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(traceLog.getPrjName()+"项目跟踪日志申请流程发起");
			currentFlow.setUrl("jingyingguanliLook/ProjectTrackingGZRZ.html-"+id);
			currentFlow.setParams("{'cs':'1'}");
			currentFlow.setStarter(user.getUserId());
			currentFlow.setStartername(user.getuName());
			currentFlow.setFkDept(omNo);
			currentFlow.setDeptname(user.getOmName());
			currentFlow.setNodename("节点名称");
			currentFlow.setPri(1);
			currentFlow.setSdtofnode(new Date());
			currentFlow.setSdtofflow(new Date());
			currentFlow.setFlowEndState(2);
			currentFlow.setFlowNopassState(0);
			FlowHistroy flowHistroy = new FlowHistroy();
			flowHistroy.setActor(user.getUserId());
			flowHistroy.setActorname(user.getuName());
			flowHistroy.setActorresult(0);
			flowHistroy.setView("");
			try {
				string = flowUtill.zancunFlow(currentFlow,flowHistroy);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return i; 
	}
	
	
	@RequestMapping("/addProjectTraceLogBySubmit")
	@ResponseBody
	public String addProjectTraceLogBySubmit(ProjectTraceLog traceLog,HttpServletRequest request,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		traceLog.setPtlId(id);
		String name=(String) request.getSession().getAttribute("name");
		traceLog.setPtlName(name);
		int i=pservice.addProjectTraceLog(traceLog);
		String string = i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(traceLog.getSponsorDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(traceLog.getPrjName()+"项目跟踪日志申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(traceLog.getPrjName()+"项目跟踪日志申请流程发起");
			currentFlow.setUrl("jingyingguanliLook/ProjectTrackingGZRZ.html-"+id);
			currentFlow.setParams("{'cs':'1'}");
			currentFlow.setStarter(user.getUserId());
			currentFlow.setStartername(user.getuName());
			currentFlow.setFkDept(omNo);
			currentFlow.setDeptname(user.getOmName());
			currentFlow.setNodename("节点名称");
			currentFlow.setPri(1);
			currentFlow.setSdtofnode(new Date());
			currentFlow.setSdtofflow(new Date());
			currentFlow.setFlowEndState(2);
			currentFlow.setFlowNopassState(0);
			FlowHistroy flowHistroy = new FlowHistroy();
			flowHistroy.setActor(user.getUserId());
			flowHistroy.setActorname(user.getuName());
			flowHistroy.setActorresult(0);
			flowHistroy.setView("");
			try {
				string = flowUtill.submitGetReceiver(currentFlow,omNo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return string;
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
	
	@RequestMapping("/selectProjectTraceLogById")
	@ResponseBody
	public ProjectTraceLog selectProjectTraceLogById(String id){
		ProjectTraceLog prjLog=pservice.selectProjectTraceLogById(id);
		return prjLog; 
	}
	
}
