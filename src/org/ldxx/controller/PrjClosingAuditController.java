package org.ldxx.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.PrjClosingAudit;
import org.ldxx.bean.PrjClosingAuditPerson;
import org.ldxx.bean.Task;
import org.ldxx.bean.User;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.PrjClosingAuditService;
import org.ldxx.service.TaskService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("audit")
public class PrjClosingAuditController {

	@Autowired
	private PrjClosingAuditService service;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private TaskService tService;
	
	@RequestMapping("/addPrjClosingAudit")
	@ResponseBody
	public int addPrjClosingAudit(@RequestBody PrjClosingAudit audit,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		audit.setPcId(id);
		int i=service.addPrjClosingAudit(audit);
		if(i>0){
			Task t=tService.selectPrjLeaderByPrjNo(audit.getPrjNo());
			String mainDepartment=t.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(audit.getPrjName()+"项目结算审计");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(audit.getPrjName()+"项目结算审计保存");
			currentFlow.setUrl("shengchanguanliLook/ProjectSettlement.html-"+id);
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
	
	@RequestMapping("/addPrjClosingAuditBySubmit")
	@ResponseBody
	public String addPrjClosingAuditBySubmit(@RequestBody PrjClosingAudit audit,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		audit.setPcId(id);
		int i=service.addPrjClosingAudit(audit);
		String string = i+"";
		if(i>0){
			Task t=tService.selectPrjLeaderByPrjNo(audit.getPrjNo());
			String mainDepartment=t.getMainDepartment();
			OrganizationManagement om=oService.selectOrgById(mainDepartment);
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(audit.getPrjName()+"项目结算审计");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(audit.getPrjName()+"项目结算审计提交");
			currentFlow.setUrl("shengchanguanliLook/ProjectSettlement.html-"+id);
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
	
	@RequestMapping("/selectPrjClosingAudit")
	@ResponseBody
	public List<PrjClosingAudit> selectPrjClosingAudit(){
		List<PrjClosingAudit> list=service.selectPrjClosingAudit();
		return list;
	}
	
	@RequestMapping("/selectPrjClosingAuditById")
	@ResponseBody
	public PrjClosingAudit selectPrjClosingAuditById(String id){
		PrjClosingAudit audit=service.selectPrjClosingAuditById(id);
		List<PrjClosingAuditPerson> person=service.selectPrjClosingAuditPersonById(id);
		audit.setPerson(person);
		return audit;
	}
	
}
