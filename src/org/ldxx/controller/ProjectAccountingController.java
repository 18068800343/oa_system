package org.ldxx.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FbContract;
import org.ldxx.bean.FbContractOver;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.ProjectAccounting;
import org.ldxx.bean.Task;
import org.ldxx.bean.User;
import org.ldxx.service.FbContractOverService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.ProjectAccountingService;
import org.ldxx.service.SubContractService;
import org.ldxx.service.TaskService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 项目核算管理
 * @author hp
 *
 */

@RequestMapping("projectaccounting")
@Controller
public class ProjectAccountingController {
	
	@Autowired
	private ProjectAccountingService service;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private TaskService tService;
	@Autowired
	private SubContractService scService;//分包合同
	@Autowired
	private FbContractOverService fbOverservice;//分包结算
	
	@RequestMapping("/selectProjectAccounting")
	@ResponseBody
	public List<ProjectAccounting> selectProjectAccounting(String status){
		List<ProjectAccounting> list= service.selectProjectAccounting(status);
		for(int i=0;i<list.size();i++){
			String prjNo = list.get(i).getPrjNo();
			List<FbContract> subcontract=scService.selectFbContractByTaskNo(prjNo);//去查该任务单下有几个分包合同
			List<FbContractOver> fbJs = fbOverservice.selectFbJsByNo(prjNo);//去查该任务单下已结算的分包合同
			if(fbJs.size()==0||fbJs==null){
				list.get(i).setJsState("2");//未结算
			}else if(subcontract.size()==fbJs.size()){
				list.get(i).setJsState("0");//全部结算
			}else{
				list.get(i).setJsState("1");//部分结算
			}
		}
		return list;
	}
	
	@RequestMapping("/selectTaskByNo")
	@ResponseBody
	public List<Task> selectTaskByNo(){
		List<Task> list= tService.selectPrjNameAndWorkNo();
		for(int i=0;i<list.size();i++){
			String prjNo = list.get(i).getPrjNo();
			List<FbContract> subcontract=scService.selectFbContractByTaskNo(prjNo);//去查该任务单下有几个分包合同
			List<FbContractOver> fbJs = fbOverservice.selectFbJsByNo(prjNo);//去查该任务单下已结算的分包合同
			if(fbJs.size()==0||fbJs==null){
				list.get(i).setJsState("2");//未结算
			}else if(subcontract.size()==fbJs.size()){
				list.get(i).setJsState("0");//全部结算
			}else{
				list.get(i).setJsState("1");//部分结算
			}
		}
		return list;
	}
	
	@RequestMapping("/getProjectAccountingById")
	@ResponseBody
	public ProjectAccounting getProjectAccountingById(String id){
		return service.getProjectAccountingById(id);
	}
	
	
	@RequestMapping("/addProjectAccounting")
	@ResponseBody
	public Map<String,Object> addProjectAccounting(@RequestBody ProjectAccounting projectAccounting,HttpSession session){
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		projectAccounting.setPaId(id);
		projectAccounting.setHsNo("HS"+projectAccounting.getPrjNo());
		int i=service.addProjectAccounting(projectAccounting);
		if(i>0){
			OrganizationManagement organizationManagement = oService.getOrgIdByName(projectAccounting.getCjDepartment());
			OrganizationManagement om=oService.selectOrgById(organizationManagement.getOmId());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(projectAccounting.getPrjName()+"核算");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(projectAccounting.getPrjName()+"核算流程发起");
			currentFlow.setUrl("shengchanguanliLook/hesuan.html-"+id);
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
		map.put("result", i);
		map.put("ProjectAccounting", projectAccounting);
		return map;
	}
	
	@RequestMapping("/addProjectAccountingSubmit")
	@ResponseBody
	public String addProjectAccountingSubmit(@RequestBody ProjectAccounting projectAccounting,HttpSession session){
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		projectAccounting.setPaId(id);
		projectAccounting.setHsNo("HS"+projectAccounting.getPrjNo());
		int i=service.addProjectAccounting(projectAccounting);
		String string = i+"";
		if(i>0){
			OrganizationManagement organizationManagement = oService.getOrgIdByName(projectAccounting.getCjDepartment());
			OrganizationManagement om=oService.selectOrgById(organizationManagement.getOmId());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(projectAccounting.getPrjName()+"核算");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(projectAccounting.getPrjName()+"核算流程发起");
			currentFlow.setUrl("shengchanguanliLook/hesuan.html-"+id);
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
		/*map.put("result", i);
		map.put("ProjectAccounting", projectAccounting);
		return map;*/
	}

}
