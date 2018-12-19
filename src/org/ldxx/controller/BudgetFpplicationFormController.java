package org.ldxx.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.ldxx.bean.BudgetFpplicationForm;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.User;
import org.ldxx.service.BudgetFpplicationFormService;
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
	
	@RequestMapping("/saveBudge")
	@ResponseBody
	public Map<String,Object> saveBudge(@RequestBody List<BudgetFpplicationForm> budges){
		Map<String,Object> map = new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		BudgetFpplicationForm budge = budges.get(0);
		budge.setBfId(id);
		int count=bservice.countNo();
		String code="YS"+uuid.getPrjCode("", count+1);
		budge.setBfNo(code);
		int i=bservice.saveBudge(budge);
		map.put("result", i);
		map.put("budge", budge);
		return map;
	}
	
	@RequestMapping("/submitBudge")
	@ResponseBody
	public Map<String,Object> submitBudge(@RequestBody List<BudgetFpplicationForm> budges){
		Map<String,Object> map = new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		BudgetFpplicationForm budge = budges.get(0);
		budge.setBfId(id);
		int count=bservice.countNo();
		String code="YS"+uuid.getPrjCode("", count+1);
		budge.setBfNo(code);
		int i=bservice.saveBudge(budge);
		map.put("result", i);
		map.put("budge", budge);
		return map;
	}
	
	@RequestMapping("/deleteBudgeById")
	@ResponseBody
	public int deleteBudgeById(String id){
		return bservice.deleteBudgeById(id);
	}
	
	@RequestMapping("/updateBudgeSave")
	@ResponseBody
	public Map<String,Object> updateBudgeSave(@RequestBody List<BudgetFpplicationForm> budges){
		Map<String,Object> map = new HashMap<>();
		BudgetFpplicationForm budge = budges.get(0);
		//int i=bservice.changeStateById(budge.getBfId());//修改历史状态为0
		//if(i>0){
		String newId=new TimeUUID().getTimeUUID();
		budge.setBfId(newId);
		int i=bservice.saveBudge(budge);
		//}
		map.put("result", i);
		map.put("budge", budge);
		return map;
	}
	
	@RequestMapping("/updateBudgeSubmit")
	@ResponseBody
	public String updateBudgeSubmit(@RequestBody List<BudgetFpplicationForm> budges,HttpSession session){
		BudgetFpplicationForm budge = budges.get(0);
		//int i=bservice.changeStateById(budge.getBfId());
		//if(i>0){
		String newId=new TimeUUID().getTimeUUID();
		budge.setBfId(newId);
		int i=bservice.saveBudge(budge);
		//}
		String string = i+"";
		if(i>0){
			User user = (User) session.getAttribute("user");
			FlowUtill flowUtill = new FlowUtill();
			CurrentFlow currentFlow = new CurrentFlow();
			currentFlow.setParams("1");
			currentFlow.setTitle(budge.getPrjId());
			currentFlow.setActor(user.getUserId());
			currentFlow.setActorname(user.getUsername());;
			currentFlow.setMemo(budge.getPrjId()+"预算流程发起");
			currentFlow.setUrl("shengchanGuanliLook/BudgetManagement.html-"+newId);
			currentFlow.setParams("{'cs':'1'}");
			currentFlow.setStarter(user.getUserId());
			currentFlow.setStartername(user.getuName());
			currentFlow.setFkDept("1");
			currentFlow.setDeptname(user.getOmName());
			currentFlow.setNodename("节点名称");
			currentFlow.setPri(1);
			currentFlow.setSdtofnode(new Date());
			currentFlow.setSdtofflow(new Date());
			currentFlow.setFlowEndState(2);
			FlowHistroy flowHistroy = new FlowHistroy();
			flowHistroy.setActor(user.getUserId());
			flowHistroy.setActorname(user.getUsername());
			flowHistroy.setActorresult(0);
			flowHistroy.setView("");
			try {
				string = flowUtill.submitGetReceiver(currentFlow,"1");
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
}
