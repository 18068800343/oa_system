package org.ldxx.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.ClRemain;
import org.ldxx.bean.CompanyMateriaOut;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.GsClOut;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.Task;
import org.ldxx.bean.User;
import org.ldxx.service.ClRemainService;
import org.ldxx.service.GsMaterialOutService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.TaskService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("ClRemain")
public class ClRemainController {

	@Autowired
	private ClRemainService service;
	@Autowired
	private GsMaterialOutService gsoutservice;
	@Autowired
	private TaskService tService;
	@Autowired
	private OrganizationManagementService oService;
	
	@RequestMapping("/addClRemain")
	@ResponseBody
	public int addClRemain(@RequestBody List<ClRemain> cr,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String gs_out_id="";
		for(int a=0;a<cr.size();a++){
			String id=uuid.getTimeUUID();
			cr.get(a).setCrId(id);
			gs_out_id=cr.get(a).getGsOutId();
		}
		int i=service.addClRemain(cr);
		if(i>0){
			CompanyMateriaOut GsMaterialOut = gsoutservice.selectGsMaterialOutById(gs_out_id);
			Task task = tService.selectTaskPrjName(GsMaterialOut.getTaskNo());
			OrganizationManagement om=oService.selectOrgById(task.getMainDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(GsMaterialOut.getPickProject()+"项目材料结余申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(GsMaterialOut.getPickProject()+"项目材料结余申请流程发起");
			currentFlow.setUrl("shengchanGuanli/ContractManagementLook.html-"+gs_out_id);
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
	
	@RequestMapping("/addClRemainSubmit")
	@ResponseBody
	public String addClRemainSubmit(@RequestBody List<ClRemain> cr,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String gs_out_id="";
		for(int a=0;a<cr.size();a++){
			String id=uuid.getTimeUUID();
			cr.get(a).setCrId(id);
			gs_out_id=cr.get(a).getGsOutId();
		}
		int i=service.addClRemain(cr);
		String string = i+"";
		if(i>0){
			CompanyMateriaOut GsMaterialOut = gsoutservice.selectGsMaterialOutById(gs_out_id);
			Task task = tService.selectTaskPrjName(GsMaterialOut.getTaskNo());
			OrganizationManagement om=oService.selectOrgById(task.getMainDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(GsMaterialOut.getPickProject()+"项目材料结余申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(GsMaterialOut.getPickProject()+"项目材料结余申请流程发起");
			currentFlow.setUrl("shengchanguanliLook/BalanceManagementXM.html-"+gs_out_id);
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
	
	@RequestMapping("/selectGsClOutById")
	@ResponseBody
	public List<GsClOut> selectGsClOutById(String id){
		List<GsClOut> list=service.selectGsClOutById(id);
		return list;
	}
	
	@RequestMapping("/remainUse")
	@ResponseBody
	public int remainUse(@RequestBody CompanyMateriaOut cm){
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		cm.setCmoId(id);
		int i=service.remainUse(cm);
		return i;
	}
	
	@RequestMapping("/selectClRemainById")//根据gs_out_id查找结余材料信息
	@ResponseBody
	public List<ClRemain> selectClRemainById(String id){
		List<ClRemain> list=service.selectClRemainById(id);
		return list;
	}
	
}
