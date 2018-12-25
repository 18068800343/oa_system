package org.ldxx.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.GsMaterialWastetreatment;
import org.ldxx.bean.GsMaterialWastetreatmentCl;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.Task;
import org.ldxx.bean.User;
import org.ldxx.service.GsMaterialWastetreatmentService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.service.TaskService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 废旧品处理
 * @author hp
 *
 */
@RequestMapping(" GsMaterialWaste")
@Controller
public class GsMaterialWastetreatmentController {
	
	@Autowired
	private GsMaterialWastetreatmentService service;
	@Autowired
	private OrganizationManagementService oService;
	@Autowired
	private TaskService tService;
	
	@RequestMapping("/selectGsMaterialWastetreatment")
	@ResponseBody
	public List<GsMaterialWastetreatment> selectGsMaterialWastetreatment(String type,String status){
		return service.selectGsMaterialWastetreatment(type,status);
	}
	
	
	@RequestMapping("/addGsMaterialWastetreatmentSave")
	@ResponseBody
	public Map<String,Object> addGsMaterialWastetreatmentSave(@RequestBody GsMaterialWastetreatment mw,HttpSession session){
		Map<String,Object> map=new HashMap<String,Object>();
		TimeUUID uid=new TimeUUID();
		String id = uid.getTimeUUID();
		mw.setCmwId(id);
		int i=service.addGsMaterialWastetreatmentSave(mw);
		if(i>0){
			Task task = tService.selectTaskPrjName(mw.getPrjNo());
			OrganizationManagement om=oService.selectOrgById(task.getMainDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			if(mw.getType().equals("0")){
				currentFlow.setTitle(mw.getPrjName()+"公司材料废旧品处理");
				currentFlow.setMemo(mw.getPrjName()+"公司材料废旧品处理流程发起");
				currentFlow.setUrl("shengchanguanliLook/WasteDisposal.html-"+id);
			}else{
				currentFlow.setTitle(mw.getPrjName()+"公司材料退货处理");
				currentFlow.setMemo(mw.getPrjName()+"公司材料退货处理流程发起");
				currentFlow.setUrl("shengchanguanliLook/tuihuo.html-"+id);
			}
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
		map.put("GsMaterialWastetreatment", mw);
		return map;
	}
	
	@RequestMapping("/addGsMaterialWastetreatmentSubmit")
	@ResponseBody
	public String addGsMaterialWastetreatmentSubmit(@RequestBody GsMaterialWastetreatment mw,HttpSession session){
		Map<String,Object> map=new HashMap<String,Object>();
		TimeUUID uid=new TimeUUID();
		String id = uid.getTimeUUID();
		mw.setCmwId(id);
		int i=service.addGsMaterialWastetreatmentSave(mw);
		String string = i+"";
		if(i>0){
			Task task = tService.selectTaskPrjName(mw.getPrjNo());
			OrganizationManagement om=oService.selectOrgById(task.getMainDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			if(mw.getType().equals("0")){
				currentFlow.setTitle(mw.getPrjName()+"公司材料废旧品处理");
				currentFlow.setMemo(mw.getPrjName()+"公司材料废旧品处理流程发起");
				currentFlow.setUrl("shengchanguanliLook/WasteDisposal.html-"+id);
			}else{
				currentFlow.setTitle(mw.getPrjName()+"公司材料退货处理");
				currentFlow.setMemo(mw.getPrjName()+"公司材料退货处理流程发起");
				currentFlow.setUrl("shengchanguanliLook/tuihuo.html-"+id);
			}
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
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
		map.put("GsMaterialWastetreatment", mw);
		return map;*/
	}
	
	@RequestMapping("/selectGsMaterialWastetreatmentById")
	@ResponseBody
	public GsMaterialWastetreatment selectGsMaterialWastetreatmentById(String id){
		return service.selectGsMaterialWastetreatmentById(id);
	}
	
	
	@RequestMapping("/selectGsMaterialWastetreatmentClById")//查找材料信息
	@ResponseBody
	public List<GsMaterialWastetreatmentCl> selectGsMaterialWastetreatmentClById(String id){
		return service.selectGsMaterialWastetreatmentClById(id);
	}
	
}
