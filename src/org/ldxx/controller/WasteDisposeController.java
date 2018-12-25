package org.ldxx.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.CompanyMateriaOut;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.Task;
import org.ldxx.bean.User;
import org.ldxx.bean.WasteDispose;
import org.ldxx.bean.WasteDisposeCl;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.TaskService;
import org.ldxx.service.WasteDisposeService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("wd")
public class WasteDisposeController {

	@Autowired
	private WasteDisposeService service;
	@Autowired
	private TaskService tService;
	@Autowired
	private OrganizationManagementService oService;
	
	@RequestMapping("/selectWasteDispose")
	@ResponseBody
	public List<WasteDispose> selectWasteDispose(){
		List<WasteDispose> list=service.selectWasteDispose();
		return list;
	}
	
	@RequestMapping("/selectWasteDisposeById")//通过id查看废旧品详细信息
	@ResponseBody
	public WasteDispose selectWasteDisposeById(String id){
		WasteDispose wd=service.selectWasteDisposeById(id);
		return wd;
	}
	
	@RequestMapping("/selectWdById")
	@ResponseBody
	public List<WasteDisposeCl> selectWdById(String id){
		List<WasteDisposeCl> list=service.selectWdById(id);
		return list;
	}
	
	@RequestMapping("/addWasteDispose")
	@ResponseBody
	public int addWasteDispose(@RequestBody WasteDispose wd,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		wd.setWpId(id);
		int i=service.addWasteDispose(wd);
		if(i>0){
			Task task = tService.selectTaskPrjName(wd.getTaskNo());
			OrganizationManagement om=oService.selectOrgById(task.getMainDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(wd.getPickProject()+"项目材料废旧品申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(wd.getPickProject()+"项目材料废旧品申请流程发起");
			currentFlow.setUrl("shengchanguanliLook/WasteDisposalXM.html-"+id);
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
	
	@RequestMapping("/addWasteDisposeSubmit")
	@ResponseBody
	public String  addWasteDisposeSubmit(@RequestBody WasteDispose wd,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		wd.setWpId(id);
		int i=service.addWasteDispose(wd);
		String string = i+"";
		if(i>0){
			Task task = tService.selectTaskPrjName(wd.getTaskNo());
			OrganizationManagement om=oService.selectOrgById(task.getMainDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(wd.getPickProject()+"项目材料废旧品申请");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(wd.getPickProject()+"项目材料废旧品申请流程发起");
			currentFlow.setUrl("shengchanguanliLook/WasteDisposalXM.html-"+id);
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
}
