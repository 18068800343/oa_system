package org.ldxx.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.BudgetFpplicationForm;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.User;
import org.ldxx.service.BudgetFpplicationFormService;
import org.ldxx.service.OrganizationManagementService;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 预算单管理
 * @author hp
 *
 */
@Controller
@RequestMapping("budge")
public class BudgetFpplicationFormController {

	@Autowired
	private BudgetFpplicationFormService bservice;
	@Autowired
	private OrganizationManagementService oService;
	
	@RequestMapping("/saveBudge")
	@ResponseBody
	public int saveBudge(@RequestBody List<BudgetFpplicationForm> budges,HttpSession session){
		Map<String,Object> map = new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		BudgetFpplicationForm budge = budges.get(0);
		budge.setBfId(id);
		int count=bservice.countNo();
		String code="YS"+uuid.getPrjCode("", count+1);
		budge.setBfNo(code);
		int i=bservice.saveBudge(budge);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(budge.getDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(budge.getPrjId()+"预算");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(budge.getPrjId()+"预算流程发起");
			currentFlow.setUrl("shengchanguanliLook/BudgetManagement.html-"+id);
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
	
	@RequestMapping("/submitBudge")
	@ResponseBody
	public String submitBudge(@RequestBody List<BudgetFpplicationForm> budges,HttpSession session){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		BudgetFpplicationForm budge = budges.get(0);
		budge.setBfId(id);
		int count=bservice.countNo();
		String code="YS"+uuid.getPrjCode("", count+1);
		budge.setBfNo(code);
		int i=bservice.saveBudge(budge);
		String string = i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(budge.getDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(budge.getPrjId());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());;
			currentFlow.setMemo(budge.getPrjId()+"预算流程发起");
			currentFlow.setUrl("shengchanguanliLook/BudgetManagement.html-"+id);
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
			flowHistroy.setActorname(user.getUsername());
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
	
	@RequestMapping("/deleteBudgeById")
	@ResponseBody
	public int deleteBudgeById(String id){
		return bservice.deleteBudgeById(id);
	}
	
	@RequestMapping("/updateBudgeSave")
	@ResponseBody
	public Map<String,Object> updateBudgeSave(@RequestBody List<BudgetFpplicationForm> budges,HttpSession session){
		Map<String,Object> map = new HashMap<>();
		BudgetFpplicationForm budge = budges.get(0);
		String newId=new TimeUUID().getTimeUUID();
		budge.setBfId(newId);
		int i=bservice.saveBudge(budge);
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(budge.getDepartment());
			String omNo=om.getOmNo();
			String string="";
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(budge.getPrjId()+"预算变更");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(budge.getPrjId()+"预算变更");
			currentFlow.setUrl("shengchanguanliLook/BudgetManagement.html-"+newId);
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
		map.put("budge", budge);
		return map;
	}
	
	@RequestMapping("/updateBudgeSubmit")
	@ResponseBody
	public String updateBudgeSubmit(@RequestBody List<BudgetFpplicationForm> budges,HttpSession session){
		Map<String,Object> map = new HashMap<>();
		BudgetFpplicationForm budge = budges.get(0);
		String newId=new TimeUUID().getTimeUUID();
		budge.setBfId(newId);
		int i=bservice.saveBudge(budge);
		String string = i+"";
		if(i>0){
			OrganizationManagement om=oService.selectOrgById(budge.getDepartment());
			String omNo=om.getOmNo();
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(budge.getPrjId()+"预算变更");
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getuName());
			currentFlow.setMemo(budge.getPrjId()+"预算变更流程发起");
			currentFlow.setUrl("shengchanguanliLook/BudgetManagement.html-"+newId);
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
			flowHistroy.setActorname(user.getUsername());
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
	
	@RequestMapping("/selectBudgeByStatus")
	@ResponseBody
	public List<BudgetFpplicationForm> selectBudgeByStatus(String status,String timeMin,String timeMax,@RequestParam(defaultValue="0")float costMin,@RequestParam(defaultValue="0")float costMax){
		return bservice.selectBudgeByStatus(status,timeMin,timeMax,costMin,costMax);
	}
	
	@RequestMapping("/selectBudgeById")
	@ResponseBody
	public BudgetFpplicationForm selectBudgeById(String id){
		return bservice.selectBudgeById(id);
	}
	
	@RequestMapping("/selectBudgeHistory")
	@ResponseBody
	public List<BudgetFpplicationForm> selectBudgeHistory(String no){
		List<BudgetFpplicationForm> budgeHistoryList=bservice.selectBudgeHistory(no);
		return budgeHistoryList;
	}
	
	@RequestMapping("/selectBudgeByNo")
	@ResponseBody
	public BudgetFpplicationForm selectBudgeByNo(String no){
		return bservice.selectBudgeByNo(no);
	}
	
	@RequestMapping("/selectBudgeByName")
	@ResponseBody
	public BudgetFpplicationForm selectBudgeByName(String name){
		return bservice.selectBudgeByName(name);
	}
	
	@RequestMapping("/getAllCost")
	@ResponseBody
	public BudgetFpplicationForm getAllCost(String no){
		BudgetFpplicationForm cost=bservice.getAllCost(no);
		return cost;
	}
	
	@RequestMapping("/updateHistoryById")
	@ResponseBody
	public int updateHistoryById(String id){
		int i=bservice.updateHistoryById(id);
		return i;
	}
	
	@RequestMapping("/updateBudgetById")
	@ResponseBody
	public int updateBudgetById(@RequestBody List<BudgetFpplicationForm> budge){
		BudgetFpplicationForm b=budge.get(0);
		int i=bservice.updateBudge(b);
		return i;
	}
}
